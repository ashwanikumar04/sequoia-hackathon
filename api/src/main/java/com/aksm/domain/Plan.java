package com.aksm.domain;

import lombok.*;

/**
 * Created by AshwaniK on 9/10/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plan {
    private Movie movie;
    private Theater theater;
    private Restaurant restaurant;
}
