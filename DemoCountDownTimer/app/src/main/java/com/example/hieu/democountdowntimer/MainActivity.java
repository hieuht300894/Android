package com.example.hieu.democountdowntimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtMsg;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        event();
    }

    private void event() {
        CountDownTimer countDownTimer = new CountDownTimer(10000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                i++;
                txtMsg.setText(String.valueOf(i));
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Timeout", Toast.LENGTH_SHORT).show();
            }
        };
        countDownTimer.start();
    }

    private void init() {
        txtMsg = (TextView)findViewById(R.id.txtMsg);
    }
}
