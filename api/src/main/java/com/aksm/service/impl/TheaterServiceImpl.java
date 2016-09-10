package com.aksm.service.impl;

import com.aksm.domain.Theater;
import com.aksm.dto.PagingContainerDto;
import com.aksm.dto.PlanSearchDto;
import com.aksm.repository.TheaterJPARepository;
import com.aksm.repository.TheaterRepository;
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
    @Autowired
    TheaterRepository theaterRepository;

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

//    @Override
//    public PagingContainerDto<List<Theater>> getTheatersInRange(PlanSearchDto searchDto) {
//        Page<Theater> page = theaterJPARepository
//                .findTheatersInRange(searchDto.getDistance(), searchDto.getLat(), searchDto.getLon(),
//                        new PageRequest(searchDto.getPaging().getStart(), searchDto.getPaging().getEnd()));
//        PagingContainerDto<List<Theater>> theaters = new PagingContainerDto<>();
//        theaters.setData(page.getContent());
//        theaters.setPaging(PagingDto
//                .builder()
//                .start(searchDto
//                        .getPaging()
//                        .getStart())
//                .end(page
//                        .getNumberOfElements())
//                .total((int) page
//                        .getTotalElements())
//                .build());
//        return theaters;
//    }


    @Override
    public PagingContainerDto<List<Theater>> getTheatersInRange(PlanSearchDto searchDto) {
        return theaterRepository
                .findByGeoLocation(searchDto);
    }
}
