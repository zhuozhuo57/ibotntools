package com.ibotn.zhangjian.ibotntools;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.os.Bundle;
import android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
*
 * Created by zhangjian on 2017/12/18.

*/


public class storagetest extends Activity{


    private static final String TAG ="storagetest" ;
   // private static final filePath="/mnt/sdcard/test/";
    String filePath;
    File sourcefile;
    File targetFile;
@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.storyage_tool);
    Button read_wirth_btn =findViewById(R.id.storage);
    read_wirth_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(storagetest.this, "这是你第次点击了存储测试按钮", Toast.LENGTH_LONG).toString();
            int i;
            for(i=0;i<100;i++){

                Log.d(TAG, "storagetest: "+i+"times");
                filePath="mnt/sdcard/test/";
                File sourcefile=new File(filePath+"sourcefile");
                File targetFile=new File(filePath+"targetFile");

                copyFile(sourcefile,targetFile);
                deleteDirectory(filePath);
                Toast.makeText(storagetest.this, "这是你第"+i+"次点击了存储测试按钮", Toast.LENGTH_LONG).toString();
            }
        }
    });


    }


/*
*
 * 删除文件夹以及目录下的文件
 * @param   filePath 被删除目录的文件路径
 * @return  目录删除成功返回true，否则返回false

*/

    public boolean deleteDirectory(String filePath) {
        boolean flag = false;
        //如果filePath不以文件分隔符结尾，自动添加文件分隔符
        if (!filePath.endsWith(File.separator)) {
            filePath = filePath + File.separator;
        }
        File dirFile = new File(filePath);
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        flag = true;
        File[] files = dirFile.listFiles();
        //遍历删除文件夹下的所有文件(包括子目录)
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                //删除子文件
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag) break;
            } else {
                //删除子目录
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag) break;
            }
        }
        if (!flag) return false;
        //删除当前空目录
        return dirFile.delete();
    }

/*
*
 *  根据路径删除指定的目录或文件，无论存在与否
 *@param filePath  要删除的目录或文件
 *@return 删除成功返回 true，否则返回 false。

*/

    public boolean DeleteFolder(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return false;
        } else {
            if (file.isFile()) {
                // 为文件时调用删除文件方法
                return deleteFile(filePath);
            } else {
                // 为目录时调用删除目录方法
                return deleteDirectory(filePath);
            }
        }
    }
    public void copyFile(File sourcefile, File targetFile) {
        FileInputStream input = null;
        BufferedInputStream inbuff = null;
        FileOutputStream out = null;
        BufferedOutputStream outbuff = null;

        try {

            input = new FileInputStream(sourcefile);
            inbuff = new BufferedInputStream(input);

            out = new FileOutputStream(targetFile);
            outbuff = new BufferedOutputStream(out);

            byte[] b = new byte[1024 * 5];
            int len = 0;
            while ((len = inbuff.read(b)) != -1) {
                outbuff.write(b, 0, len);
            }

            outbuff.flush();
        } catch (Exception ex) {

        } finally {
            try {

                if (inbuff != null)
                    inbuff.close();
                if (outbuff != null)
                    outbuff.close();
                if (out != null)
                    out.close();
                if (input != null)
                    input.close();
            } catch (Exception ex) {

            }
        }
    }

    public boolean copyLast6Files(String srcDir, String dstDir) {

        // (new File(dstDir)).mkdir();
        Log.v(TAG, "" + dstDir.toString());

        File[] files = (new File(srcDir)).listFiles();
        List<File> listFiles = Arrays.asList(files);
        Collections.sort(listFiles, new Comparator<File>() {
            public final int compare(File aa, File ab) {
                long sa = aa.lastModified();
                long sb = ab.lastModified();
                Log.v(TAG, "copyLast6Files success 1");
                return (sa > sb) ? -1 : ((sa == sb) ? 0 : 1);
            }
        });

        if (files.length <= 0)
            Log.v(TAG, "dump failure qiu");

        if (files.length >= 6) {
            (new File(dstDir)).mkdir();

            for (int i = 0; i < 6; ++i) {
                File temp = listFiles.get(i);
                copyFile(temp, new File(dstDir + temp.getName()));
            }
            Log.v(TAG, "copyLast6Files success 2");
            return true;
        } else {
            Log.v(TAG, "copyLast6Files failure 2");
            return false;
        }
        //return false;

    }
    public void  file_copy(){
    }

    public void file_delete(){


    }









}
