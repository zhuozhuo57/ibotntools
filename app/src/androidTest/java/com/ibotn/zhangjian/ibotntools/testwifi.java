package com.ibotn.zhangjian.ibotntools;

/**
 * Created by zhangjian on 2017/12/22.
 */

import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.text.format.Time;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static java.lang.Thread.sleep;


/**
 * Created by LENOVO on 2016/1/21.
 */
@RunWith(AndroidJUnit4.class)
public class testwifi extends UiAutomatorInstrumentationTestRunner {
    private static final String TAG = "switch_widget";
    Time time;
    UiDevice device;
    //Instrumentation instrumentation;

    /*    @Before
        public void setUp() {
            instrumentation = getInstrumentation();
            device = UiDevice.getInstance(instrumentation);
        }*/
    @Test
    public void setting() throws UiObjectNotFoundException, IOException, InterruptedException {
/*        device.pressBack();
        device.pressBack();
        device.pressBack();
        device.pressHome();*/

        device.executeShellCommand("adb shell am  start -n com.android.settings/com.android.settings.Settings");
        UiObject2 settings = device.findObject(By.text("设置"));
        settings.click();
        sleep(2000);
        sleep(2000);
        UiObject2 wlan = device.findObject(By.res("com.android.settings:id/title").text("WLAN"));
        wlan.clickAndWait(Until.newWindow(), 2000);
        sleep(2000);
        UiObject switch_widget = device.findObject(new UiSelector().resourceId("com.android.settings:id/switch_widget"));
        Log.d(TAG, switch_widget + "is found");
        int i;
        for (i = 0; i < 10000; i++) {
            if (switch_widget.exists() == true) {
                switch_widget.clickAndWaitForNewWindow();
                sleep(2000);
                Log.d(TAG, "The wifi button has been clicked for" + i + "times");
            } else {
                Log.d(TAG, "switch_widget test for" + i + "times is not be found");
                String sss;
                // takephotos();
            }
            //wifitest();
        }
   /* public boolean screenshot(String filepath) {
        File file = new File(filepath);
        if (!file.exists()) {
            file.mkdir();
        }
        return false;
    }*/
 /*   public void center() {
        int x = device.getDisplayHeight();
        int y = device.getDisplayWidth();
        device.click(x / 2, y / 2);
    }*/
/*    public void wifitest() throws UiObjectNotFoundException, InterruptedException {
        UiObject switch_widget = device.findObject(new UiSelector().resourceId("com.android.settings:id/switch_widget"));
        Log.d(TAG, switch_widget + "is found");
        int i;
        for (i = 0; i < 10000; i++) {
            if (switch_widget.exists() == true) {
                switch_widget.clickAndWaitForNewWindow();
                sleep(2000);
                Log.d(TAG, "The wifi button has been clicked for" + i + "times");
            } else {
                Log.d(TAG, "switch_widget test for" + i + "times is not be found");
                String sss;
               // takephotos();
            }
        }
        Log.d(TAG, "wifi test done" + i + "times");
    }*/
    }
}