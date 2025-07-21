package com.example.mainandroidfrontend;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * FitJourney MainActivity: Handles main navigation and initial app entry point.
 * Public interfaces provided for fragment navigation and logic.
 */
public class MainActivity extends AppCompatActivity {

    // PUBLIC_INTERFACE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Immediately load splash/welcome or onboarding
        loadFragment(new WelcomeFragment());

        // Set up "Get Started" button to transition to AuthFragment
        Button btnGetStarted = findViewById(R.id.btnGetStarted);
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new AuthFragment());
            }
        });
    }

    // PUBLIC_INTERFACE
    /**
     * Fragment switching logic, reused by all navigation events.
     * @param fragment Target fragment to display
     */
    public void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
            .replace(android.R.id.content, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit();
    }
}
