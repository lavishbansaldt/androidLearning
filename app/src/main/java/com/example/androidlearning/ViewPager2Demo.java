package com.example.androidlearning;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class ViewPager2Demo extends AppCompatActivity {
    ArrayList<Integer> al;
    ViewPager2DemoViewPagerAdapter adapter;
    ViewPager2 viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager2);

        al= getData();
        viewPager= (ViewPager2)findViewById(R.id.viewPager);
        adapter= new ViewPager2DemoViewPagerAdapter(al);
        viewPager.setAdapter(adapter);

        //ORIENTATION is set by the Layout Manager
        viewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);


        //To add fake drag animation
        /*viewPager.beginFakeDrag();
        viewPager.fakeDragBy(-100f);
        viewPager.endFakeDrag();*/
    }

    @Override
    public void onBackPressed() {
        if(viewPager.getCurrentItem() == 0){
            super.onBackPressed();
        }else{
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
        }

    }

    private ArrayList<Integer> getData(){
        ArrayList<Integer> result= new ArrayList<>();

        result.add(R.drawable.android1);
        result.add(R.drawable.android2);
        result.add(R.drawable.android3);

        return result;
    }
}