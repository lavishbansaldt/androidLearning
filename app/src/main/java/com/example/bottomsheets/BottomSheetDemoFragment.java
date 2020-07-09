package com.example.bottomsheets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidlearning.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class BottomSheetDemoFragment extends BottomSheetDialogFragment {




    public BottomSheetDemoFragment() {

    }



    public static BottomSheetDemoFragment newInstance(String param1, String param2) {
        BottomSheetDemoFragment fragment = new BottomSheetDemoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.bottom_sheet, container, false);
    }
}