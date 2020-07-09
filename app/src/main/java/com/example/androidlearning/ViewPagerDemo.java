package com.example.androidlearning;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class ViewPagerDemo extends AppCompatActivity {

    ViewPager viewPager;
    ViewPagerDemoMyFragmentPagerAdapter adapter;
    ArrayList<Fragment> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        al= getData();
        viewPager= (ViewPager)findViewById(R.id.viewPager);
        adapter= new ViewPagerDemoMyFragmentPagerAdapter(getSupportFragmentManager(), al );
        viewPager.setAdapter(adapter);
    }


    @Override
    public void onBackPressed() {
        if(viewPager.getCurrentItem() == 0){
            super.onBackPressed();
        }else{
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
        }


    }

    private static ArrayList<Fragment> getData(){
        ArrayList<Fragment> result = new ArrayList<Fragment>();
        result.add(ViewPagerDemoMyFragment.newInstance("Fragment 1"));
        result.add(ViewPagerDemoMyFragment.newInstance("Fragment 2"));
        result.add(ViewPagerDemoMyFragment.newInstance("Fragment 3"));
        result.add(ViewPagerDemoMyFragment.newInstance("Fragment 4"));

        return result;

    }
}