package com.aksm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * Created by AshwaniK on 9/10/2016.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PagingContainerDto<T> {
    private T data;
    private PagingDto paging;
}
