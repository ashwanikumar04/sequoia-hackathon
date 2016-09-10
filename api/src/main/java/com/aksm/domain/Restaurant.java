package com.aksm.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AshwaniK on 9/10/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("cuisines")
    private String cuisines;
    @JsonProperty("average_cost_for_two")
    private int averageCostForTwo;
    @JsonProperty("price_range")
    private int priceRange;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("offers")
    private List<Object> offers = new ArrayList<Object>();
    @JsonProperty("thumb")
    private String thumb;
    @JsonProperty("user_rating")
    private UserRating userRating;
    @JsonProperty("photos_url")
    private String photosUrl;
    @JsonProperty("menu_url")
    private String menuUrl;
    @JsonProperty("featured_image")
    private String featuredImage;
    @JsonProperty("has_online_delivery")
    private int hasOnlineDelivery;
    @JsonProperty("is_delivering_now")
    private int isDeliveringNow;
    @JsonProperty("deeplink")
    private String deeplink;
    @JsonProperty("events_url")
    private String eventsUrl;

}