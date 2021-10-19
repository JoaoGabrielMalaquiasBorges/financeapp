package com.example.financeapp;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.financeapp.databinding.ActivityBalanceDetailsBinding;

public class BalanceDetailsActivity extends AppCompatActivity {
    ConstraintLayout rootContainer;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityBalanceDetailsBinding binding =
            ActivityBalanceDetailsBinding.inflate(getLayoutInflater());

        rootContainer = binding.getRoot();
        setContentView(rootContainer);

        pieChart = new PieChart(getApplicationContext());
        pieChart.addNewSlice(85, Color.YELLOW, 324);
        pieChart.addNewSlice(15, Color.BLUE, 270);

//        ActionBar
        rootContainer.addView(pieChart);

        Button button = binding.button;
        button.setOnClickListener(
                v -> pieChart.selectProgress(1)
        );
    }

    @Override
    protected void onDestroy() {
        rootContainer.removeView(pieChart);
        super.onDestroy();
    }
//
//    private ProgressBar addNewSlice(int progress, int sliceColor, int angle) {
//        ConstraintSet constraintSet = new ConstraintSet();
//
//        constraintSet.constrainWidth(progressBarContainer.getId(), ConstraintSet.WRAP_CONTENT);
//        constraintSet.constrainHeight(progressBarContainer.getId(), ConstraintSet.WRAP_CONTENT);
//
//        constraintSet.connect(progressBarContainer.getId(), ConstraintSet.TOP,
//            rootContainer.getId(), ConstraintSet.TOP);
//        constraintSet.connect(progressBarContainer.getId(), ConstraintSet.BOTTOM,
//            rootContainer.getId(), ConstraintSet.BOTTOM);
//        constraintSet.connect(progressBarContainer.getId(), ConstraintSet.START,
//            rootContainer.getId(), ConstraintSet.START);
//        constraintSet.connect(progressBarContainer.getId(), ConstraintSet.END,
//            rootContainer.getId(), ConstraintSet.END);
//
//        constraintSet.applyTo(rootContainer);
//    }
}