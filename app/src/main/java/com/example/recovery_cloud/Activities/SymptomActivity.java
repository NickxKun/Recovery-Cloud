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
    SymptomInfo symptomInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Symptom Activity");

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
        user_ref = database.getReference("UserInfo");

        symptomInfo = new SymptomInfo();

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
                Boolean fever = Boolean.FALSE;
                Boolean breath = Boolean.FALSE;
                Boolean senses = Boolean.FALSE;
                Boolean fatigue = Boolean.FALSE;
                Boolean depr = Boolean.FALSE;
                Boolean cough = Boolean.FALSE;
                if (fever_check.isChecked())
                    fever = Boolean.TRUE;
                if (breath_check.isChecked())
                    breath = Boolean.TRUE;
                if (senses_check.isChecked())
                    senses = Boolean.TRUE;
                if (fatigue_check.isChecked())
                    fatigue = Boolean.TRUE;
                if (depr_check.isChecked())
                    depr = Boolean.TRUE;
                if (cough_check.isChecked())
                    cough = Boolean.TRUE;

                if (gender.isEmpty() || age.isEmpty() || hosp.isEmpty()) {
                    showMessage("Please Verify all fields");
                    asses_btn.setVisibility(View.VISIBLE);
                }
                else{
                    addSymptom(email, fever, breath, senses, fatigue, depr, cough);

                }

            }
        });
}
private void addSymptom(String email, Boolean fever,Boolean breath, Boolean senses, Boolean fatigue, Boolean depr, Boolean cough){
        symptomInfo.setEmail(email);
        symptomInfo.setFever(fever);
        symptomInfo.setBreath(breath);
        symptomInfo.setSenses(senses);
        symptomInfo.setFatigue(fatigue);
        symptomInfo.setDepr(depr);
        symptomInfo.setCough(cough);

        user_ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                user_ref.setValue(symptomInfo);
                showMessage("Data Added");
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                showMessage("Failed to add data");
            }
        });
}
    private void showMessage(String message) {

        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

    }
}