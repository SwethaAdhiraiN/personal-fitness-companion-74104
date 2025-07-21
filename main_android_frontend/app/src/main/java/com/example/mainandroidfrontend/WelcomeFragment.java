package com.example.mainandroidfrontend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/**
 * WelcomeFragment: Initial splash/onboarding fragment.
 */
public class WelcomeFragment extends Fragment {

    public WelcomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout already set in MainActivity (activity_main.xml)
        return inflater.inflate(R.layout.activity_main, container, false);
    }
}
