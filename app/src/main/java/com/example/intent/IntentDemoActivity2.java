package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidlearning.R;

public class IntentDemoActivity2 extends AppCompatActivity {
    TextView textView;
    EditText editText;
    public static String REPLY= "reply";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_2);
        textView = (TextView) findViewById(R.id.textView2);
        editText= (EditText) findViewById(R.id.editText1);
        Bundle bundle= getIntent().getExtras();
        textView.setText(bundle.getString(IntentDemo.MESSAGE));
    }

    public void sendReply(View view){
        String reply= editText.getText().toString();
        Intent intent= new Intent(this, IntentDemo.class);
        intent.putExtra(REPLY, reply);
        IntentDemoActivity2.this.startActivity(intent);
    }


}