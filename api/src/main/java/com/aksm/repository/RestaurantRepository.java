package com.aksm.repository;

import com.aksm.common.HttpManager;
import com.aksm.domain.NearByRestaurant;
import com.aksm.domain.RestaurantContainer;
import com.aksm.dto.PlanSearchDto;
import com.aksm.utils.Helpers;
import lombok.extern.java.Log;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * Created by AshwaniK on 9/10/2016.
 */
@Repository
@Log
public class RestaurantRepository {

    @Value("${zomato.base.url}")
    private String zomatoUrl;
    @Value("${zomato.apiKey}")
    private String zomatokey;

    public List<NearByRestaurant> getRestaurants(PlanSearchDto planSearchDto) {

        HttpUrl.Builder urlBuilder = HttpUrl
                .parse(zomatoUrl + "geocode")
                .newBuilder();
        urlBuilder.addQueryParameter("lat", planSearchDto.getLat() + "");
        urlBuilder.addQueryParameter("lon", planSearchDto.getLon() + "");
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .header("user-key", zomatokey)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = HttpManager
                    .getInstance()
                    .getOkHttpClient()
                    .newCall(request)
                    .execute();
            if (response.isSuccessful()) {
                RestaurantContainer restaurantContainer = Helpers
                        .fromJsonToObject(response
                                        .body()
                                        .string(),
                                RestaurantContainer.class);
                assert restaurantContainer != null;
                return restaurantContainer.getNearbyRestaurants();

            } else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
