package com.aksm.domain;

import com.aksm.common.Constants;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by AshwaniK on 9/10/2016.
 */
@Document(indexName = Constants.INDEX_NAME, type = Constants.TYPE_MOVIE, shards = 1, replicas = 0, refreshInterval = "-1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    private String id;
    private String name;
}
