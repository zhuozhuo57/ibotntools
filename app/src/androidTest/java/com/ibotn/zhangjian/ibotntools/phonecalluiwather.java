package com.ibotn.zhangjian.ibotntools;

import android.app.Instrumentation;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiWatcher;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

/**
 * Created by zhangjian on 2017/12/26.
 */
@RunWith(AndroidJUnit4.class)
public class phonecalluiwather {

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

        final UiObject2 ui = mDevice.findObject(By.res("com.ibotn.ibotnphone", "com.ibotn.ibotnphone:id/accept_call_btn"));
        //注册监听器
        mDevice.registerWatcher("testWatcher", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                if (mDevice.hasObject(By.res("com.ibotn.ibotnphone", "com.ibotn.ibotnphone:id/accept_call_btn"))) {
                    ui.click();
                    Log.i("testWatcher", "监听器被触发了");
                    return true;
                }
                Log.i("testWatcher", "监听器未被触发");
                return false;
            }
        });

        //运行用例步骤
        //mDevice.wait(Until.findObject(By.res("com.ibotn.ibotnphone", "com.ibotn.ibotnphone:id/accept_call_btn")));
        mDevice.waitForWindowUpdate("com.ibotn.ibotnphone", 10000);
        //mDevice.findObject(new UiSelector().resourceId("com.ibotn.ibotnphone:id/accept_call_btn"));
        //  UiObject2 btn = mDevice.findObject(By.text("写短信"));
    /*    UiObject2 accept_call_btn=mDevice.findObject(By.res("com.ibotn.ibotnphone", "com.ibotn.ibotnphone:id/accept_call_btn"));
                accept_call_btn.click();*/
        Thread.sleep(2000);
        mDevice.pressBack();
        mDevice.pressBack();
        int i = 0;
        for (i = 0; i < 1000; i++) {
            UiObject phonecall = mDevice.findObject((new UiSelector().resourceId("com.ibotn.ibotnphone:id/accept_call_btn")));
            if (phonecall.exists() == true) {
                try {
                    phonecall.clickAndWaitForNewWindow(3000);
                    Thread.sleep(7000);
                    UiObject endcall = mDevice.findObject((new UiSelector().resourceId("com.ibotn.ibotnphone:id/end_call_btn")));
                    if (endcall.exists() == true) {
                        endcall.clickAndWaitForNewWindow(3000);
                        Thread.sleep(7000);
                    }
                } catch (UiObjectNotFoundException e) {
                    e.printStackTrace();
                    Log.d(TAG, "phone call checkForCondition: error ");
                }
            }
            Thread.sleep(2000);
            mDevice.pressBack();
            Thread.sleep(2000);
            Log.d(TAG, "phone call checkForCondition:  " + i + "times");
        }
        //重置监听器
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
        mDevice.pressBack();

    }

}








