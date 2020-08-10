package com.example.androidlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPreferencesDemoActivity2 extends AppCompatActivity {

    private Button mLoad;
    private EditText mUsername;
    private EditText mPassword;
    private String DEFAULT_VALUE ="not found";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_demo2);


        mLoad = findViewById(R.id.load_btn);
        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        Context ctx= this;

        mLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("myPreferences", MODE_PRIVATE);
                String userName = preferences.getString(getString(R.string.com_androidlearning_sharedpreferences_USERNAME), DEFAULT_VALUE);
                String  password = preferences.getString(getString(R.string.com_androidlearning_sharedpreferences_PASSWORD), DEFAULT_VALUE);

                if(userName == DEFAULT_VALUE && password == DEFAULT_VALUE){
                    Toast.makeText(ctx, "Data not found", Toast.LENGTH_LONG).show();
                }else{
                    mUsername.setText(userName);
                    mPassword.setText(password);
                    Toast.makeText(ctx, "Data loaded successfully", Toast.LENGTH_LONG).show();

                }
                }
        });
    }




}