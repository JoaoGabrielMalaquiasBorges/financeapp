package com.example.financeapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.financeapp.databinding.ActivityMainBinding;
import com.google.android.material.transition.platform.MaterialSharedAxis;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        MaterialSharedAxis exitTransition =
                new MaterialSharedAxis(MaterialSharedAxis.Z,true);
         exitTransition.addTarget(binding.getRoot());
        getWindow().setExitTransition(exitTransition);

        MaterialSharedAxis reenterTransition =
                new MaterialSharedAxis(MaterialSharedAxis.Z,false);
         reenterTransition.addTarget(binding.getRoot());
        getWindow().setReenterTransition(reenterTransition);

        Intent intent = new Intent(this, BalanceDetailsActivity.class);
        Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        Button button = binding.button;

        button.setOnClickListener(
                v -> startActivity(intent)
        );
    }
}