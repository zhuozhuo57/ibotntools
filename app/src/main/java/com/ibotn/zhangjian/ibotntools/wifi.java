package com.ibotn.zhangjian.ibotntools;

import android.annotation.SuppressLint;
import android.app.admin.DevicePolicyManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class wifi extends AppCompatActivity {
    private  final  String TAG="WIFItest";
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        final Button wifi开关测试=(Button)findViewById(R.id.wifitest);
        wifi开关测试.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: onclickbutton wifi test");
                Toast.makeText(wifi.this,"您点击了wifi测试开关",Toast.LENGTH_LONG).toString();
                try {
                    Runtime.getRuntime().exec("am instrument -w -r   -e debug false -e class 'com.ibotn.zhangjian.ibotntools.wifitest' com.ibotn.zhangjian.ibotntools.test/android.support.test.runner.AndroidJUnitRunner");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                executeShellCommand();
            }

            private void executeShellCommand() {

            }
        });
    }
}