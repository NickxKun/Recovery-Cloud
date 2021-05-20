package com.example.recovery_cloud.Activities.ui.progress_tracker;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recovery_cloud.R;

public class ProgressTrackerFragment extends Fragment {

    private ProgressTrackerViewModel mViewModel;

    public static ProgressTrackerFragment newInstance() {
        return new ProgressTrackerFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_progress_tracker, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProgressTrackerViewModel.class);
        // TODO: Use the ViewModel
    }

}