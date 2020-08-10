package com.example.androidlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class StorageDemo extends AppCompatActivity {

    private static final String FILE_NAME = "myFile.txt";
    private EditText mData;
    private Button mSaveInternal;
    private Button mLoad;
    private Button mSaveExternal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        mData = findViewById(R.id.message_edit_text);
        mSaveInternal = findViewById(R.id.save_int_btn);
        mSaveExternal= findViewById(R.id.save_ext_btn);
        mLoad = findViewById(R.id.load_btn);


        mSaveInternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveInternal();
            }
        });

        mLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                load();
            }
        });

        mSaveExternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveExternal();
            }
        });

    }

    private void saveInternal()  {

        String data= mData.getText().toString();
        FileOutputStream fos= null;

        try {
            fos= openFileOutput(FILE_NAME, MODE_PRIVATE );
            fos.write(data.getBytes());

            mData.getText().clear();
            Toast.makeText(this, "File save to: " + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }



    private void load(){

        FileInputStream fis = null;

        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String text = "";
            StringBuilder sb = new StringBuilder();

            while((text= br.readLine())!= null){
                sb.append(text);
                sb.append("\n");
            }

            mData.setText(sb.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fis!= null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void saveExternal(){
        //Check if writing permisiion available in external storage
        FileOutputStream fos = null;
        File primaryExternalStorage = getPrimaryExternalStorage();
        if(isExternalStorageWritable()){
            File mFile = new File(primaryExternalStorage.toString(), "myFile.txt" );
            try {
                fos = new FileOutputStream(mFile);
                fos.write(mData.getText().toString().getBytes());
                mData.getText().clear();
                Toast.makeText(this, "File save to: " + primaryExternalStorage.toString() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(fos!= null){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        }else{
            Toast.makeText(this, "External Storage not availabe", Toast.LENGTH_LONG).show();
        }

    }

    private boolean isExternalStorageWritable() {
        return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED;
    }

    private File getPrimaryExternalStorage(){
        File[] externalStorageVolumes =
                ContextCompat.getExternalFilesDirs(getApplicationContext(), null);
        File primaryExternalStorage = externalStorageVolumes[0];
        return primaryExternalStorage;
    }


}