package com.aksm.android.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aksm.android.R;
import com.aksm.android.entity.Plan;
import com.aksm.android.interfaces.IClickHandler;
import com.aksm.android.utils.Helpers;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AshwaniK on 9/11/2016.
 */
public class PlansAdapter extends RecyclerView.Adapter<PlansAdapter.ItemViewHolder> {

    List<Plan> arrayList;
    IClickHandler handler;
    private LayoutInflater inflater;

    public PlansAdapter(Context context, List<Plan> movies, IClickHandler handler) {
        inflater = LayoutInflater.from(context);
        this.handler = handler;
        this.arrayList = movies;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.app_bar, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view);
        holder.setClickHandler(handler);
        return holder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Plan plan = arrayList.get(position);
        holder.restaurantName.setText(plan.getRestaurant().getName());
        Helpers.recyclerAnim(holder.itemView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        @Bind(R.id.restaurantName)
        TextView restaurantName;
        @Bind(R.id.llWrapper)
        RelativeLayout llWrapper;
        IClickHandler clickHandler;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            llWrapper.setOnClickListener(this);
            llWrapper.setOnLongClickListener(this);
        }

        public IClickHandler getClickHandler() {
            return clickHandler;
        }

        public void setClickHandler(IClickHandler clickHandler) {
            this.clickHandler = clickHandler;
        }

        @Override
        public void onClick(View view) {
            if (getClickHandler() != null) {
                getClickHandler().onItemClicked(view, getLayoutPosition());
            }
        }

        @Override
        public boolean onLongClick(View view) {
            if (getClickHandler() != null) {
                getClickHandler().onItemLongClicked(view, getLayoutPosition());
            }
            return true;
        }
    }

}
