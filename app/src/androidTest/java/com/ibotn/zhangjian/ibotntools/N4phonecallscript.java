package com.ibotn.zhangjian.ibotntools;

/**
 * Created by zhangjian on 2018/1/6.
 */

import android.app.Instrumentation;
import android.graphics.Rect;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiCollection;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiWatcher;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.uiautomator.Direction.RIGHT;

/**
 * Created by zhangjian on 2017/12/26.
 */
@RunWith(AndroidJUnit4.class)
public class N4phonecallscript {

    private static final String TAG = "phonecall";
    UiDevice mDevice;
    Instrumentation instrumentation;

    @Before
    public void setUp() {

        instrumentation = getInstrumentation();
        mDevice = UiDevice.getInstance(instrumentation);
    }

    @Test
    public void testcase11() throws InterruptedException, UiObjectNotFoundException {

        final UiObject2 slideView = mDevice.findObject(By.res("com.ibotn.phone", "com.ibotn.phone:id/slideView"));
        //注册监听器
        mDevice.registerWatcher("testWatcher", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                if (mDevice.hasObject(By.res("com.ibotn.phone", "com.ibotn.phone:id/slideView"))) {
                    slideView.swipe(RIGHT, 0.8f, 500);
                    Log.i("testWatcher", "监听器被触发了");
                    return true;
                }
                Log.i("testWatcher", "监听器未被触发");
                return false;
            }
        });
        //运行用例步骤
        mDevice.pressHome();
        mDevice.waitForWindowUpdate("com.yulong.android.launcher3", 10000);
        Thread.sleep(2000);

        UiObject2 ibotn = mDevice.findObject(By.text("ibotn"));
        ibotn.click();

        mDevice.waitForWindowUpdate("com.ibotn.phone", 3000);
        int i = 0;
        for (i = 0; i < 10000; i++) {
            int x1 = 0;
            int x2 = 0;
            int y1 = 0;
            int y2 = 0;


            UiObject content = new UiScrollable(new UiSelector().className("android.widget.FrameLayout").resourceId("android:id/content"));
            content.exists();
            UiObject rl_fragments = new UiScrollable(new UiSelector().className("android.widget.RelativeLayout").resourceId("com.ibotn.phone:id/rl_fragments"));
            rl_fragments.exists();
            UiObject RelativeLayout = new UiCollection(new UiSelector().className("android.widget.RelativeLayout").index(2));
            RelativeLayout.getChildCount();
            Log.d(TAG, "index: 2");
            UiObject getChild = RelativeLayout.getChild(new UiSelector().resourceId("com.ibotn.phone:id/slideView"));
            getChild.exists();
            Log.d(TAG, "getChild: ");
            Rect center = getChild.getBounds();
/*            r.left; //矩形左上角顶点X坐标
            r.top; //矩形左上角顶点Y坐标
            r.right; //矩形右下角顶点X坐标
            r.bottom; //矩形右下角顶点Y坐标
            r.centerX(); //矩形的中心点X坐标
            r.centerY(); //矩形的中心点Y坐标*/
            x1 = center.left;
            x2 = center.right;
            y1 = center.top;
            y2 = center.bottom;
            mDevice.drag(x1 + 100, y1 + (y2 - y1) / 2, x2 + 100, y1 + (y2 - y1) / 2, 9);
            Log.d(TAG, "phone call for " + i + "times");
            if (RelativeLayout.exists() == true) {
                try {

                    if (mDevice.isNaturalOrientation() == true) {
                        Thread.sleep(10000);

                    }
                    UiObject endcall = mDevice.findObject((new UiSelector().resourceId("com.ibotn.phone:id/end_call_btn")));
                    if (endcall.exists() == true) {
                        endcall.clickAndWaitForNewWindow(3000);
                    }
                } catch (UiObjectNotFoundException e) {
                    e.printStackTrace();
                    Log.d(TAG, "phone call checkForCondition: error ");
                }
            }
            Thread.sleep(2000);
            Thread.sleep(2000);
            Log.d(TAG, "phone call checkForCondition:  " + i + "times");
        }
        //重置监听器
        mDevice.waitForWindowUpdate("com.ibotn.phone", 10000);
        Thread.sleep(2000);
        mDevice.pressBack();
        Log.i("testWatcher", "重置监听器成功");
        //移除监听器
        Log.i("testWatcher", "移除监听器成功");
        mDevice.waitForWindowUpdate("com.ibotn.phone", 10000);
        mDevice.pressBack();
        Thread.sleep(2000);
        mDevice.pressBack();

    }

}










