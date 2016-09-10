package com.aksm.repository;

import com.aksm.domain.Theater;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AshwaniK on 9/10/2016.
 */
@Repository
public interface TheaterJPARepository extends ElasticsearchRepository<Theater, String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    Page<Theater> findByTheatersUsingCustomQuery(String name, Pageable pageable);
}
