package com.ibotn.zhangjian.ibotntools;

import android.app.Instrumentation;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static java.lang.Thread.sleep;


/**
 * Created by zhangjian on 2018/1/9.
 **/

@RunWith(AndroidJUnit4.class)
public class fktest extends UiAutomatorInstrumentationTestRunner {
    // UiObject2 mDevice;
    UiDevice device;
    Instrumentation instrumentation;

    @Before
    public void setup() {
        instrumentation = getInstrumentation();
        device = UiDevice.getInstance(instrumentation);
    }

    @Test
    public void test() throws UiObjectNotFoundException, InterruptedException {
        UiObject2 content = device.findObject(By.text("访客模式"));
        // UiObject2 collection=content.findObject(By.res("android.widget.LinearLayout","com.ibotn.ibotnphone:id/ll_visitor"));
        content.isClickable();
        content.click();
        sleep(3000);
        UiObject2 OFF = device.findObject(By.selected(false).res("android.widget.TextView", "com.ibotn.ibotnphone:id/tv_remind_switch").text("访客模式关"));
        OFF.click();
        sleep(3000);
        device.findObject(By.res("android.widget.RelativeLayout", "com.ibotn.ibotnphone:id/top_area"));
        UiScrollable uiScrollable = new UiScrollable(new UiSelector().className("android.widget.ImageView").index(2));
        uiScrollable.click();
    }

    public boolean equals(Object obj) {
        UiObject2 content = device.findObject(By.res("android.widget.FrameLayout", "android:id/content"));
        UiObject2 collection = content.findObject(By.scrollable(true).res("android.widget.LinearLayout", "com.ibotn.ibotnphone:id/ll_visitor"));
        collection.isClickable();
        collection.click();

        UiObject2 fangke = device.findObject(By.res("android.widget.LinearLayout", "com.ibotn.ibotnphone:id/ll_visitor"));
        fangke.click();
        return false;
    }


}
