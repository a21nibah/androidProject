package com.example.androidproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.reflect.TypeToken;

@SuppressWarnings("FieldCanBeLocal")

public class InformationActivity extends AppCompatActivity implements JsonTask.JsonTaskListener
{
    private final String jsonUrl = "https://mobprog.webug.se/json-api?login=a21nibah";
    private ArrayList<Car> cars;
private Gson gson;
private Type type;
private RecyclerView recView;
private CarAdapter carAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        recView=findViewById(R.id.rec_view);
recView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
cars=new ArrayList<Car>();
carAdapter=new CarAdapter(cars);
recView.setAdapter(carAdapter);
        type = new TypeToken<ArrayList<Car>>() {}.getType();
gson=new Gson();
new JsonTask(this).execute(jsonUrl);
    }
    @Override
    public void onPostExecute(String json)
    {
        //we create a new temp list and fetch the json data and put it in there before we update the mountain list.
        ArrayList<Car> temp=new ArrayList<Car>();
        temp=gson.fromJson(json, type);
//we make sure that the array list is cleared before we add to it.
        cars.clear();
        cars.addAll(temp);
        carAdapter.notifyDataSetChanged();

    }
}
