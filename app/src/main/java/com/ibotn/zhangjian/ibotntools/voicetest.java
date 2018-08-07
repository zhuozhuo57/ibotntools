package com.ibotn.zhangjian.ibotntools;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjian on 2018/5/16.
 */

public class voicetest extends AppCompatActivity {


    private static final String TAG = "voicetesttag";

    /**
     * 递归读取某个目录下的所有文件
     *
     * @author 超越
     * @Date 2016年12月5日, 下午4:04:59
     * @motto 人在一起叫聚会，心在一起叫团队
     * @Version 1.0
     */
    public class ReadFile {
        private void test(String fileDir) {
            List<File> fileList = new ArrayList<File>();
            File file = new File(fileDir);
            File[] files = file.listFiles();// 获取目录下的所有文件或文件夹
            if (files == null) {// 如果目录为空，直接退出
                return;
            }
            // 遍历，目录下的所有文件
            for (File f : files) {
                if (f.isFile()) {
                    fileList.add(f);
                } else if (f.isDirectory()) {
                    Log.d(TAG, "voicetesttag: " + f.getAbsolutePath());
                    test(f.getAbsolutePath());
                }
            }
            for (File f1 : fileList) {
                Log.d(TAG, "voicetesttag: " + f1.getName());
            }
        }

        public void main(String[] args) {
            test("\\sdcard\\");
        }
    }

}


