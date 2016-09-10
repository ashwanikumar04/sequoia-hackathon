package com.aksm.controllers;

import com.aksm.dto.TheaterSearchDto;
import com.aksm.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by AshwaniK on 9/10/2016.
 */
@RestController
@RequestMapping(value = "/theaters",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @RequestMapping(method = RequestMethod.GET,
            value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getTheaterById(
            @PathVariable String id) {

        return ResponseEntity.ok(theaterService.getTheatersById(id));
    }

    @RequestMapping(method = RequestMethod.POST,
            value = "/search")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> search(@RequestBody @Valid TheaterSearchDto theaterSearchDto) {

        return ResponseEntity.ok(theaterService.getTheatersInRange(theaterSearchDto));
    }


}

