package com.ibotn.zhangjian.ibotntools;

/**
 * Created by zhangjian on 2018/1/6.
 */

import android.app.Instrumentation;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiCollection;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;
import android.widget.RelativeLayout;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

/**
 * Created by zhangjian on 2017/12/26.
 */
@RunWith(AndroidJUnit4.class)
public class PhoneTest {

    private static final String TAG = "phonecall";
    UiDevice mDevice;
    Instrumentation instrumentation;

    @Before
    public void setUp() {

        instrumentation = getInstrumentation();
        mDevice = UiDevice.getInstance(instrumentation);
    }

    @Test
    public void testcase11() throws InterruptedException, UiObjectNotFoundException, RemoteException {

        //运行用例步骤
        mDevice.pressHome();
        mDevice.waitForWindowUpdate("com.yulong.android.launcher3", 10000);
        Thread.sleep(2000);
        UiObject2 ibotn = mDevice.findObject(By.text("ibotn"));
        if (ibotn != null) {
            ibotn.click();//打开APP
        }
        mDevice.waitForWindowUpdate("com.ibotn.phone", 3000);
        int i = 0;
        while (true) {
            try {
                int x1, x2, y1, y2;
                UiObject content = new UiScrollable(new UiSelector().className("android.widget.FrameLayout").resourceId("android:id/content"));
                content.exists();
                UiObject rl_fragments = new UiScrollable(new UiSelector().className("android.widget.RelativeLayout").resourceId("com.ibotn.phone:id/rl_fragments"));
                rl_fragments.exists();
                UiObject reLayout = new UiCollection(new UiSelector().className("android.widget.RelativeLayout").index(2));
                reLayout.getChildCount();
                UiObject slideViewChild = reLayout.getChild(new UiSelector().resourceId("com.ibotn.phone:id/slideView"));
                slideViewChild.exists();
                Rect center = slideViewChild.getBounds();
                x1 = center.left;
                x2 = center.right;
                y1 = center.top;
                y2 = center.bottom;
                mDevice.drag(x1 + 100, y1 + (y2 - y1) / 2, x2 + 100, y1 + (y2 - y1) / 2, 9);
                Log.d(TAG, "phone call for " + i + " times");
                UiObject tvLogin = new UiScrollable(new UiSelector().className(RelativeLayout.class).resourceId("com.ibotn.phone:id/relativlayout1"))
                        .getChild(new UiSelector().resourceId("com.ibotn.phone:id/tv_login_state"));
                if (tvLogin.exists()) {
                    Log.i(TAG, "tvLogin is exists and click  ");
                    tvLogin.click();
                }
                if (reLayout.exists()) {
                    if (mDevice.isNaturalOrientation()) {
                        Thread.sleep(3000);
                    }
                }
                UiObject endcall = mDevice.findObject((new UiSelector().resourceId("com.ibotn.phone:id/end_call_btn")));
                if (endcall.exists()) {
                    Thread.sleep(5000);
                    endcall.clickAndWaitForNewWindow(1000);
                    Log.i(TAG, "endcall is exist and click  ");
                }
                Thread.sleep(2000);
                Log.i(TAG, "phone call checkForCondition:  " + i++ + "times");
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, "phone call checkForCondition: error ");
            }
        }
  /* mDevice.waitForWindowUpdate("com.ibotn.phone", 10000);
        Thread.sleep(2000);
        mDevice.pressBack();
        mDevice.waitForWindowUpdate("com.ibotn.phone", 10000);
        mDevice.pressBack();
        Thread.sleep(2000);
        mDevice.pressBack();*/

    }

}










