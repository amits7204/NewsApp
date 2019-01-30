/**
 * @Amit_Singh
 * @CITY Bangalore
 */

package com.example.amit.newsapp.singleton;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class NewsApplication extends Application {
    public static final String NIGHT_MODE = "NIGHT_MODE";
    public boolean isNightModeEnabled = false;

    public static NewsApplication mSingleton = null;

    public static NewsApplication getInstance(){
        if(mSingleton == null){
            mSingleton = new NewsApplication();
        }
        return mSingleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mSingleton = this;
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        this.isNightModeEnabled = mPrefs.getBoolean(NIGHT_MODE, false);
    }

    public boolean isNightModeEnabled() {
        return isNightModeEnabled;
    }

    public void setIsNightModeEnabled(boolean isNightModeEnabled) {
        this.isNightModeEnabled = isNightModeEnabled;

        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putBoolean(NIGHT_MODE, isNightModeEnabled);
        editor.apply();
    }

}
