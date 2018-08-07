package com.ibotn.zhangjian.ibotntools;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiWatcher;

import static java.lang.Thread.sleep;

/**
 * Created by zhangjian on 2018/1/23.
 */
public class uiautomatortest {
    public void testDemo2() throws UiObjectNotFoundException, InterruptedException {
        //1.先注册监听器(registerWatcher(String name,UiWatcher watcher))
        UiDevice.getInstance().registerWatcher("Phone", new UiWatcher() {
            public boolean checkForCondition() {
                //1.挂断电话
                UiObject call = new UiObject(new UiSelector().text("来电"));
                UiObject view = new UiObject(new UiSelector().className("android.view.View"));
                if (call.exists()) {
                    System.out.print("电话监听器被触发了");
                    try {
                        view.swipeLeft(20);
                        return true;
                    } catch (UiObjectNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        });
        //1.再注册一个监听器
        UiDevice.getInstance().registerWatcher("Massage", new UiWatcher() {
            public boolean checkForCondition() {
                System.out.print("短信监控被触发了");
                return false;
            }
        });
        //2.执行用例步骤
        //使用index+classNmae定位父类+text定位子类最终定位到对象[声音按钮]
        UiObject vol = new UiObject(new UiSelector()
                .className("android.widget.LinearLayout").index(6))
                .getChild(new UiSelector().text("声音"));
        //获取下一级界面的返回按钮
        UiObject Back = new UiObject(new UiSelector().description("声音：向上导航"));
//      //使用for循环监听器不会起作用
//      for(int i=0;i<10;i++){
//          //输出循环次数：
//          System.out.println("当前循环"+(i+1)+"次;");
//          //点击对象并等到新窗口出现
//          vol.clickAndWaitForNewWindow();
//          sleep(2000);
//          //点击返回按钮
//          Back.clickAndWaitForNewWindow();
//          sleep(2000);
//      }
        //可以在下面五次操作过程中打入电话进行调试
        //第一次点击对象并等到新窗口出现
        vol.clickAndWaitForNewWindow();
        sleep(2000);
        //点击返回按钮
        Back.clickAndWaitForNewWindow();
        sleep(2000);
        //第二次
        vol.clickAndWaitForNewWindow();
        sleep(2000);
        Back.clickAndWaitForNewWindow();
        sleep(2000);
        //第三次
        vol.clickAndWaitForNewWindow();
        sleep(2000);
        Back.clickAndWaitForNewWindow();
        sleep(2000);
        //第四次
        vol.clickAndWaitForNewWindow();
        sleep(2000);
        Back.clickAndWaitForNewWindow();
        sleep(2000);
        //第五次
        vol.clickAndWaitForNewWindow();
        sleep(2000);
        Back.clickAndWaitForNewWindow();
        sleep(2000);
        //在第五次返回后关闭指定监听器(removeWatcher(String name))这样以后就不会被触发了
        UiDevice.getInstance().removeWatcher("Phone");
        //然后再强制运行所有监控器
        UiDevice.getInstance().runWatchers();
        //第六次
        vol.clickAndWaitForNewWindow();
        sleep(2000);
        Back.clickAndWaitForNewWindow();
        sleep(2000);
        //在第五次返回后检查并输出监听器是否被触发过
        //检查是否有监听器被触发过
        boolean B = UiDevice.getInstance().hasAnyWatcherTriggered();
        //检测是否有特定监听器被触发过
        boolean Phone1 = UiDevice.getInstance().hasWatcherTriggered("Phone");
        boolean Massage1 = UiDevice.getInstance().hasWatcherTriggered("Massage");
        System.out.println("是否有监听器被触发过" + B);
        System.out.println("电话监听器是否被触发过" + Phone1);
        System.out.println("短信监听器是否被触发过" + Massage1);
        //逻辑判断然后进行重置和强制运行操作
        if (B == true) {
            //重置被运行过的监听器
            UiDevice.getInstance().resetWatcherTriggers();
        }
    }

}
