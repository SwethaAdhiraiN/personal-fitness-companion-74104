package com.example.mainandroidfrontend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.annotation.Nullable;

/**
 * WorkoutPlannerFragment: Level-based workout suggestions and programs.
 */
public class WorkoutPlannerFragment extends Fragment {
    public WorkoutPlannerFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_workout_planner, container, false);
    }
}
