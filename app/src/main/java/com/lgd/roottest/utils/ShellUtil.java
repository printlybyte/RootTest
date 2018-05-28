package com.lgd.roottest.utils;

/**
 * Created by Administrator on 2017/6/21.
 */

import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ShellUtil {
    private static String TAG = ShellUtil.class.getName();

    public static String runCommand(String command) {
        Process process = null;
        String result = "false";
        try {
            process = Runtime.getRuntime().exec(command);
            process.waitFor();
            result = inputStreamToString(process.getInputStream());
            Log.e(TAG, result);
        } catch (Exception e) {
            return result;
        } finally {
            try {
                process.destroy();
            } catch (Exception e) {
            }
        }
        return result;
    }


    public static String runRootCmd(String command) {
        return runRootCmd(command, ";");
    }

    public static String runRootCmd(String command, String split) {
        Process process = null;
        DataOutputStream os = null;
        String result = "false";
        try {
            process = Runtime.getRuntime().exec("su");
            OutputStream outstream = process.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outstream);
            String temp = "";
            String[] cmds = command.split(split);
            for (int i = 0; i < cmds.length; i++)
                temp += cmds[i] + "\n";
            dataOutputStream.writeBytes(temp);
            dataOutputStream.flush();
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.flush();
            process.waitFor();
            result = inputStreamToString(process.getInputStream());
            Log.i(TAG, temp);

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return result;
        } finally {
            Log.i(TAG, result);
            try {
                if (os != null) {
                    os.close();
                }
                process.destroy();
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
        }
        return result;
    }

    private static String inputStreamToString(InputStream in) throws IOException {
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[1024];
        for (int n; (n = in.read(b)) != -1; ) {
            out.append(new String(b, 0, n));
        }
        return out.toString();
    }
}