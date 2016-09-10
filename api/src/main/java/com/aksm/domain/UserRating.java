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
public class UserRating {
    @JsonProperty("aggregate_rating")
    private String aggregateRating;
    @JsonProperty("rating_text")
    private String ratingText;
    @JsonProperty("rating_color")
    private String ratingColor;
    @JsonProperty("votes")
    private String votes;
}