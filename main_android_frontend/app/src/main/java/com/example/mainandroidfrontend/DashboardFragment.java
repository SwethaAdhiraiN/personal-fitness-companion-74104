package com.example.mainandroidfrontend;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;

/**
 * DashboardFragment: Shows BMI, daily kcal, meal/workout suggestions. Navigation hub.
 */
public class DashboardFragment extends Fragment {
    private float height;
    private float weight;
    private String goals;

    public DashboardFragment() {}

    public DashboardFragment(float height, float weight, String goals) {
        this.height = height;
        this.weight = weight;
        this.goals = goals;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // BMI and calorie calculations
        float heightM = height / 100.0f;
        float bmi = weight / (heightM * heightM);
        int calories = (int)(10 * weight + 6.25 * height - 5 * 25 + 5); // Simplified Mifflin-St Jeor for men, age assumed 25

        ((TextView) v.findViewById(R.id.tvBmiValue)).setText(String.format("%.1f", bmi));
        ((TextView) v.findViewById(R.id.tvCalorieValue)).setText(String.valueOf(calories));
        ((TextView) v.findViewById(R.id.tvDashboardGoals)).setText(goals);

        // Navigation buttons
        v.findViewById(R.id.btnMealSuggestions).setOnClickListener(view ->
                ((MainActivity) requireActivity()).loadFragment(new NutritionFragment()));
        v.findViewById(R.id.btnWorkoutPlanner).setOnClickListener(view ->
                ((MainActivity) requireActivity()).loadFragment(new WorkoutPlannerFragment()));
        v.findViewById(R.id.btnTracker).setOnClickListener(view ->
                ((MainActivity) requireActivity()).loadFragment(new TrackerFragment()));
        v.findViewById(R.id.btnCounseling).setOnClickListener(view ->
                ((MainActivity) requireActivity()).loadFragment(new TrainerCounselingFragment()));

        return v;
    }
}
