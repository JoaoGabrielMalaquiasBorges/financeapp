package com.example.financeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.financeapp.databinding.FragmentEntryDetailsBinding;
import com.google.android.material.transition.MaterialSharedAxis;

public class EntryDetailsFragment extends Fragment {

    private FragmentEntryDetailsBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MaterialSharedAxis enterTransition =
                new MaterialSharedAxis(MaterialSharedAxis.X,true);
        setEnterTransition(enterTransition);

        MaterialSharedAxis returnTransition =
                new MaterialSharedAxis(MaterialSharedAxis.X,false);
        setReturnTransition(returnTransition);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEntryDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}