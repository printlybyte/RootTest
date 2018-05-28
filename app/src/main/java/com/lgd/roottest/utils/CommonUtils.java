package com.lgd.roottest.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.widget.Toast;

import static android.content.Context.WIFI_SERVICE;

/**
 * Created by Administrator on 2018/5/25.
 * 静态单例模式 通用工具类库
 */

public class CommonUtils {

    private CommonUtils() {
    }

    public static CommonUtils getCmdManagerInstance() {

        return CommonUtilsHoder.cmdManagerHoder;
    }

    private static class CommonUtilsHoder {
        private static final CommonUtils cmdManagerHoder = new CommonUtils();
    }

    /**
     * @Params:
     * @Author: liuguodong
     * @Date: 2018/5/25 15:00
     * @return：已连接返回ture 未连接返回false
     */
    public boolean isCheckedWifiConnect(Context context, String ssid) {
        if (TextUtils.isEmpty(ssid)) {
            return false;
        }
        if (getConnectWifiSsid(context).equals(ssid)) {
            return true;
        }
        return false;

    }

    /**
     * @Params: 获取当前连接的ssid
     * @Author: liuguodong
     * @Date: 2018/5/25 15:00
     * @return：当前连接的ssid
     */
    private String getConnectWifiSsid(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        return wifiInfo.getSSID();
    }

    /**
     * @Params: 吐司
     * @Author: liuguodong
     * @Date: 2018/5/25 15:00
     * @return：
     */
    public void showToast(Context context, int msgid) {
        Toast.makeText(context, "" + context.getResources().getString(msgid), Toast.LENGTH_SHORT).show();
    }

    /**
     * @Params: 吐司
     * @Author: liuguodong
     * @Date: 2018/5/25 15:00
     * @return：
     */
    public void showToast(Context context, String msg) {
        Toast.makeText(context, "" + msg, Toast.LENGTH_SHORT).show();
    }

}
