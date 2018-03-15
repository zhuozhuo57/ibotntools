package com.ibotn.zhangjian.ibotntools;

import android.app.Instrumentation;
import android.os.Looper;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.io.OutputStream;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static java.lang.Thread.sleep;

/**
 * Created by zhangjian on 2018/1/20.
 */

@RunWith(AndroidJUnit4.class)
public class amstartalltest {
    private static final String TAG = "IBOTN";
    UiDevice mDevice;
    Instrumentation instrumentation;
    private Process devicesid;

    @Before
    public void setUp() {

        instrumentation = getInstrumentation();
        mDevice = UiDevice.getInstance(instrumentation);
    }

    @Test
    public void testsss() throws UiObjectNotFoundException, IOException, InterruptedException {
        mDevice.pressHome();
        int i;
        for (i = 0; i <= 1000; i++) {
 /*Intent intent = new Intent();
        intent.setClassName("com.ibotn.ibotnface","com.ibotn.ibotnface.SplashActivity");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getTargetContext().startActivity(intent);
        sleep(3000);
        Intent intent1 = new Intent();
        intent1.setClassName("com.ibotn.ibotncamera","com.ibotn.ibotncamera.SceneLearnActivity");
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getTargetContext().startActivity(intent1);
        sleep(3000);
        Intent intent2 = new Intent();
        intent2.setClassName("com.ibotn.ibotnphone","com.ibotn.ibotnphone.activity.FunSelectionActivity");
        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getTargetContext().startActivity(intent2);
        sleep(3000);*/
            //execShell("sh");


            Process process = Runtime.getRuntime().exec("su");
            OutputStream os = process.getOutputStream();
            Log.d(TAG, "iiiiiiiiiiiiiiiiii");
            Log.d(TAG, "is Main :" + (Looper.getMainLooper() == Looper.myLooper()));
            exceCmd("am start -n com.ibotn.ibotnface/.HomeActivity");
            sleep(3000);
            Log.d(TAG, "HomeActivity ok");
            exceCmd("am start -n com.ibotn.ibotncamera/.SceneLearnActivity");
            sleep(3000);
            Log.d(TAG, "SceneLearnActivity ok");
            exceCmd("am start -n com.ibotn.ibotncamera/com.ibotn.ibotncamera.TrackingActivity");
            Log.d(TAG, "MainActivity ok");
            sleep(3000);
            //Log.d(TAG, "com.ibotn.ibotnface/.HomeActivity: "+i);
 /*sleep(3000);*/
//        os.write("am start -n com.ibotn.ibotncamera/.SceneLearnActivity".getBytes());
            //Log.d(TAG, "com.ibotn.ibotncamera/.SceneLearnActivity"+i);
            /// sleep(3000);
//        os.write("am start -n com.ibotn.ibotnphone/.MainActivity".getBytes());

            //Log.d(TAG, "com.ibotn.ibotnphone/.MainActivity: "+i);

            Log.d(TAG, "sh ok");
            Log.d(TAG, "test: " + i);

//    }

        }
    }

    private void exceCmd(String str) throws IOException {
        Process process = Runtime.getRuntime().exec("su");
        OutputStream os = process.getOutputStream();
        Log.d(TAG, "iiiiiiiiiiiiiiiiii");
        os.write(str.getBytes());
        os.flush();
        os.close();
    }
    /*public void execShell(String cmd){
        try{
            //权限设置
            process P = runtime.exec(new String[] { "cmd.exe","/C", "dir"});
            //Process p = Runtime.getRuntime().exec("sh");  //su为root用户,sh普通用户
            Process process =new Runtime().
           // Runtime.getRuntime().exec("su");

            //获取输出流
            OutputStream outputStream = p.getOutputStream();
            DataOutputStream dataOutputStream=new DataOutputStream(outputStream);
            //将命令写入
            dataOutputStream.writeBytes(cmd);
            //提交命令
            dataOutputStream.flush();
            //关闭流操作
            dataOutputStream.close();
            outputStream.close();
        }
        catch(Throwable t)
        {
            t.printStackTrace();
        }*/
}

