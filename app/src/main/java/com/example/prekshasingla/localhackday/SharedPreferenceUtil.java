package com.example.prekshasingla.localhackday;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceUtil {

    private static SharedPreferenceUtil mSharedPreferenceUtils;
    protected Context mContext;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mSharedPreferencesEditor;

    private SharedPreferenceUtil(Context context) {
        mContext = context;
        mSharedPreferences = context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        mSharedPreferencesEditor = mSharedPreferences.edit();
    }

    public static synchronized SharedPreferenceUtil getInstance(Context context) {

        if (mSharedPreferenceUtils == null) {
            mSharedPreferenceUtils = new SharedPreferenceUtil(context.getApplicationContext());
        }
        return mSharedPreferenceUtils;
    }

    public void setType(int value) {
        mSharedPreferencesEditor.putInt("loginType", value);
        mSharedPreferencesEditor.commit();
    }
    public void setLoginId(String value) {
        mSharedPreferencesEditor.putString("loginId", value);
        mSharedPreferencesEditor.commit();
    }
    public String getloginId() {
        return mSharedPreferences.getString("loginId","");
    }
    public int getType() {
        return mSharedPreferences.getInt("loginType", 0);
    }


    public void clear() {
        mSharedPreferencesEditor.clear().commit();
    }
}
