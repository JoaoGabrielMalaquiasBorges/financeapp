package com.example.financeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.financeapp.databinding.FragmentEntryTypeBinding;
import com.google.android.material.transition.MaterialSharedAxis;

public class EntryTypeFragment extends Fragment {

    private FragmentEntryTypeBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MaterialSharedAxis exitTransition =
                new MaterialSharedAxis(MaterialSharedAxis.X,true);
        setExitTransition(exitTransition);

        MaterialSharedAxis reenterTransition =
                new MaterialSharedAxis(MaterialSharedAxis.X,false);
        setReenterTransition(reenterTransition);

//        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        binding = FragmentEntryTypeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Button button = binding.button;
        button.setOnClickListener(
                v -> {
                    NavDirections action = EntryTypeFragmentDirections
                            .actionEntryTypeFragmentToEntryDetailsFragment();
                    Navigation.findNavController(view).navigate(action);
                }
        );
    }

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        inflater.inflate(R.menu.layout_menu, menu);
//    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        NavDirections action = EntryTypeFragmentDirections
//                .actionEntryTypeFragmentToEntryDetailsFragment();
//
//        if (item.getItemId() == R.id.action_abort_process) {
//            Navigation.findNavController(this.requireView()).navigate(action);
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}