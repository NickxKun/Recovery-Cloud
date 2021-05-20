package com.example.recovery_cloud.Activities.ui.symptom_monitor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SymptomMonitorViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SymptomMonitorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}