package com.example.bottomsheets;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidlearning.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDemo extends AppCompatActivity {

    private BottomSheetBehavior mSheetBehavior;
    private LinearLayout mBottomSheet;
    private Button mButtonBottomSheet;
    private Button mButtonBottomSheetDialog ;
    private Button mButtonBottomSheetDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        mBottomSheet= findViewById(R.id.bottom_sheet_layout);
        mSheetBehavior= BottomSheetBehavior.from(mBottomSheet);

        mButtonBottomSheet = findViewById(R.id.btnBottomSheet);
        mButtonBottomSheetDialog= findViewById(R.id.btnBottomSheetDialog);
        mButtonBottomSheetDialogFragment= findViewById(R.id.btnBottomSheetDialogFragment);


        mButtonBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED){
                    mSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }else{
                    mSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        // callback for do something
        mSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged( View view, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        mButtonBottomSheet.setText("Close Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        mButtonBottomSheet.setText("Expand Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(View view, float v) {

            }



    });



        mButtonBottomSheetDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dialogView= getLayoutInflater().inflate(R.layout.bottom_sheet, null);
                BottomSheetDialog bottomSheetDialog= new BottomSheetDialog(BottomSheetDemo.this);
                bottomSheetDialog.setContentView(dialogView);
                bottomSheetDialog.show();
            }
        });


        mButtonBottomSheetDialogFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialogFragment bottomSheetFragment= new BottomSheetDemoFragment();
                bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
            }
        });
}}