package com.ibotn.zhangjian.ibotntools;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ToolsActivity extends AppCompatActivity {
    private static final String TAG = "intent";
    int i = 0;
    private boolean isStart = false;
    private int count = 0;
    private String oldPath = "/storage/uhost/update.zip";
    private String newPath = "/storage/sd-ext/update.zip";

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
    protected void onResume() {
        super.onResume();

        if (isStart && count < 10000) {
            onRecordVideo(ToolsActivity.this);
            count++;
            Log.i(TAG, " count:" + count);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        Button camerarecordbutton = findViewById(R.id.stratcamerarecording);
        camerarecordbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecordVideo(ToolsActivity.this);
                count = 1;
                isStart = true;
            }

        });
        Button camerastoprecordbutton = findViewById(R.id.stopcamerarecording);
        camerastoprecordbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onStopRecord(ToolsActivity.this);
            }
        });

        Button otaupdate = findViewById(R.id.otaupdte);
        otaupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                copyFiles(oldPath, newPath);
                count = 1;
                isStart = true;
            }

        });
    }

    public void copyFiles(String oldPath, String newPath) {

        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { //文件存在时
                InputStream inStream = new FileInputStream(oldPath); //读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                int length;
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
                    Log.d(TAG, "copyFiles: 1");
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            Log.d(TAG, "copyFiles: error");
            Log.d(TAG, "copyFiles: error");
            Log.d(TAG, "copyFiles: error");
            Log.d(TAG, "copyFiles: error");
            e.printStackTrace();

        }

    }

}



