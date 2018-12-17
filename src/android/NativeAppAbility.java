package com.wingconn;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageInfo;

public class NativeAppAbility extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if(action.equals("checkAppInstalled")) {
            String uri = args.getString(0);
            this.checkAppInstalled(uri, callbackContext);
            return true;
        }else if(action.equals("startupNativeApp")) {
            String uri = args.getString(0);
            this.startupNativeApp(uri, callbackContext);
            return true;
        }
        return false;
    }

    /**
     * open native app
     * @param packageName
     */
    private void startupNativeApp(String packageName, CallbackContext callbackContext){
        Context ctx = this.cordova.getActivity().getApplicationContext();
        PackageManager manager = ctx.getPackageManager();

        Intent intent;
        try {
            intent = manager.getLaunchIntentForPackage(packageName);
            this.cordova.getActivity().startActivity(intent);
            callbackContext.success();
        }catch (Exception e){
            callbackContext.error("");
        }
    }

    /**
     * main entry of checking if the app is available
     * @param uri
     * @param callbackContext
     */
    private void checkAppInstalled(String uri, CallbackContext callbackContext) {
        PackageInfo info = getAppPackageInfo(uri);
        if(info != null) {
            try {
                callbackContext.success(this.convertPackageInfoToJson(info));
            }catch(JSONException e) {
                callbackContext.error("");
            }
        }else {
            callbackContext.error("");
        }
    }

    /**
     * get app package info
     * @param uri
     * @return
     */
    private PackageInfo getAppPackageInfo(String uri) {
        Context ctx = this.cordova.getActivity().getApplicationContext();
        PackageManager pm = ctx.getPackageManager();

        try {
            return pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
        }catch(PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    /**
     * convert package info to json
     * @param info
     * @return
     * @throws JSONException
     */
    private JSONObject convertPackageInfoToJson(PackageInfo info) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("version", info.versionName);
        json.put("appId", info.packageName);
        return json;
    }
}
