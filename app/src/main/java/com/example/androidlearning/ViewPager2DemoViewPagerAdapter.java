package com.example.androidlearning;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewPager2DemoViewPagerAdapter extends RecyclerView.Adapter<ViewPager2DemoViewPagerAdapter.ViewPagerViewHolder> {


    ArrayList<Integer> al;


    public ViewPager2DemoViewPagerAdapter(ArrayList<Integer> list){
        al= list;
    }

    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ConstraintLayout cl= (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view_pager, parent, false);
        return new ViewPagerViewHolder(cl);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {

        ConstraintLayout view= holder.cl;
        ImageView iView= view.findViewById(R.id.imageView);
        iView.setImageResource(al.get(position));

    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    class ViewPagerViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout cl;
        public ViewPagerViewHolder(ConstraintLayout layout){
            super(layout);
            cl= layout;
        }
    }

}
