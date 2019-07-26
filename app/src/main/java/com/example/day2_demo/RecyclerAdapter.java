package com.example.day2_demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day2_demo.bean.ListData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;

    List<ListData> listData = new ArrayList<>();

    public RecyclerAdapter(Context context) {
        this.context = context;
    }
    public void getData(List<ListData> listData) {
        this.listData.clear();
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context,R.layout.recycle,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ListData listData = this.listData.get(i);
        viewHolder.title.setText(listData.getName());
        viewHolder.count.setText(listData.getOrder()+"");
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView count;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            count=itemView.findViewById(R.id.count);
            title=itemView.findViewById(R.id.title);
        }
    }
}
