package com.example.jr.lab_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1 , b2, b3, b4;
    Intent a1, a2, a3, a4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b1.setOnClickListener(new ButtonListener());
        b2.setOnClickListener(new ButtonListener());
        b3.setOnClickListener(new ButtonListener());
        b4.setOnClickListener(new ButtonListener());
    }
    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button:
                    a1 = new Intent(MainActivity.this, SimpleAdapterActivity.class);
                    startActivity(a1);
                    break;

                case R.id.button2:
                    a2 = new Intent(MainActivity.this, DialogActivity.class);
                    startActivity(a2);
                    break;

                case R.id.button3:
                    a3 = new Intent(MainActivity.this, XMLMenuActivity.class);
                    startActivity(a3);
                    break;
                case R.id.button4:
                    a4 = new Intent(MainActivity.this, ContextMenuActivity.class);
                    startActivity(a4);
                    break;
                default:
                    break;
            }
        }
    }
}

