package com.aksm.repository;

import com.aksm.common.Constants;
import com.aksm.domain.Theater;
import com.aksm.dto.PagingContainerDto;
import com.aksm.dto.PagingDto;
import com.aksm.dto.SortDto;
import com.aksm.dto.PlanSearchDto;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AshwaniK on 9/10/2016.
 */
@Repository
public class TheaterRepository {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    public PagingContainerDto<List<Theater>> findByGeoLocation(PlanSearchDto searchDto) {
        GeoDistanceQueryBuilder filter = QueryBuilders.geoDistanceQuery("location").point(searchDto.getLat(), searchDto.getLon()).distance(searchDto.getDistance(), DistanceUnit.KILOMETERS);

        if (searchDto.getPaging().getSort() == null) {
            searchDto.getPaging().setSort(SortDto
                    .builder()
                    .order(SortOrder.ASC)
                    .build());
        }
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withFilter(filter)
                .withPageable(new PageRequest(searchDto
                        .getPaging()
                        .getStart(),
                        searchDto.getPaging().getEnd()))
                .withSort(SortBuilders
                        .geoDistanceSort("location")
                        .point(searchDto.getLat(), searchDto.getLon())
                        .order(searchDto.getPaging().getSort()
                                .getOrder()))
                .build();

        searchQuery.addIndices(Constants.INDEX_NAME);
        searchQuery.addTypes(Constants.TYPE_THEATER);
        PagingContainerDto<List<Theater>> theaters = new PagingContainerDto<>();
        theaters.setData(elasticsearchTemplate.queryForList(searchQuery, Theater.class));
        theaters.setPaging(PagingDto
                .builder()
                .start(searchDto
                        .getPaging()
                        .getStart())
                .end(theaters.getData() == null ? 0 : theaters.getData().size())
                .total((int) elasticsearchTemplate.count(searchQuery))
                .build());
        return theaters;
    }
}
