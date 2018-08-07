package com.ibotn.zhangjian.ibotntools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

/**
 * Created by zhangjian on 2018/4/13.
 */

public class videoplaytest extends AppCompatActivity {
    int i = 0;
    private String TAG = "videoplaytest";
    private Context mContext;

    public void playVideoWeb(final String url) {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Uri uri = Uri.parse(url);  //fromFile
        intent.setDataAndType(uri, "video/*");
        mContext.startActivity(intent);
        i++;
        Log.i("videoplaytest", " i :" + i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        playVideoWeb("http://dodovideo.rsvptech.cn/rsvpvideo/qbgs/36.qmj.mp4");

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        mContext = this;
        final Button videoweb = findViewById(R.id.videoweb);
        playVideoWeb("http://dodovideo.rsvptech.cn/rsvpvideo/qbgs/36.qmj.mp4");
    }
}
