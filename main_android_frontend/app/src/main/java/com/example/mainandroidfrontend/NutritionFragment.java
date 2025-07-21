package com.example.mainandroidfrontend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.annotation.Nullable;

/**
 * NutritionFragment: Personalized nutrition suggestions, meal plans, recipes.
 */
public class NutritionFragment extends Fragment {
    public NutritionFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nutrition, container, false);
    }
}
