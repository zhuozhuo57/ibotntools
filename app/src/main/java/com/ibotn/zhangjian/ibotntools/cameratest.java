package com.ibotn.zhangjian.ibotntools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static java.lang.Thread.sleep;

/**
 * Created by zhangjian on 2017/12/15.
 */

public class cameratest extends Activity {
    private static final String CAMERATEST_TAG = "start_video_recording";

    public static void onRecordVideo(Context context) {
        Intent i = new Intent("com.ibotn.ibotncamera.ACTION_CAMERA_OPERATION");
        i.putExtra("function_type", "start_video_recording");
        i.putExtra("with_audio", true);
        i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        Toast.makeText(context, "starting onRecordVideo", Toast.LENGTH_LONG).toString();
    }

    public static void onStopRecord(Context context) {
        Intent i = new Intent("com.ibotn.ibotncamera.ACTION_CAMERA_OPERATION");
        i.putExtra("function_type", "stop_video_recording");
        context.sendBroadcast(i);
        Toast.makeText(context, "starting onStopRecord", Toast.LENGTH_LONG).toString();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        //setContentView(R.layout.activity_tools);
        final Button camerarecordbutton = findViewById(R.id.stratcamerarecording);
        camerarecordbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int j;
                //for (j = 0; j < 1000; j++) {
              /*          Intent intent = new Intent();
                        intent.putExtra("function_type", "start_video_recording");
                        startActivity(intent);
                        try {
                            sleep(15000);
                        } catch (InterruptedException e) {
                           // break;
                        }
                        intent.putExtra("function_type", "stop_video_recording");
                        startActivity(intent);
                        Log.d(CAMERATEST_TAG, "start_video_recording: " + j + "times");*/
                onRecordVideo(cameratest.this);
                //Log.d(CAMERATEST_TAG, "start_video_recording: " + j + "times");
                try {
                    sleep(15000);
                    //  break;
                } catch (InterruptedException e) {
                    //return;
                }
                onStopRecord(cameratest.this);
            }
            //  }
            // }
        });
    }

}