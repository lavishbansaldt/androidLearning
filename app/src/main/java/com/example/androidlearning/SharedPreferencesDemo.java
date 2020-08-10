package com.example.androidlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPreferencesDemo extends AppCompatActivity {

    private Button mSaveButton;
    private Button mNextButton;
    private EditText mUsername;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        mSaveButton = findViewById(R.id.save_btn);
        mNextButton = findViewById(R.id.next_btn);
        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);

        Context ctx = SharedPreferencesDemo.this;


        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = ctx.getSharedPreferences("myPreferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();


                editor.putString(getString(R.string.com_androidlearning_sharedpreferences_USERNAME), mUsername.getText().toString());
                editor.putString(getString(R.string.com_androidlearning_sharedpreferences_PASSWORD),mPassword.getText().toString());

                editor.apply();
                Toast.makeText(ctx, "Successfully saved.", Toast.LENGTH_LONG).show();

            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextActivityIntent = new Intent(ctx, SharedPreferencesDemoActivity2.class);
                startActivity(nextActivityIntent);
            }
        });
    }
}