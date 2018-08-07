package com.ibotn.zhangjian.ibotntools;

import android.app.Instrumentation;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

/**
 * Created by zhangjian on 2017/12/26.
 */
@RunWith(AndroidJUnit4.class)
public class IbotnTest {

    private static final String TAG = "phonecall";
    UiDevice mDevice;
    Instrumentation instrumentation;

    @Before
    public void setUp() {

        instrumentation = getInstrumentation();
        mDevice = UiDevice.getInstance(instrumentation);

    }

    @Test
    public void testcase10() throws InterruptedException {

        int i = 0;
        while (true) {
            try {
                UiObject phonecall = mDevice.findObject((new UiSelector().resourceId("com.ibotn.ibotnphone:id/accept_call_btn")));
                if (phonecall.exists()) {
                    phonecall.clickAndWaitForNewWindow(500);
                    Log.d(TAG, "phone accepet is exist and click  ");
                    Thread.sleep(3000);
                    UiObject endcall = mDevice.findObject((new UiSelector().resourceId("com.ibotn.ibotnphone:id/end_call_btn")));
                    if (endcall.exists()) {
                        endcall.clickAndWaitForNewWindow(500);
//                        Thread.sleep(7000);
                    }

                } else {
                    Thread.sleep(2000);
                }
//                mDevice.pressBack();
//            Thread.sleep(2000);
                Log.d(TAG, "phone call checkForCondition:  " + i++ + "times");
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, "phone call checkForCondition: error ");
            }
        }
       /* //重置监听器
        mDevice.resetWatcherTriggers();
        // mDevice.wait(Until.findObject(By.text("写短信")), 2000);
        mDevice.waitForWindowUpdate("com.ibotn.ibotnphone", 10000);
        mDevice.pressBack();
        Thread.sleep(2000);
        mDevice.pressBack();
        Log.i("testWatcher", "重置监听器成功");

        //移除监听器
        mDevice.removeWatcher("testWatcher");
        Log.i("testWatcher", "移除监听器成功");
        mDevice.waitForWindowUpdate("com.ibotn.ibotnphone", 10000);
        mDevice.pressBack();
        Thread.sleep(2000);
        mDevice.pressBack();*/

    }

}








