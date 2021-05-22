package com.example.recovery_cloud.Activities.ui.symptom_monitor;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.recovery_cloud.Activities.FeverActivity;
import com.example.recovery_cloud.R;

public class SymptomMonitorFragment extends Fragment {

    private SymptomMonitorViewModel symptomMonitorViewModel;
    private Button symptom_fever_btn;
    private Intent FeverActivity;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        symptomMonitorViewModel =
                new ViewModelProvider(this).get(SymptomMonitorViewModel.class);
        View root = inflater.inflate(R.layout.fragment_symptom_monitor, container, false);

        symptom_fever_btn = root.findViewById(R.id.fever_btn);

        symptom_fever_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FeverActivity = new Intent(getActivity(), com.example.recovery_cloud.Activities.SymptomActivity.class);
                startForm();

            }
        });

        return root;
    }

    private void startForm() {

        startActivity(FeverActivity);

    }
}