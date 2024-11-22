package com.example.osplugin;

import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.mapbox.maps.MapView;
import com.mapbox.maps.Style;

public class SimpleMapActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout layout = new FrameLayout(this);
        setContentView(layout);

        MapView mapView = new MapView(this);
        layout.addView(mapView);

        mapView.getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS);
    }
}
