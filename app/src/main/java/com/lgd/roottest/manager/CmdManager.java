package com.lgd.roottest.manager;

import android.util.Log;

import com.lgd.roottest.constant.Constant;
import com.lgd.roottest.utils.ShellUtil;

/**
 * Created by Administrator on 2018/5/24.
 */

public class CmdManager {
    private CmdManager() {
    }

    public static CmdManager getCmdManagerInstance() {
        return CmdManagerHoder.cmdManagerHoder;
    }

    private static class CmdManagerHoder {
        private static final CmdManager cmdManagerHoder = new CmdManager();
    }

    /**
     * @Params: 申请root权限
     * @Author: liuguodong
     * @Date: 2018/5/24 15:49
     * @return：
     */
    public void applyForRootPermission() {
        AppOperator.runOnThread(new Runnable() {
            @Override
            public void run() {
                ShellUtil.runCommand("su");
            }
        });
    }

    /**
     * @Params: 设置wifi
     * @Author: liuguodong
     * @Date: 2018/5/24 15:45
     * @return：
     */
    public void setSettingsWifi(final boolean is) {
        AppOperator.runOnThread(new Runnable() {
            @Override
            public void run() {
                if (is) {
                    ShellUtil.runRootCmd(Constant.WIFI_ON);
                } else {
                    ShellUtil.runRootCmd(Constant.WIFI_OFF);
                }
            }
        });

    }

    /**
     * @Params: 设置飞行模式
     * @Author: liuguodong
     * @Date: 2018/5/24 15:47
     * @return：
     */
    public void setSettingsFlayingMode(final boolean is) {
        AppOperator.runOnThread(new Runnable() {
            @Override
            public void run() {
                if (is) {
                    ShellUtil.runRootCmd(Constant.AIRPLANE_MODE_ON);
                } else {
                    ShellUtil.runRootCmd(Constant.AIRPLANE_MODE_OFF);
                }
            }
        });
    }
/**
 *@Params: 设置数据
 *@Author: liuguodong
 *@Date: 2018/5/28 11:25
 *@return：
 */
    public void setSettingsDataMode(final boolean is) {
        AppOperator.runOnThread(new Runnable() {
            @Override
            public void run() {
                if (is) {
                    ShellUtil.runRootCmd(Constant.DATE_ON);
                } else {
                    ShellUtil.runRootCmd(Constant.DATE_OFF);
                }
            }
        });
    }
    /**
     *@Params: 重启
     *@Author: liuguodong
     *@Date: 2018/5/28 11:26
     *@return：
     */
    public void setSettingsReboot( ) {
        AppOperator.runOnThread(new Runnable() {
            @Override
            public void run() {
                    ShellUtil.runRootCmd(Constant.REBOOT);
            }
        });
    }

}
