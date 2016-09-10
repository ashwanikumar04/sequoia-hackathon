package com.aksm.android.entity;


import com.google.gson.annotations.SerializedName;

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
public class UserRating {
    @SerializedName("aggregate_rating")
    private String aggregateRating;
    @SerializedName("rating_text")
    private String ratingText;
    @SerializedName("rating_color")
    private String ratingColor;
    @SerializedName("votes")
    private String votes;
}