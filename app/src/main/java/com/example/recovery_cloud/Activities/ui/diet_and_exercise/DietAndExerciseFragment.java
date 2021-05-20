package com.example.recovery_cloud.Activities.ui.diet_and_exercise;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.recovery_cloud.R;

public class DietAndExerciseFragment extends Fragment {

    private DietAndExerciseViewModel dietAndExerciseViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dietAndExerciseViewModel =
                new ViewModelProvider(this).get(DietAndExerciseViewModel.class);
        View root = inflater.inflate(R.layout.fragment_diet_and_exercise, container, false);


        return root;
    }
}