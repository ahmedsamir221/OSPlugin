package com.example.osplugin;

import android.widget.Toast;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Intent;

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