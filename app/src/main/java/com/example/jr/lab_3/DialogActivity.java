package com.example.jr.lab_3;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.alertdialog);
        // 创建对话框构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 获取布局
        View view2 = View.inflate(DialogActivity.this, R.layout.alertdialog, null);
        // 获取布局中的控件
        final EditText username = (EditText) view2.findViewById(R.id.username);
        final EditText password = (EditText) view2.findViewById(R.id.password);
        final Button btn_sign = (Button) view2.findViewById(R.id.btn_sign);
        final Button btn_cancel = (Button) view2.findViewById(R.id.btn_cancel);
        // 设置参数
        builder.setTitle("Android App").setIcon(R.drawable.ic_launcher_background)
                .setView(view2);
        // 创建对话框
        final AlertDialog alertDialog = builder.create();
        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString().trim();
                String psd = password.getText().toString().trim();
                //if (uname.equals("shenhua") && psd.equals("123456")) {
                    Toast.makeText(DialogActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
               // }
               // Toast.makeText(DialogActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();// 对话框消失
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();// 对话框消失
            }
        });
        alertDialog.show();
    }
}
