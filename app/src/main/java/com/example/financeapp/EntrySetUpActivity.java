package com.example.financeapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.financeapp.databinding.ActivityEntrySetUpBinding;
import com.google.android.material.transition.platform.MaterialSharedAxis;

public class EntrySetUpActivity extends AppCompatActivity {

    NavController navController;
    AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityEntrySetUpBinding binding = ActivityEntrySetUpBinding.inflate(getLayoutInflater());

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        setContentView(binding.getRoot());
        setSupportActionBar(binding.myToolbar);

        MaterialSharedAxis enterTransition =
                new MaterialSharedAxis(MaterialSharedAxis.Z,true);
        enterTransition.addTarget(binding.getRoot());
        getWindow().setEnterTransition(enterTransition);

        MaterialSharedAxis returnTransition =
                new MaterialSharedAxis(MaterialSharedAxis.Z,false);
        returnTransition.addTarget(binding.getRoot());
        getWindow().setReturnTransition(returnTransition);

        getWindow().setAllowEnterTransitionOverlap(true);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        assert navHostFragment != null;

        navController = navHostFragment.getNavController();

//        navController.addOnDestinationChangedListener(
//                (controller, destination, arguments) -> invalidateOptionsMenu()
//        );

        appBarConfiguration = new AppBarConfiguration.Builder()
                .setFallbackOnNavigateUpListener(this::customNavigateUp).build();

        NavigationUI.setupWithNavController(binding.myToolbar, navController, appBarConfiguration);
    }

    private  boolean  customNavigateUp() {
        finishAfterTransition();
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.layout_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.getItem(0).setVisible(false);

        navController.addOnDestinationChangedListener(
                (controller, destination, arguments) ->
                        menu.getItem(0).setVisible(destination.getId() !=
                                R.id.entryTypeFragment)
        );

        return true;
    }
}