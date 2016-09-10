package com.aksm.android.web.clients;

import com.aksm.android.payload.PlanSearchPayload;
import com.aksm.android.response.PlanResponse;
import com.aksm.android.web.ApiUrls;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by AshwaniK on 2/28/2016.
 */
public interface PlanClient {
    @POST(ApiUrls.PLAN)
    Call<PlanResponse> getPlans(@Body PlanSearchPayload planSearch);
}
