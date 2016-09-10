package com.aksm.repository;

import com.aksm.domain.Theater;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Theater> getAll() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .build();
        return elasticsearchTemplate.queryForList(searchQuery, Theater.class);
    }

}
