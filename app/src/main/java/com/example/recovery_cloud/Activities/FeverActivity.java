package com.example.recovery_cloud.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.recovery_cloud.R;

public class FeverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fever);
        getSupportActionBar().hide();
    }
}