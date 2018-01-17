package com.ibotn.zhangjian.ibotntools;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;

import org.junit.runner.RunWith;


/**
 * Created by zhangjian on 2018/1/9.

**/

@RunWith( AndroidJUnit4.class)
public class fktest {
    UiObject2 mDevice;
    @Override
    public boolean equals(Object obj) {

        UiObject2 fangke=mDevice.findObject(By.res("android.widget.LinearLayout","com.ibotn.ibotnphone:id/ll_visitor"));
        fangke.click();
        return false ;
    }

    public void setup(){
             //   mDevice.
            }
}
