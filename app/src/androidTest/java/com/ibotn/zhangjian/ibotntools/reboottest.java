package com.ibotn.zhangjian.ibotntools;

import android.app.Instrumentation;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

/**
 * Created by zhangjian on 2018/6/8.
 */
@RunWith(AndroidJUnit4.class)
public class reboottest {


    private static final String TAG = "phonecall";
    UiDevice mDevice;
    Instrumentation instrumentation;

    @Before
    public void setUp() {

        instrumentation = getInstrumentation();
        mDevice = UiDevice.getInstance(instrumentation);
    }

    @Test
    public void testcase11() throws IOException {
        int i = 0;
        if (i < 10) {


            Runtime.getRuntime().exec("adb reboot");
            i++;
            Log.d(TAG, "reboot: " + i + "times");
        }

    }
}

