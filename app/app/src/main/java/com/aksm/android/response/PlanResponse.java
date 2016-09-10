package com.aksm.android.response;

import com.aksm.android.entity.Plan;
import com.aksm.android.payload.Paging;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Builder;

/**
 * Created by AshwaniK on 9/11/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
public class PlanResponse {
    private List<Plan> data;
    private Paging paging;
}
