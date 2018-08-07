package com.ibotn.zhangjian.ibotntools;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhangjian on 2018/5/11.
 */

public class otatest {
    /*
    1,get devices name
    2,do adb shell cmd
     */

    int ip;
    File path = new File("/storage/uhost/update.zip");
    File tagpath = new File("/storage/sd-ext/update.zip");

    public void install(String filename) throws IOException {
        //ip++;
/*        for(ip=2;ip<254;) {
            String devices = String.valueOf(Runtime.getRuntime().exec("adb connect" + "192.168.18." + ip));
            Log.d(TAG, "install: devices" + devices);
            Runtime.getRuntime().exec("adb connect" + devices + ":5555");
            Runtime.getRuntime().exec("adb -s " + devices + "root");
            Runtime.getRuntime().exec("adb connect" + devices + ":5555");
            Runtime.getRuntime().exec("adb -s " + devices + "remount");
            Runtime.getRuntime().exec("adb -s " + devices + "push\t" + path + tagpath);
            Runtime.getRuntime().exec("adb -s " + devices + "reboot recovery");
            ip++;
        }*/

        Runtime.getRuntime().exec("copy" + path + tagpath);
        Runtime.getRuntime().exec("reboot recovery");

    }


}

