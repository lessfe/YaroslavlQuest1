package com.example.yaroslavlquest.bottomnav.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yaroslavlquest.MainActivity;
import com.example.yaroslavlquest.R;
import com.example.yaroslavlquest.databinding.FragmentsMapBinding;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class MapFragment extends Fragment {
    private FragmentsMapBinding binding;
    public MapView mapView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentsMapBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public  void onViewCreated(View view,  Bundle savedInstanceState){
        mapView = view.findViewById(R.id.map_view);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        MapKitFactory.initialize(this.getContext());

        MapKitFactory.setApiKey("d344a14b-86e1-4652-af95-bf2fcee2ced4"); // Установить  ключ API
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onStop() {
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }
    @Override
    public void onStart() {
        MapKitFactory.getInstance().onStart();
        mapView.onStart();

        mapView.getMap().move(
                new CameraPosition(new Point(57.589911, 39.857179), 11.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null);
        mapView.getMap().setRotateGesturesEnabled(true);
        super.onStart();
    }
}
