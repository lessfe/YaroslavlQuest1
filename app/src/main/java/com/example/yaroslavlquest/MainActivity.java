package com.example.yaroslavlquest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;

import android.os.Bundle;

import com.example.yaroslavlquest.bottomnav.collection.CollectionFragment;
import com.example.yaroslavlquest.bottomnav.map.MapFragment;
import com.example.yaroslavlquest.bottomnav.profile.ProfileFragment;
import com.example.yaroslavlquest.bottomnav.routes.RoutesFragment;
import com.example.yaroslavlquest.databinding.ActivityMainBinding;
import com.example.yaroslavlquest.databinding.FragmentCollectionBinding;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (FirebaseAuth.getInstance().getCurrentUser() == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }

        getSupportFragmentManager().beginTransaction().replace(binding.fragmentContainer.getId(), new RoutesFragment()).commit();
        binding.bottomNav.setSelectedItemId(R.id.profile);

        Map<Integer, Fragment> fragmentMap = new HashMap<>();
        fragmentMap.put(R.id.map, new MapFragment());
        fragmentMap.put(R.id.routes, new RoutesFragment());
        fragmentMap.put(R.id.collection, new CollectionFragment());
        fragmentMap.put(R.id.profile, new ProfileFragment());

        binding.bottomNav.setOnItemSelectedListener(item -> {
            Fragment fragment = fragmentMap.get(item.getItemId());
            getSupportFragmentManager().beginTransaction().replace(binding.fragmentContainer.getId(), fragment).commit();
            return true;
        });

    }

}