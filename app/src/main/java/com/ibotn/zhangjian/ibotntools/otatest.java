package com.ibotn.zhangjian.ibotntools;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class otatest extends AppCompatActivity {
    private static final String TAG = "intent";
    int i = 0;
    private boolean isStart = false;
    private int count = 0;
    private String path;
    private String tagpath;
    private String oldPath = "/storage/uhost/update.zip";
    private String newPath = "/storage/sd-ext/update.zip";


    /*
    public static void copyfile() throws IOException {
        File path = new File("/storage/uhost/update.zip");

        File tagpath = new File("/storage/sd-ext/update.zip");

             Runtime.getRuntime().exec("copy" + path + tagpath);

        Log.d(TAG, "copyfile: copy  ok");
        if(path.length()==tagpath.length())
           {
                Runtime.getRuntime().exec("reboot recovery");
            }

        }

    */
    public void copyFile(String oldPath, String newPath) {

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
                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            Log.d(TAG, "copyFile: failed");
            e.printStackTrace();

        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (isStart && count < 10000) {
            //onRecordVideo(otatest.this);

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
                // onRecordVideo(otatest.this);
                copyFile(oldPath, newPath);
                count = 1;
                isStart = true;
            }

        });
        Button camerastoprecordbutton = findViewById(R.id.stopcamerarecording);
        camerastoprecordbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //onStopRecord(otatest.this);
            }
        });
    }

}



