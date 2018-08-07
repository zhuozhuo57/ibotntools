package com.ibotn.zhangjian.ibotntools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by zhangjian on 2018/3/23.
 */

// 继承BroadcastReceivre基类
public class mBroadcastReceiver extends BroadcastReceiver {
    public static final String IBOTNBROADCAST = "ibotnbroadcast";

    // 复写onReceive()方法
    // 接收到广播后，则自动调用该方法
    @Override
    public void onReceive(Context context, Intent intent) {
        //写入接收广播后的操作
        // 1. 实例化BroadcastReceiver子类 &  IntentFilter
        mBroadcastReceiver mBroadcastReceiver = new mBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();

        // 2. 设置接收广播的类型
        intentFilter.addAction(IBOTNBROADCAST);


        // 3. 动态注册：调用Context的registerReceiver（）方法
        //registerReceiver(mBroadcastReceiver, intentFilter);
    }
    // 注册广播后，要在相应位置记得销毁广播
// 即在onPause() 中unregisterReceiver(mBroadcastReceiver)
// 当此Activity实例化时，会动态将MyBroadcastReceiver注册到系统中
// 当此Activity销毁时，动态注册的MyBroadcastReceiver将不再接收到相应的广播。


}


