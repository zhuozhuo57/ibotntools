package com.ibotn.zhangjian.ibotntools;

import android.app.Instrumentation;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiWatcher;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

/**
 * Created by zhangjian on 2018/1/31.
 */

@RunWith(AndroidJUnit4.class)

public class testuiwatcher {
    UiDevice mDevice;
    Instrumentation instrumentation;

    @Before
    public void setup() {
        instrumentation = getInstrumentation();
        mDevice = UiDevice.getInstance(instrumentation);
    }

    @Test
    public void test1() {
        mDevice.pressHome();
        mDevice.pressBack();
        mDevice.pressBack();
        final UiObject2 ui = mDevice.findObject(By.res("com.ibotn.ibotnphone", "com.ibotn.ibotnphone:id/accept_call_btn"));
        mDevice.registerWatcher("testWatcher", new UiWatcher() {
            public boolean checkForCondition() {

                ui.findObject(By.res("com.ibotn.ibotnphone", "com.ibotn.ibotnphone:id/accept_call_btn"));
                return true;
            }
        });

    }
}
