package com.ibotn.zhangjian.ibotntools;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class tools extends AppCompatActivity {
    private static final String TAG = "intent";
    int i = 0;
    private boolean isStart = false;
    private int count = 0;

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

    @Override
    protected void onResume() {
        super.onResume();
        if (isStart && count < 10000) {
            onRecordVideo(tools.this);
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
       /*         int i=0;
                   Intent intent = new Intent(tools.this,camera.class);
                    intent.putExtra("function_type","start_video_recording");
                    intent.addFlags(i);
                    startActivity(intent);*/

                /*for (; i < 10000; i++) {
                    onRecordVideo(tools.this);
                    Toast.makeText(tools.this," you  are recording for "+i+"times",Toast.LENGTH_LONG).toString();
                    Log.i(tools.class.getSimpleName()," i:"+i);
                }*/
                onRecordVideo(tools.this);
                count = 1;
                isStart = true;
            }

        });
        Button camerastoprecordbutton = findViewById(R.id.stopcamerarecording);
        camerastoprecordbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* int j=0;
                Intent intent=new Intent(tools.this,camera.class);
                intent.putExtra("funchtion_type","stop_video_recording");
                intent.addFlags(j);
                startActivity(intent);*/
                onStopRecord(tools.this);
            }
        });
        TextView textView = findViewById(R.id.mTextView);
        textView.setText("test for " + count + "times");
    }
}



