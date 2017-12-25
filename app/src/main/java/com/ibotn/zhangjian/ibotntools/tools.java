package com.ibotn.zhangjian.ibotntools;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class tools extends AppCompatActivity{

    private static final String TAG = "intent";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        Button camerarecordbutton = (Button) findViewById(R.id.stratcamerarecording);
        camerarecordbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=0;
                   Intent intent = new Intent(tools.this,camera.class);
                    intent.putExtra("function_type","start_video_recording");
                    intent.addFlags(i);
                    startActivity(intent);
            }


        });
    }

}
