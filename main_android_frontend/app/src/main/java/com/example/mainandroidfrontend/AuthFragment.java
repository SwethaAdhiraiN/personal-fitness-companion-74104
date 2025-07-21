package com.example.mainandroidfrontend;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * AuthFragment: Handles user login & registration UI.
 */
public class AuthFragment extends Fragment {

    private boolean isLogin = true;

    public AuthFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_auth, container, false);

        final EditText etEmail = v.findViewById(R.id.etEmail);
        final EditText etPassword = v.findViewById(R.id.etPassword);
        final EditText etName = v.findViewById(R.id.etName);
        final Button btnSubmit = v.findViewById(R.id.btnSubmit);
        final TextView tvSwitchMode = v.findViewById(R.id.tvSwitchMode);

        etName.setVisibility(View.GONE);

        tvSwitchMode.setOnClickListener(view -> {
            isLogin = !isLogin;
            if (isLogin) {
                etName.setVisibility(View.GONE);
                btnSubmit.setText("Login");
                tvSwitchMode.setText("Don't have an account? Register");
            } else {
                etName.setVisibility(View.VISIBLE);
                btnSubmit.setText("Register");
                tvSwitchMode.setText("Already have an account? Login");
            }
        });

        btnSubmit.setOnClickListener(view -> {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            String name = etName.getText().toString();

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || (!isLogin && TextUtils.isEmpty(name))) {
                Toast.makeText(getContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                return;
            }

            // TODO: Call backend REST API for login/register
            // Simulate success
            Toast.makeText(getContext(), isLogin ? "Login successful!" : "Registration successful!", Toast.LENGTH_SHORT).show();
            requireActivity().runOnUiThread(() -> {
                ((MainActivity) requireActivity()).loadFragment(new ProfileInputFragment());
            });
        });

        return v;
    }
}
