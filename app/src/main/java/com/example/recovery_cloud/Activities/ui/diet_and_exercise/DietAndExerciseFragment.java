package com.example.recovery_cloud.Activities.ui.diet_and_exercise;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.recovery_cloud.R;

public class DietAndExerciseFragment extends Fragment {

    private Dialog myDialog;
    private Button be_btn, dh_btn, rs_btn, mh_btn;

    private DietAndExerciseViewModel dietAndExerciseViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dietAndExerciseViewModel =
                new ViewModelProvider(this).get(DietAndExerciseViewModel.class);
        View root = inflater.inflate(R.layout.fragment_diet_and_exercise, container, false);

        myDialog = new Dialog(getActivity());


        be_btn = root.findViewById(R.id.fever_btn);
        dh_btn = root.findViewById(R.id.cough_sore_throat_btn);
        rs_btn = root.findViewById(R.id.weakness_btn);
        mh_btn = root.findViewById(R.id.loss_of_smell_taste_btn);

        //YouTubePlayerView youTubePlayerView = root.findViewById(R.id.youtube_player_view);

        be_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showPopup(v, "");

            }
        });

        dh_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v, "");
            }
        });

        rs_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v, "");
            }
        });

        mh_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v, "");
            }
        });

        return root;
    }


    public void showPopup(View v, String called_by) {

        ImageView closeBtn;
        myDialog.setContentView(R.layout.custom_popup);
        closeBtn = (ImageView) myDialog.findViewById(R.id.txt_close);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }

}