package com.ibotn.zhangjian.ibotntools;

import android.app.Instrumentation;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.text.format.Time;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static java.lang.Thread.sleep;

@RunWith(AndroidJUnit4.class)
public class wifitest extends UiAutomatorInstrumentationTestRunner {
    private static final String TAG = "switch_widget";
    Time time;
    private UiDevice mDevice;
    private Instrumentation instrumentation;
    @Before
    public void setUp() {
        instrumentation = getInstrumentation();
        mDevice = UiDevice.getInstance(instrumentation);
    }
    @Test
    public void setting() throws UiObjectNotFoundException, IOException, InterruptedException {
        mDevice.executeShellCommand("am  start -n com.android.settings/com.android.settings.Settings");
       /// mDevice.executeShellCommand("logcat -v time >  /storage/sdcard/"+time+".log"+"&");
        Log.d(TAG, "setting: "+"am");
        sleep(3000);
        UiObject decor_content_parent= mDevice.findObject(new UiSelector().className("android.view.View").resourceId("android:id/decor_content_parent"));
        UiScrollable scrollable=new UiScrollable(new UiSelector().className("android.widget.ScrollView"));
        // getChildByText
        UiObject object=scrollable.getChildByText(new UiSelector().className("android.widget.TextView"), "WLAN", true);
        object.click();
        // getChildByInstance
        //scrollable.getChildByInstance(new UiSelector().className("android.widget.TextView"), 0).click();
       // UiObject2 wlan = mDevice.findObject(By.res("com.android.settings:id/title").text("WLAN"));
        UiObject switch_widget = mDevice.findObject(new UiSelector().resourceId("com.android.settings:id/switch_widget"));
        Log.d(TAG, switch_widget + "is found");
        int i;
        for (i = 1; i <=1000; i++) {
            if (switch_widget.exists()) {
                switch_widget.clickAndWaitForNewWindow(3000);
                Log.d(TAG, "setting: " + i + "times");
                if(i==1000) {
                    Log.d(TAG, "setting: test done");
                    return;
                }
                
            } else {

                setting();
                Log.d(TAG, "setting: " + i + "times filed");
            }
        }
    }
}


