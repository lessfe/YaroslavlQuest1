package com.example.yaroslavlquest.bottomnav.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yaroslavlquest.databinding.FragmentsMapBinding;

public class MapFragment extends Fragment {
    private FragmentsMapBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentsMapBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}
