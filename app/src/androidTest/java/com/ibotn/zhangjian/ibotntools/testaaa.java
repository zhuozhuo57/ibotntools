package com.ibotn.zhangjian.ibotntools;

import android.app.Instrumentation;
import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.text.format.Time;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

/**
 * Created by LENOVO on 2016/1/21.
 */
@RunWith(AndroidJUnit4.class)
public class testaaa extends UiAutomatorInstrumentationTestRunner {
    private static final String TAG = "switch_widget";
    Time time;
    String filepath = "/mnt/sd-ext/wifitest/";
    UiDevice device;
    Instrumentation instrumentation;

    @Before
    public void setUp() {

        instrumentation = getInstrumentation();
        device = UiDevice.getInstance(instrumentation);

    }

    @Test
/*    public void testSettext () {
        UiObject2 sendMessage = device.findObject(By.res("com.android.mms:id/smsmms_sms_text_edit"));
        sendMessage.setText("new set text");
        sleep(2000);
        sendMessage.clear();
        sleep(2000);
        sendMessage.setText("old set text");
    }*/
    public void setting(Context context) throws UiObjectNotFoundException, IOException {
        // String times = time.year + "年" + time.month+1 + "月" + time.monthDay + "日" + time.hour + "时" + time.minute + "分" + time.second + "秒" + ":现在是一年中的第" + time.yearDay + "天";
        //String strsetting;
/*

            String strsetting = "am strat -n com.android.settings/.Settings";
            String devicesid = device.executeShellCommand("adb devices");
             // Process process = Runtime.getRuntime().exec(devicesid);
            device.executeShellCommand("adb -s " + devicesid + "shell" + strsetting);

        Log.d(TAG, "setting: ");
        device.executeShellCommand("am strat -n com.android.settings/.Settings");
        sleep(2000);
        Log.d(TAG, "adb devices is "+devicesid+"\n");
*/

        // UiObject2 wlan = device.findObject(By.res("com.android.settings:id/title").text("WLAN"));
        //  wlan.clickAndWait(Until.newWindow(), 2000);
        // Log.d(TAG, wlan+"is found");
        device.pressBack();
        device.pressBack();
        device.pressBack();
        device.pressBack();
        device.pressHome();
        device.pressHome();
        // device.runWatchers();
        sleep(2000);
       /* device.registerWatcher("setting_uiwatcher", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                UiObject2 Setting = device.findObject(By.res("com.ibotn.ibotnlauncher", "com.ibotn.ibotnlauncher:id/iv_setting"));
                Setting.clickAndWait(Until.newWindow(), 2000);
                return false;
            }
        });
        device.registerWatcher("WLAN_uiwatcher", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                UiObject2 WLAN = device.findObject(By.res("com.android.settings", "com.android.settings:id/title"));
                WLAN.clickAndWait(Until.newWindow(), 2000);
                return false;
            }
        });
        device.registerWatcher("switch_widget_uiwatcher", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                UiObject2 switch_widget = device.findObject(By.res("com.android.settings", "com.android.settings:id/switch_text"));
                switch_widget.clickAndWait(Until.newWindow(), 2000);

                return false;
            }
        });*/
        // Toast.makeText(context, "找不到任何监听器", Toast.LENGTH_SHORT).show();

/*        device.removeWatcher("setting_uiwatcher");
        device.removeWatcher("WLAN_uiwatcher");
        device.removeWatcher("switch_widget_uiwatcher");
        device.hasWatcherTriggered("setting_uiwatcher");
        device.hasWatcherTriggered("WLAN_uiwatcher");
        device.hasWatcherTriggered("switch_widget_uiwatcher");*/
    }

    public boolean screenshot(String filepath) {


        File file = new File(filepath);
        if (!file.exists()) {
            file.mkdir();
        }
        return false;

    }

    public void wifitest() throws UiObjectNotFoundException {
        UiObject switch_widget = device.findObject(new UiSelector().resourceId("com.android.settings:id/switch_widget"));
        Log.d(TAG, switch_widget + "is found");
        int i;
        for (i = 0; i < 10000; i++) {
            if (switch_widget.exists() == true) {
                switch_widget.clickAndWaitForNewWindow();
                sleep(2000);
                Log.d(TAG, "The wifi button has been clicked for" + i + "times");
            } else {
                //device.executeShellCommand("adb logcat -v time >sdcard/"+switch_widget+"not found"+".log");
                Log.d(TAG, "switch_widget test for" + i + "times is not be found");
                String sss;
                //screenshot(String filepath);

                takephotos();
            }

        }
        Log.d(TAG, "wifi test done" + i + "times");
    }

    public void takephotos() {
        Date a = new Date();
        SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String c = b.format(a);
        System.out.println(c);
        screenshot(filepath);
        File files = new File(filepath + c + ".png");
        device.takeScreenshot(files);
    }


    public void sleep(int mint) {
        try {
            Thread.sleep(mint);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
  /*  private String getImei(){
        TelephonyManager TelephonyMgr = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        String szImei = TelephonyMgr.getDeviceId();
        return szImei;
    }*/
}
