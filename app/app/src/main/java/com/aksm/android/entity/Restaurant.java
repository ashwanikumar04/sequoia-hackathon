package com.aksm.android.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

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
public class Restaurant {
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("cuisines")
    private String cuisines;
    @SerializedName("average_cost_for_two")
    private int averageCostForTwo;
    @SerializedName("price_range")
    private int priceRange;
    @SerializedName("currency")
    private String currency;
    @SerializedName("offers")
    private List<Object> offers = new ArrayList<>();
    @SerializedName("thumb")
    private String thumb;
    @SerializedName("user_rating")
    private UserRating userRating;
    @SerializedName("photos_url")
    private String photosUrl;
    @SerializedName("menu_url")
    private String menuUrl;
    @SerializedName("featured_image")
    private String featuredImage;
    @SerializedName("has_online_delivery")
    private int hasOnlineDelivery;
    @SerializedName("is_delivering_now")
    private int isDeliveringNow;
    @SerializedName("deeplink")
    private String deeplink;
    @SerializedName("events_url")
    private String eventsUrl;

}