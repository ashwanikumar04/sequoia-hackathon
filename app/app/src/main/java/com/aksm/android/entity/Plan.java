package com.aksm.android.entity;

import android.graphics.Movie;

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
public class Plan {
    private Movie movie;
    private Theater theater;
    private Restaurant restaurant;
}
