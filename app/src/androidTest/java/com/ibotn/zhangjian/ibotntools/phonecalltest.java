package com.ibotn.zhangjian.ibotntools;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiWatcher;
import android.util.Log;
import android.widget.Toast;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static android.os.SystemClock.sleep;
import static android.support.test.InstrumentationRegistry.getInstrumentation;

/**
 * Created by zhangjian on 2017/12/25.
 */
@RunWith(AndroidJUnit4.class)
public class phonecalltest extends UiAutomatorInstrumentationTestRunner {
    Instrumentation instrumentation;
    private static final String TAG ="phonecalltest" ;
    private  UiDevice device;
    int i;
    int j;
    @Before
    public void setUp () {
        instrumentation = getInstrumentation();
        device = UiDevice.getInstance(instrumentation);
    }
    @Test
        public void testeee() throws UiObjectNotFoundException{

            accept_call_btn();
            device.pressBack();
            device.pressBack();
            device.pressBack();
            device.pressHome();
          //  UiObject2 U=device.findObject(By.res("com.ibotn.ibotnphone", "com.ibotn.ibotnphone:id/accept_call_btn"));
            accept_call_btn();
            end_call_btn();
        }

        public void accept_call_btn ()throws UiObjectNotFoundException {
            final UiObject2 accept_call_btn = device.findObject(By.res("com.ibotn.ibotnphone", "com.ibotn.ibotnphone:id/accept_call_btn"));
            device.registerWatcher("accept_call_btn", new UiWatcher() {
                        @Override
                        public boolean checkForCondition() {

                            if (accept_call_btn.hasObject(By.res("com.ibotn.ibotnphone", "com.ibotn.ibotnphone:id/accept_call_btn"))) {
                                accept_call_btn.click();
                                return true;
                            }
                            Log.d(TAG, "phone call checkForCondition: " + i + "times");
                            i++;
                            return true;
                        }
                    }
            );
        }
    public boolean end_call_btn() throws UiObjectNotFoundException {
        final UiObject2 end_call_btn = device.findObject(By.res("com.ibotn.ibotnphone", "com.ibotn.ibotnphone:id/end_call_btn"));
        device.registerWatcher("end_call_btn", new UiWatcher() {

                    @Override
                    public boolean checkForCondition() {
                        if (device.hasObject(By.res("com.ibotn.ibotnphone", "com.ibotn.ibotnphone:id/end_call_btn")))
                            ;
                        end_call_btn.click();
                        Log.d(TAG, "phonecalldending checkForCondition: " + j + "times");
                        j++;
                        return true;
                    }
                }
        );
        return true;
    }

}

