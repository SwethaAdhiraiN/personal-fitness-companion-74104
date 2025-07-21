package com.example.mainandroidfrontend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.annotation.Nullable;

/**
 * TrainerCounselingFragment: Trainer booking and payment UI stub.
 */
public class TrainerCounselingFragment extends Fragment {
    public TrainerCounselingFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trainer_counseling, container, false);
    }
}
