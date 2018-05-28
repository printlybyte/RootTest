package com.lgd.roottest.constant;

/**
 * Created by Administrator on 2018/5/24.
 */

public class Constant {
    public static final String REBOOT = "reboot";
    public static final String WIFI_ON = "svc wifi enable";
    public static final String WIFI_OFF = "svc wifi disable";
    public static final String DATE_ON = "svc data enable";
    public static final String DATE_OFF = "svc data disable";
    public static final String AIRPLANE_MODE_ON = "settings put global airplane_mode_on 1"+'\n'+"am broadcast -a android.intent.action.AIRPLANE_MODE --ez state true";
    public static final String AIRPLANE_MODE_OFF = "settings put global airplane_mode_on 0"+'\n'+"am broadcast -a android.intent.action.AIRPLANE_MODE --ez state false";
}
