package com.aksm.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by AshwaniK on 9/10/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterSearchDto {
    @NotNull
    private String distance;
    private double lat;
    private double lon;
    @NotNull
    @Valid
    private PagingDto paging;
}
