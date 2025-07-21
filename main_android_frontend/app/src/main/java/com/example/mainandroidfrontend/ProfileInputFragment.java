package com.example.mainandroidfrontend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.annotation.Nullable;

/**
 * ProfileInputFragment: Profile input for height, weight, and goals.
 */
public class ProfileInputFragment extends Fragment {

    public ProfileInputFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile_input, container, false);

        EditText etHeight = v.findViewById(R.id.etHeight);
        EditText etWeight = v.findViewById(R.id.etWeight);
        EditText etGoals = v.findViewById(R.id.etGoals);
        Button btnContinue = v.findViewById(R.id.btnContinueProfile);

        btnContinue.setOnClickListener(view -> {
            String heightStr = etHeight.getText().toString();
            String weightStr = etWeight.getText().toString();
            String goals = etGoals.getText().toString();

            if (TextUtils.isEmpty(heightStr) || TextUtils.isEmpty(weightStr) || TextUtils.isEmpty(goals)) {
                Toast.makeText(getContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                return;
            }

            float height = Float.parseFloat(heightStr);
            float weight = Float.parseFloat(weightStr);

            // TODO: Save profile to backend/db

            ((MainActivity) requireActivity()).loadFragment(new DashboardFragment(height, weight, goals));
        });

        return v;
    }
}
