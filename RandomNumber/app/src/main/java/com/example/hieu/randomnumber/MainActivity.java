package com.example.hieu.randomnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnClick;
    TextView txtNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        event();
    }

    private void init(){
        btnClick = (Button)findViewById(R.id.btnGetNumber);
        txtNumber = (TextView)findViewById(R.id.txtNumber);
    }

    private void event(){
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random ran = new Random();
                int num = ran.nextInt(100);
                txtNumber.setText("Kết quả: " + String.valueOf(num));
            }
        });
    }
}
