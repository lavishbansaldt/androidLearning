package com.example.androidlearning;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerDemoMyFragmentPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> mArrayList;


    public ViewPagerDemoMyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> arrayList){
        super(fm);
        mArrayList= arrayList;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mArrayList.get(position);
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }
}
