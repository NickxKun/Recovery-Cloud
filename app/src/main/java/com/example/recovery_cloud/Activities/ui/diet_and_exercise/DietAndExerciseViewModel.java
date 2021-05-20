package com.example.recovery_cloud.Activities.ui.diet_and_exercise;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DietAndExerciseViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DietAndExerciseViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}