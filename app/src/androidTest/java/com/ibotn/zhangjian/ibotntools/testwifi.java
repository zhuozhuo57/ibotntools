package com.ibotn.zhangjian.ibotntools;

/**
 * Created by zhangjian on 2017/12/22.
 */

import android.app.Instrumentation;
import android.content.Context;
import android.os.RemoteException;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2Condition;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.text.format.Time;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.widget.TextView;


/**
 * Created by LENOVO on 2016/1/21.
 */
@RunWith(AndroidJUnit4.class)
public  class testwifi  extends UiAutomatorInstrumentationTestRunner {
    Time time;

    private static final String TAG ="switch_widget" ;
    UiDevice device;
    Instrumentation instrumentation;

    @Before
    public void setUp () {

        instrumentation = getInstrumentation();
        device = UiDevice.getInstance(instrumentation);

    }
    @Test

    public void setting ( ) throws UiObjectNotFoundException, IOException {
   /*     try {
            //unlock();
            Log.d(TAG, "unlock: OK");
        } catch (RemoteException e) {
            e.printStackTrace();
            Log.d(TAG, "unlock: faild");
        }*/

        sleep(2000);
            //UiObject2 content = device.findObject(By.res("com.ibotn.ibotnlauncher", "android:id/content"));
            //content.clickAndWait(Until.newWindow(), 2000);

       // UiObject2 Setting = device.findObject(By.res("com.ibotn.ibotnlauncher", "com.ibotn.ibotnlauncher:id/iv_setting"));
       // UiObject2 Setting=device.findObject(By.clazz(TextView.class).minDepth(10));
 /*       xpath="//android.widget.ImageView[@resource-id=\\\"com.ibotn.ibotnlauncher:id/iv_setting\\\"]"
        UiObject2 Setting=device.findObject(By.hasDescendant(x"//android.widget.ImageView[@resource-id=\"com.ibotn.ibotnlauncher:id/iv_setting\"]"));
        UiObject2 s=device.findObj*/

        //UiObject Setting=device.findObject(new UiSelector().scrollable(false).resourceId("com.ibotn.ibotnlauncher:id/iv_setting"));
        //Setting.clickAndWaitForNewWindow(2000);
        device.pressBack();
        device.pressBack();
        device.pressBack();
        device.pressHome();
        device.executeShellCommand("adb shell am  start -n com.android.settings/com.android.settings.Settings");
        UiObject2 settings=device.findObject(By.text("设置"));
        settings.click();
        sleep(2000);
   /*     UiObject2 title=device.findObject(By.res("com.android.settings", "com.android.settings:id/title"));
        title.clickAndWait(Until.newWindow(),2000);*/
        sleep(2000);
        UiObject2 wlan = device.findObject(By.res("com.android.settings:id/title").text("WLAN"));
         wlan.clickAndWait(Until.newWindow(), 2000);
        sleep(2000);
        wifitest();
    }
/*
    public void unlock() throws RemoteException {
        UiObject2 git_img = device.findObject(By.res("com.ibotn.ibotnlauncher:id/git_img"));
        git_img.clickAndWait(Until.newWindow(), 2000);
        if (device.isScreenOn()== false||git_img.isClickable()) {
            device.pressBack();
            device.pressBack();
            device.pressBack();
            device.pressBack();
            device.pressHome();
            device.pressHome();
            center();

            sleep(200);
        }else{
           device.isScreenOn();
           // UiObject2 git_img = device.findObject(By.res("com.ibotn.ibotnlauncher:id/git_img"));
            center();
            Log.d(TAG, "亮屏解锁成功");
            sleep(200);
        }
    }*/
    public  boolean  screenshot(String filepath) {
        File file = new File(filepath);
        if (!file.exists()) {
            file.mkdir();
        }
        return  false;
    }
    public void center(){
        int x = device.getDisplayHeight();
        int y=device.getDisplayWidth();
        device.click(x/2,y/2);


    }
    public void wifitest()throws UiObjectNotFoundException{
        UiObject switch_widget = device.findObject(new UiSelector().resourceId("com.android.settings:id/switch_widget"));
        Log.d(TAG, switch_widget+"is found");
        int i;
        for(i=0;i<10000;i++) {
            if (switch_widget.exists() == true) {
                switch_widget.clickAndWaitForNewWindow();
                sleep(2000);
                Log.d(TAG, "The wifi button has been clicked for" + i + "times");
            }else{
                Log.d(TAG, "switch_widget test for"+i+"times is not be found");
                String sss;
                takephotos();
            }
        }
        Log.d(TAG, "wifi test done"+i+"times");
    }
    public void takephotos() {
        String filepath ="/storage/sd-ext/wifitest/";
        Date a = new Date();
        SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String c = b.format(a);
        System.out.println(c);
        screenshot(filepath);
        File files = new File(filepath + c + ".png");
        device.takeScreenshot(files);
    }





    public void sleep(int mint){
        try {
            Thread.sleep(mint);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

