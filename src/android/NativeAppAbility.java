package com.wingconn;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;

import java.util.List;

public class NativeAppAbility extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if(action.equals("checkAppInstalled")) {
            String uri = args.getString(0);
            this.checkAppInstalled(uri, callbackContext);
            return true;
        }else if(action.equals("startupNativeApp")) {
            String uri = args.getString(0);
            String userId = null;
            String sign = null;
            if(args.length() > 2) {
                userId = args.getString(1);
                sign = args.getString(2);
            }
            this.startupNativeApp(uri, userId,sign, callbackContext);
            return true;
        }
//        else if(action.equals("startupAppWithParams")) {
//            String uri = args.getString(0);
//            String userId = args.getString(1);
//            String sign = args.getString(2);
//            this.startupNativeApp(uri,userId,sign, callbackContext);
//            return true;
//        }else if(action.equals("closeNativeApp")) {
//            this.closeCurrentApp(callbackContext);
//            return true;
//        }
        return false;
    }


    /**
     * startup local app with params
     * @param packageName
     * @param userId, can be null
     * @param sign, can be null
     * @param callbackContext
     */
    private void startupNativeApp(String packageName,String userId, String sign
                                                        ,CallbackContext callbackContext){
        Context ctx = this.cordova.getActivity().getApplicationContext();
        PackageManager manager = ctx.getPackageManager();
        Intent intent;
        try {
            intent = manager.getLaunchIntentForPackage(packageName);
            if(intent == null) {
                try {
                    String className = getPackageClassName(manager, packageName);
                    intent = new Intent(Intent.ACTION_MAIN);
                    intent.setComponent(new ComponentName(packageName, className));

                    //Uri uri = Uri.parse(className);
                    //intent.setData(uri);
                } catch (Exception e) {
                    callbackContext.error("");
                    e.printStackTrace();
                }
            }
            if(intent != null) {
                if(userId != null && sign != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("userid", userId);
                    bundle.putString("sign", sign);
                    intent.putExtras(bundle);
                }
                this.cordova.getActivity().startActivity(intent);
                callbackContext.success();
            }else
                callbackContext.error("");
        }catch (Exception e){
            callbackContext.error("");
        }
    }

    private String getPackageClassName(PackageManager manager,String packageName){
        Intent main=new Intent(Intent.ACTION_MAIN, null);
        main.addCategory(Intent.CATEGORY_DEFAULT);
        List<ResolveInfo> listInfos = manager.queryIntentActivities(main,0);
        String className = null;
        for (ResolveInfo info : listInfos) {
            if (packageName.equals(info.activityInfo.packageName)) {
                className = info.activityInfo.name;
                break;
            }
        }
        return className;
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
     * main entry of close the current running app
     * @param callbackContext
     */
    private void closeCurrentApp(CallbackContext callbackContext) {
        try {
            System.exit(0);
            callbackContext.success();
        }catch(Exception e) {
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
