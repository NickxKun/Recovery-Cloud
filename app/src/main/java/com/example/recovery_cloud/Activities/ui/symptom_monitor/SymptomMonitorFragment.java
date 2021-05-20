package com.example.recovery_cloud.Activities.ui.symptom_monitor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.recovery_cloud.R;

public class SymptomMonitorFragment extends Fragment {

    private SymptomMonitorViewModel symptomMonitorViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        symptomMonitorViewModel =
                new ViewModelProvider(this).get(SymptomMonitorViewModel.class);
        View root = inflater.inflate(R.layout.fragment_symptom_monitor, container, false);

        return root;
    }
}