package com.aksm.service.impl;

import com.aksm.domain.NearByRestaurant;
import com.aksm.domain.Plan;
import com.aksm.domain.Theater;
import com.aksm.dto.PagingContainerDto;
import com.aksm.dto.PlanSearchDto;
import com.aksm.repository.RestaurantRepository;
import com.aksm.service.PlanService;
import com.aksm.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AshwaniK on 9/10/2016.
 */
@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    TheaterService theaterService;
    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public PagingContainerDto<List<Plan>> getPlan(PlanSearchDto searchDto) {

        List<NearByRestaurant> restaurants = restaurantRepository.getRestaurants(searchDto);
        PagingContainerDto<List<Theater>> theaters = theaterService.getTheatersInRange(searchDto);

        PagingContainerDto<List<Plan>> plans = new PagingContainerDto<>();

        List<Plan> planList = new ArrayList<>();
        restaurants
                .stream()
                .forEach(x ->
                        theaters
                                .getData()
                                .stream()
                                .forEach(y ->
                                        planList
                                                .add(Plan
                                                        .builder()
                                                        .restaurant(x
                                                                .getRestaurant())
                                                        .theater(y)
                                                        .build())));

        plans.setData(planList);
        return plans;
    }
}
