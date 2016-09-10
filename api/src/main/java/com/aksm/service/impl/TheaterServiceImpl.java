package com.aksm.service.impl;

import com.aksm.domain.Theater;
import com.aksm.repository.TheaterJPARepository;
import com.aksm.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by AshwaniK on 9/10/2016.
 */
@Service
public class TheaterServiceImpl implements TheaterService {
    @Autowired
    TheaterJPARepository theaterJPARepository;

    @Override
    public Theater getTheatersById(String id) {
        Theater theater = Theater.builder().venueCode("ATBL").build();
        theaterJPARepository.save(theater);
        return theaterJPARepository.findOne(id);
    }

    @Override
    public List<Theater> getTheatersByName(String name) {
        return null;
    }
}
