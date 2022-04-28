package com.example.explicitintentvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        tvWelcome = findViewById(R.id.tvWelcome);
        //catch the value from the main string.
        //getStringExtra used as we have string value from the main activity and changes depending upon
        //the datatype we uses
        String name = getIntent().getStringExtra("Data");

        tvWelcome.setText(name + " Welcome to the Activity 2");



    }
}