package com.ibotn.zhangjian.ibotntools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

import static java.lang.Thread.sleep;
public class camera extends Activity {
    private static final String TAG = "onCreate";
    public static void createPath(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
    }
    public static void onRecordVideo(Context context) {
        Intent i = new Intent("com.ibotn.ibotncamera.ACTION_CAMERA_OPERATION");
        i.putExtra("function_type", "start_video_recording");
        i.putExtra("with_audio", true);
        i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        context.sendBroadcast(i);
        Toast.makeText(context, "starting onRecordVideo", Toast.LENGTH_LONG).toString();
    }
    public static void onStopRecord(Context context) {
        Intent i = new Intent("com.ibotn.ibotncamera.ACTION_CAMERA_OPERATION");
        i.putExtra("function_type", "stop_video_recording");
        context.sendBroadcast(i);
        Toast.makeText(context, "starting onStopRecord", Toast.LENGTH_LONG).toString();
    }
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
            }
            Log.d(TAG, "onCreate: " + i + "times");
        }

    }
    public boolean deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }
}
