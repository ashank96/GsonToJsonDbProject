package com.example.aloofwillow.gsontojsondbproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> addList=new ArrayList<>();
        addList.add("Bangalore");
        addList.add("Tumkur");
        addList.add("Ranchi");

        //initialize your object with form data
        FormData formData=new FormData("ashank",21,addList);

        //convert object into json
        Gson gson=new Gson();
        String jsonString=gson.toJson(formData);
        Log.i("json",jsonString);

        //pass link of the website and jsonString here
        new DownloadTask().execute("http://d9c6b4fa.ngrok.io/server.php",jsonString);
    }
}
