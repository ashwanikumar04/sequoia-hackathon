package com.aksm.service;

import com.aksm.domain.Plan;
import com.aksm.dto.PagingContainerDto;
import com.aksm.dto.PlanSearchDto;

import java.util.List;

/**
 * Created by AshwaniK on 9/10/2016.
 */
public interface PlanService {

    PagingContainerDto<List<Plan>> getPlan(PlanSearchDto searchDto);

}
