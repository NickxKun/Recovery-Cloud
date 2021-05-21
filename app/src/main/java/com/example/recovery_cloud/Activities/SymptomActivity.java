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
        setContentView(R.layout.activity_symptom);
        gender_radio = findViewById(R.id.gender_radio);
        male_radio_btn = findViewById(R.id.male_radio_btn);
        female_radio_btn = findViewById(R.id.female_radio_btn);
        others_radio_btn = findViewById(R.id.others_radio_btn);
        age_input = findViewById(R.id.age_input);
        hosp_radio = findViewById(R.id.hosp_radio);
        hosp_radio_yes = findViewById(R.id.hosp_radio_yes);
        hosp_radio_no = findViewById(R.id.hosp_radio_no);
        fever_check = findViewById(R.id.fever_check);
        breath_check = findViewById(R.id.breath_check);
        senses_check = findViewById(R.id.senses_check);
        fatigue_check = findViewById(R.id.fatigue_check);
        depr_check = findViewById(R.id.depr_check);
        cough_check = findViewById(R.id.cough_check);
        asses_btn = findViewById(R.id.assesment_submit);


        database = FirebaseDatabase.getInstance();
        asses_btn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             asses_btn.setVisibility(View.INVISIBLE);
                                             int selectedid = gender_radio.getCheckedRadioButtonId();
                                             selected_gender = findViewById(selectedid);
                                             final String gender = selected_gender.getText().toString();
                                             final String age = age_input.getText().toString();
                                             selectedid = hosp_radio.getCheckedRadioButtonId();
                                             selected_hosp = findViewById(selectedid);
                                             final String hosp = selected_hosp.getText().toString();
                                             
                                         }
                                     }

            }
        });






    }
}