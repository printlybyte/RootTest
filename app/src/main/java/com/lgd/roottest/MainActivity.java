package com.lgd.roottest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lgd.roottest.manager.CmdManager;



public class MainActivity extends AppCompatActivity {
    CmdManager cmdManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cmdManager = CmdManager.getCmdManagerInstance();
        cmdManager.applyForRootPermission();

    }

    public void startWifi1(View V) {
        cmdManager.setSettingsWifi(true);
    }

    public void startWifi2(View V) {
        cmdManager.setSettingsWifi(false);
    }

    public void startWifi3(View V) {
        cmdManager.setSettingsFlayingMode(true);
    }

    public void startWifi4(View V) {
        cmdManager.setSettingsFlayingMode(false);
    }

    public void startWifi5(View V) {
        cmdManager.setSettingsDataMode(true);
    }

    public void startWifi6(View V) {
        cmdManager.setSettingsDataMode(false);
    }
    public void startWifi7(View V) {
        cmdManager.setSettingsReboot( );
    }


    public void startWifi8(View V) {

    }



    public static boolean isWifi(Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null
                && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        }
        return false;
    }
}
