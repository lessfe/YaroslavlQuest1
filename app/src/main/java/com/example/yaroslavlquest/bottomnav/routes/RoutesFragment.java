package com.example.yaroslavlquest.bottomnav.routes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yaroslavlquest.databinding.FragmentRoutesBinding;

public class RoutesFragment extends Fragment {
    private FragmentRoutesBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRoutesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
