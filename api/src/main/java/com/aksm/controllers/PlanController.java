package com.aksm.controllers;

import com.aksm.dto.PlanSearchDto;
import com.aksm.service.PlanService;
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
@RequestMapping(value = "/plans",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class PlanController {

    @Autowired
    PlanService planService;

    @RequestMapping(method = RequestMethod.POST,
            value = "/search")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> search(@RequestBody @Valid PlanSearchDto planSearchDto) {

        return ResponseEntity.ok(planService.getPlan(planSearchDto));
    }


}

