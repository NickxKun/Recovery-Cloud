package com.example.recovery_cloud.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recovery_cloud.R;

public class MeaasureSpO2Activity extends AppCompatActivity {

    private TextView spo2Val;
    private Button record_btn;

    private Dialog myDialog;
    private Intent Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meaasure_sp_o2);
        getSupportActionBar().hide();

        myDialog = new Dialog(this);
        spo2Val = findViewById(R.id.spo2_val);
        record_btn = findViewById(R.id.submit_recording);
        Home = new Intent(this, com.example.recovery_cloud.Activities.Home.class);

        record_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Integer.parseInt(spo2Val.getText().toString()) < 90 ) {

                    showPopup();

                }
                else
                {

                    startActivity(Home);

                }

            }

        });

    }

    public void showPopup() {

        ImageView closeBtn;
        myDialog.setContentView(R.layout.popup_alert);
        closeBtn = (ImageView) myDialog.findViewById(R.id.txt_close);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
                startActivity(Home);
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }

}