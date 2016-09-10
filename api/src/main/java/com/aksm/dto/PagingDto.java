package com.aksm.dto;

import lombok.*;

/**
 * Created by AshwaniK on 9/10/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagingDto {
    private int start;
    private int end;
    private int total;
}
