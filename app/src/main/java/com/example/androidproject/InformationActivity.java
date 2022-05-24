package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")

public class InformationActivity extends AppCompatActivity {
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private ArrayList<Car> cars;
private Gson gson;
private Type type;
private RecyclerView recView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        recView=findViewById(R.id.rec)
    }
}