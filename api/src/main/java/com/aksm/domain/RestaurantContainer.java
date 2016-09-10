package com.aksm.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

/**
 * Created by AshwaniK on 9/10/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantContainer {
    @JsonProperty("nearby_restaurants")
    private List<NearByRestaurant> nearbyRestaurants;
}
