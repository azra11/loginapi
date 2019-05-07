package com.example.admin.login.Koneksi;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.admin.login.R;

public class sharedpreferencesconfig {
    private SharedPreferences sharedPreferences;
    private Context context;

    public sharedpreferencesconfig(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login), Context.MODE_PRIVATE);
    }

    public void writeLoginStatus(boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status_preference),status);
        editor.commit();
    }

    public void token(String token){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Token",token);
        editor.commit();
    }
    public String getToken(){
        return sharedPreferences.getString("Token",null);
    }
    public boolean readLoginStatus(){
        boolean status = false;
        status = sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status_preference), false);
        return status;
    }

}
