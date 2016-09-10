package com.aksm.dto;

import lombok.*;
import org.elasticsearch.search.sort.SortOrder;

/**
 * Created by AshwaniK on 9/10/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SortDto {
    SortOrder order;
}
