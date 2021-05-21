package com.example.recovery_cloud.Activities;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recovery_cloud.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class SymptomActivity extends AppCompatActivity {

    private RadioButton male_radio_btn,female_radio_btn,others_radio_btn,selected_gender;
    private RadioGroup gender_radio,hosp_radio;
    private EditText age_input;
    private RadioButton hosp_radio_yes,hosp_radio_no,selected_hosp;
    private CheckBox fever_check,breath_check,senses_check,fatigue_check,depr_check,cough_check;
    private FirebaseDatabase database;
    private DatabaseReference user_ref;
    private Button asses_btn;
    private String email;
    //SymptomInfo symptomInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom);

        getSupportActionBar().setTitle("Symptom Activity");

        gender_radio = (RadioGroup) findViewById(R.id.gender_radio);
        male_radio_btn = findViewById(R.id.male_radio_btn);
        female_radio_btn = findViewById(R.id.female_radio_btn);
        others_radio_btn = findViewById(R.id.others_radio_btn);
        age_input = (EditText) findViewById(R.id.age_input);
        hosp_radio = (RadioGroup) findViewById(R.id.hosp_radio);
        hosp_radio_yes = findViewById(R.id.hosp_radio_yes);
        hosp_radio_no = findViewById(R.id.hosp_radio_no);
        fever_check = (CheckBox) findViewById(R.id.fever_check);
        breath_check = (CheckBox) findViewById(R.id.breath_check);
        senses_check = (CheckBox) findViewById(R.id.senses_check);
        fatigue_check = (CheckBox) findViewById(R.id.fatigue_check);
        depr_check = (CheckBox) findViewById(R.id.depr_check);
        cough_check = (CheckBox) findViewById(R.id.cough_check);
        asses_btn = (Button) findViewById(R.id.assesment_submit);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            for (UserInfo profile : user.getProviderData()) {
                // Id of the provider (ex: google.com)
                String providerId = profile.getProviderId();

                // UID specific to the provider
                String uid = profile.getUid();
                email = profile.getEmail();
            }
        }
        user_ref = FirebaseDatabase.getInstance().getReference().child("Symptom");

        //symptomInfo = new SymptomInfo();

        asses_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asses_btn.setVisibility(View.INVISIBLE);
                int selectedid = gender_radio.getCheckedRadioButtonId();
                selected_gender = (RadioButton) findViewById(selectedid);
                final String gender = selected_gender.getText().toString();
                final String age = age_input.getText().toString();
                selectedid = hosp_radio.getCheckedRadioButtonId();
                selected_hosp = (RadioButton) findViewById(selectedid);
                final String hosp = selected_hosp.getText().toString();
                Boolean fever = false;
                Boolean breath = false;
                Boolean senses = false;
                Boolean fatigue = false;
                Boolean depr = false;
                Boolean cough = false;
                if (fever_check.isChecked())
                    fever = true;
                if (breath_check.isChecked())
                    breath = true;
                if (senses_check.isChecked())
                    senses = true;
                if (fatigue_check.isChecked())
                    fatigue = true;
                if (depr_check.isChecked())
                    depr = true;
                if (cough_check.isChecked())
                    cough = true;

                if (gender.isEmpty() || age.isEmpty() || hosp.isEmpty()) {
                    showMessage("Please Verify all fields");
                    asses_btn.setVisibility(View.VISIBLE);
                }
                else{
                    showMessage("Going to add symptom");
                    SymptomInfo symptomInfo = new SymptomInfo(email, fever, breath, senses, fatigue, depr, cough);
                    user_ref.push().setValue(symptomInfo);
                    showMessage("Data added");
                    //addSymptom(email, fever, breath, senses, fatigue, depr, cough);

                }

            }
        });
}
/*private void addSymptom(String email, Boolean fever,Boolean breath, Boolean senses, Boolean fatigue, Boolean depr, Boolean cough){
        symptomInfo.setEmail(email);
        symptomInfo.setFever(fever);
        symptomInfo.setBreath(breath);
        symptomInfo.setSenses(senses);
        symptomInfo.setFatigue(fatigue);
        symptomInfo.setDepr(depr);
        symptomInfo.setCough(cough);
        showMessage("going to add");

        user_ref.push().setValue(symptomInfo);
        showMessage("Data added");


}*/
    private void showMessage(String message) {

        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

    }
}