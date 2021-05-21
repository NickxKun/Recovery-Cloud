package com.example.recovery_cloud.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.recovery_cloud.R;
import com.google.firebase.database.FirebaseDatabase;

public class SymptomActivity extends AppCompatActivity {

    private RadioButton male_radio_btn,female_radio_btn,others_radio_btn,selected_gender;
    private RadioGroup gender_radio,hosp_radio;
    private EditText age_input;
    private RadioButton hosp_radio_yes,hosp_radio_no,selected_hosp;
    private CheckBox fever_check,breath_check,senses_check,fatigue_check,depr_check,cough_check;
    private FirebaseDatabase database;
    private Button asses_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Symptom Activity");


    }
}