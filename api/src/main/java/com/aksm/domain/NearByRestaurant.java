package com.aksm.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Created by AshwaniK on 9/10/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NearByRestaurant {

    @JsonProperty("restaurant")
    private Restaurant restaurant;

}