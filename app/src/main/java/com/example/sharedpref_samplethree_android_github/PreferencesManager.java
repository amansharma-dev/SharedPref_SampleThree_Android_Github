package com.example.sharedpref_samplethree_android_github;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManager {

    public static final String PREF_NAME = "myLaunchPref";
    public static final String FIRST_LAUNCH = "firstLaunch";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public PreferencesManager(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public void setFirstLaunch(boolean isFirstLaunch){
        editor.putBoolean(FIRST_LAUNCH,isFirstLaunch);
        editor.apply();
    }

    public boolean FirstLaunch(){
        return sharedPreferences.getBoolean(FIRST_LAUNCH,true);
    }
}
