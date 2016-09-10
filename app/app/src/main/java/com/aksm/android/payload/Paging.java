package com.aksm.android.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Builder;

/**
 * Created by AshwaniK on 9/10/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
public class Paging {
    private int start;
    private int end;
    private Sort sort;
    private int total;
}
