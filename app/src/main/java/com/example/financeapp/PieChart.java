package com.example.financeapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RotateDrawable;
import android.view.LayoutInflater;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;

public class PieChart extends ConstraintLayout {

    private final LayoutInflater layoutInflater;
    private final int shortAnimationDuration = getResources().getInteger(
        android.R.integer.config_shortAnimTime);

    public PieChart(@NonNull Context context) {
        super(context);
        layoutInflater =
            (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addNewSlice(int progress, int sliceColor, int angle) {
        layoutInflater.inflate(R.layout.progress_bar, this);

        Drawable progressDrawable = ResourcesCompat
            .getDrawable(getResources(), R.drawable.status_full, null);
        assert progressDrawable != null;
        progressDrawable.setTint(sliceColor);

        RotateDrawable rotateDrawable = new RotateDrawable();
        rotateDrawable.setDrawable(progressDrawable);
        rotateDrawable.setFromDegrees(angle);
        rotateDrawable.setToDegrees(angle);

        ProgressBar progressBar =
            (ProgressBar) this.getChildAt(this.getChildCount()-1);
        progressBar.setProgressDrawable(rotateDrawable);
        progressBar.setElevation(10);
        progressBar.setProgress(progress);
    }

    public void selectProgress(int index) {
        int count = this.getChildCount()-1;

        while (count >= 0) {
            this.getChildAt(count).animate()
                .alpha(0f)
                .setDuration(shortAnimationDuration)
                .setListener(null);
            count--;
        }

//        this.getChildAt(index).animate()
//            .alpha(1f)
//            .setDuration(shortAnimationDuration)
//            .setListener(null);
    }
}
