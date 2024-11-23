package com.example.osplugin;

import android.widget.Toast;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Intent;
import com.mapbox.geojson.Point;
import com.mapbox.maps.CameraOptions;
import com.mapbox.maps.MapView;

public class OSPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("showToast".equals(action)) {
            String message = args.getString(0);
            int duration = args.getInt(1);
            showToast(message, duration);
            callbackContext.success();
            return true;
        }
        if ("addInt".equals(action)) {
            int num1 = args.getInt(0);
            int num2 = args.getInt(1);
            int sum = num1 + num2;
            callbackContext.success(sum);
            return true;
        }
        if ("showMap".equals(action)) {
            // Create a map programmatically and set the initial camera
            mapView = MapView(this);
            mapView.mapboxMap.setCamera(
                CameraOptions.Builder()
                    .center(Point.fromLngLat(-98.0, 39.5))
                    .pitch(0.0)
                    .zoom(2.0)
                    .bearing(0.0)
                    .build()
            );
            // Add the map view to the activity (you can also add it to other views as a child)
            setContentView(mapView);

            callbackContext.success("Map shown!");
            return true;
        }
        return false;
    }

    private void showToast(final String message, final int duration) {
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(cordova.getActivity(), message, duration).show();
            }
        });
    }
}