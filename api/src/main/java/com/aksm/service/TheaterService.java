package com.aksm.service;

import com.aksm.domain.Theater;

import java.util.List;

/**
 * Created by AshwaniK on 9/10/2016.
 */
public interface TheaterService {

    Theater getTheatersById(String id);

    List<Theater> getTheatersByName(String name);
}
