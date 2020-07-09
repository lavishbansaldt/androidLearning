package com.example.androidlearning;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewDemoMyAdapter extends RecyclerView.Adapter<RecyclerViewDemoMyAdapter.MyViewHolder> {

    private String[] mDataset;

    public RecyclerViewDemoMyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;

        public MyViewHolder(TextView tv){
            super(tv);
            textView = tv;
        }
    }

    @NonNull
    @Override
    public RecyclerViewDemoMyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);
        MyViewHolder mViewHolder= new MyViewHolder(textView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewDemoMyAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
