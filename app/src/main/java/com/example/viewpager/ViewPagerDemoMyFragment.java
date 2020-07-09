package com.example.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.androidlearning.R;

public class ViewPagerDemoMyFragment extends Fragment {


    private static final String TEXT_FOR_FRAGMENT = "TEXT_FOR_FRAGMENT";



    private String mParam1;
    private String mParam2;

    public ViewPagerDemoMyFragment() {

    }



    public static ViewPagerDemoMyFragment newInstance(String param1) {
        ViewPagerDemoMyFragment fragment = new ViewPagerDemoMyFragment();
        Bundle args = new Bundle();
        args.putString(TEXT_FOR_FRAGMENT, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(TEXT_FOR_FRAGMENT);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String message= getArguments().getString(TEXT_FOR_FRAGMENT);
        View v=  inflater.inflate(R.layout.my_fragment_layout, container, false);
        TextView textview= (TextView) v.findViewById(R.id.text);
        textview.setText(message);
        return  v;
    }
}