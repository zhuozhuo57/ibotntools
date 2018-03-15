package com.ibotn.zhangjian.ibotntools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

import static java.lang.Thread.sleep;

/**
 * Created by zhangjian on 2017/12/14.
 */

public class camera extends Activity {

    private static final String TAG = "onCreate";

    /**
     * 5、创建目录
     */
    public static void createPath(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    /**
     * 语音【开始录像】时调用
     *
     * @param context
     */
    public static void onRecordVideo(Context context) {
        //Log.w(TAG, ">>>>>> onRecordVideo(true)");
        //Log.d(TAG, "onRecordVideo: aaaaa");
        //ExpressionAnimationService.setState(ExpressionAnimationService.EXPRESSION_LAUNCHER_PAUSE);

        //Toast.makeText(context, ">>>>>> onRecordVideo()", Toast.LENGTH_SHORT).show();
        //ToastUtil.show(context, "onRecordVideo", Toast.LENGTH_SHORT);
        Intent i = new Intent("com.ibotn.ibotncamera.ACTION_CAMERA_OPERATION");
        i.putExtra("function_type", "start_video_recording");
        i.putExtra("with_audio", true);
        //intent.putExtra("key","value");
        i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        context.sendBroadcast(i);
        Toast.makeText(context, "starting onRecordVideo", Toast.LENGTH_LONG).toString();

    }

    public static void onStopRecord(Context context) {
        //Log.w(TAG, ">>>>>> onStopRecord()");
        //Toast.makeText(context, ">>>>>> onStopRecord()", Toast.LENGTH_SHORT).show();
        //ToastUtil.show(context, "onStopRecord", Toast.LENGTH_SHORT);
        Intent i = new Intent("com.ibotn.ibotncamera.ACTION_CAMERA_OPERATION");
        i.putExtra("function_type", "stop_video_recording");
        context.sendBroadcast(i);
        Toast.makeText(context, "starting onStopRecord", Toast.LENGTH_LONG).toString();
    }


/*
           */
/* final Button camerarecordbutton = (Button) findViewById(R.id.stratcamerarecording);
            camerarecordbutton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {*//*


                    //取得从上一个Activity当中传递过来的Intent对象
                    Intent intent = getIntent();
                    //从Intent当中根据key取得value
         */
/*           if (intent != null) {
                        //String value = intent.getStringExtra("function_type");
                        // i.putExtra("function_type", "start_video_recording");

                    }
                    *//*



                }
            });
        }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        int i;
        for (i = 0; i < 1000; i++) {
            onRecordVideo(camera.this);
            try {
                sleep(15000);
            } catch (InterruptedException e) {
                //  deleteFile(filePath);
            }
            Log.d(TAG, "onCreate: " + i + "times");
        }

    }

    /**
     * 删除单个文件
     *
     * @param filePath 被删除文件的文件名
     * @return 文件删除成功返回true，否则返回false
     */
    public boolean deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }

    /**
     * @author yangxiaolong
     * @2014-7-28
     */
    /*public class SyncRunnable implements Runnable {

        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName()
                            + "   synchronizedloop " + i);

                }

            }

        }
    }*/
}
