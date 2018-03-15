package com.ibotn.zhangjian.ibotntools;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by zhangjian on 2018/1/5.
 */

public class edittext extends Activity implements View.OnClickListener {

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittextview);

        editText = findViewById(R.id.EditTexwForTest);
        button = findViewById(R.id.EditTexwForTestButton);
        button.setOnClickListener(this);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.EditTexwForTestButton:
                String inputtext = editText.getText().toString();
                Toast.makeText(edittext.this, inputtext, Toast.LENGTH_LONG).toString();
                break;
            default:
                break;
        }

    }
}
