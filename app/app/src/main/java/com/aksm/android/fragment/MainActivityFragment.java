package com.aksm.android.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aksm.android.R;
import com.aksm.android.adapter.PlansAdapter;
import com.aksm.android.entity.Plan;
import com.aksm.android.interfaces.IActionHandler;
import com.aksm.android.interfaces.IClickHandler;
import com.aksm.android.payload.Paging;
import com.aksm.android.payload.PlanSearchPayload;
import com.aksm.android.payload.Sort;
import com.aksm.android.response.PlanResponse;
import com.aksm.android.web.clients.PlanClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.ashwanik.retroclient.entities.ErrorData;
import in.ashwanik.retroclient.interfaces.RequestHandler;
import in.ashwanik.retroclient.service.RetroClientServiceGenerator;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends BaseFragment {

    View view;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    List<Plan> plans;

    IClickHandler handler;

    PlansAdapter adapter;
    RetroClientServiceGenerator serviceGenerator;

    private void loadDataFromApi(int page, final IActionHandler<List<Plan>> actionHandler) {
        PlanClient planClient = serviceGenerator.getService(PlanClient.class, "planClient");

        serviceGenerator.execute(planClient
                        .getPlans(PlanSearchPayload.builder().distance(10L).lat(12.9597).lon(77.7479).paging(Paging.builder().start(0).end(10).sort(Sort.builder().order("ASC").build()).build()).build()),
                new RequestHandler<PlanResponse>() {
                    @Override
                    public void onSuccess(PlanResponse response) {
                        if (actionHandler != null) {
                            actionHandler.handle(response.getData());
                        }
                        plans.addAll(response.getData());
                        int curSize = adapter.getItemCount();
                        adapter.notifyItemRangeInserted(curSize, plans.size() - 1);
                    }

                    @Override
                    public void onError(ErrorData errorData) {
                        showSnackBar(errorData, recyclerView);
                    }
                });
    }

    void initializeRecyclerView() {
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this, view);
        plans = new ArrayList<>();
        serviceGenerator = new RetroClientServiceGenerator(MainActivityFragment.this.getActivity(),
                false);
        handler = new IClickHandler() {
            @Override
            public void onItemClicked(View view, int position) {

            }

            @Override
            public void onItemLongClicked(View view, int position) {

            }

            @Override
            public void onButtonAction(View view, int position) {

            }
        };
        adapter = new PlansAdapter(this.getActivity(), plans, handler);
        //EventBus.getDefault().register(this);
        initializeRecyclerView();
        loadDataFromApi(0, new IActionHandler<List<Plan>>() {
            @Override
            public void handle() {

            }

            @Override
            public void handle(List<Plan> data) {

            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        //  EventBus.getDefault().unregister(this);
    }
}
