package com.ibotn.zhangjian.ibotntools;

import android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiWatcher;
import android.util.Log;

public class presstest extends UiAutomatorInstrumentationTestRunner {

    private static final String TAG = "test onclick";
    public UiDevice device;
    public UiObject object;
    public UiWatcher uiWatcher;
    public UiScrollable uiScrollable;
    public UiSelector uiSelector;
    public String resourceid;
    public String text;
    public int index;
    public int[][] point;

    public boolean clicktext() throws UiObjectNotFoundException {
        if (object.isClickable() != true) {
            device.waitForWindowUpdate(text, 500);
            Log.d(TAG, "clicktext: " + "500ms delay");
            device.findObject(uiSelector.clickable(true).text(text)).click();
            return true;
        } else {
            Log.d(TAG, "test onclick:" + "clicktext not be found");
            return false;
        }
    }

    public boolean clickresourceid() throws UiObjectNotFoundException {
        device.findObject(uiSelector.clickable(true).resourceId(resourceid)).click();
        return true;
    }

    public boolean clickindex() throws UiObjectNotFoundException {
        device.findObject(uiSelector.clickable(true).index(index)).click();
        return true;
    }

    public boolean clickpoint() {
        int x;
        int y;
        int Rect;
        device.findObject(uiSelector.packageName(toString()).className(getClass().toString()));
        x = device.getDisplayHeight();
        y = device.getDisplayWidth();
        device.click(Rect = x / 2, y / 2);
        return true;
    }
/*    public boolean click(String text, String resourceid, int index, int[] point) throws IOException {
        device.executeShellCommand("adb root");
       device.executeShellCommand("adb shell uiautomator dump ");
        File file=new File("");
        file.get

        return true;
    }*/

}










