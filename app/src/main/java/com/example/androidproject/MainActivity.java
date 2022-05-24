package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button aboutBtn;
private Button infoBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aboutBtn=findViewById(R.id.launch_about_activity_btn);
        infoBtn=findViewById(R.id.information_btn);
        Intent aboutIntent=new Intent(this, AboutActivity.class);
        Intent infoIntent=new Intent(this, InformationActivity.class);
        aboutBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
            startActivity(aboutIntent);
            }
        });
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
            startActivity(infoIntent);
            }
        });
    }
}