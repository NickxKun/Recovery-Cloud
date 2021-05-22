package com.example.recovery_cloud.Activities.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recovery_cloud.R;

public class HomeFragment extends Fragment {

    private Button startAssessmentBtn;
    private Intent SymptomActivity;
    private ImageView notif_bar;
    private TextView notif_btn, notif_txt;

    private HomeViewModel homeViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        startAssessmentBtn = root.findViewById(R.id.start_ass_btn);
        notif_bar = root.findViewById(R.id.notifictaion_bar);
        notif_btn = root.findViewById(R.id.notification_btn);
        notif_txt = root.findViewById(R.id.notification_text);

        notif_bar.setVisibility(View.INVISIBLE);
        notif_btn.setVisibility(View.INVISIBLE);
        notif_txt.setVisibility(View.INVISIBLE);



        SymptomActivity = new Intent(getActivity(), com.example.recovery_cloud.Activities.SymptomActivity.class);

        startAssessmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startForm();

                notif_bar.setVisibility(View.VISIBLE);
                notif_btn.setVisibility(View.VISIBLE);
                notif_txt.setVisibility(View.VISIBLE);

            }
        });

        notif_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        return root;
    }

    private void startForm() {

        startActivity(SymptomActivity);

    }

}