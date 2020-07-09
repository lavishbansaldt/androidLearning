package com.example.androidlearning;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentsDemo extends AppCompatActivity {

    Button btn;
    static final String STATE_FRAGMENT = "state_of_fragment";
    static boolean isFragmentDisplayed= false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        btn= (Button) findViewById(R.id.btn);

        if (savedInstanceState != null) {
            isFragmentDisplayed =
                    savedInstanceState.getBoolean(STATE_FRAGMENT);
            if (isFragmentDisplayed) {
                btn.setText("SUBMIT");
            }
        }
    }

    public void review(View view){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();



        if(isFragmentDisplayed){
            btn.setText("REVIEW");
            FragmentsDemoMyFragment frag= (FragmentsDemoMyFragment)getSupportFragmentManager().findFragmentById(R.id.container);
            if(frag !=null){
                ft.remove(frag).commit();
            }
            isFragmentDisplayed= false;



        }else{
            btn.setText("SUBMIT");
            FragmentsDemoMyFragment myFrag = new FragmentsDemoMyFragment();
            ft.add(R.id.container, myFrag).addToBackStack(null).commit() ;
            isFragmentDisplayed= true;

        }


    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean(STATE_FRAGMENT, isFragmentDisplayed);
        super.onSaveInstanceState(savedInstanceState);
    }
}