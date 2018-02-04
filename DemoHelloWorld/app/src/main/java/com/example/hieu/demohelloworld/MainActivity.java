package com.example.hieu.demohelloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtMsg;
    Button btnClick;
    boolean chkClick = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ánh xạ
        init();
        //Tạo sự kiện
        event();
    }

    private  void init(){
        txtMsg=(TextView)findViewById(R.id.txtMsg);
        btnClick=(Button)findViewById(R.id.btnClick);
    }

    private void event(){
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMsg.setText(chkClick?"Click me to show secret message !!!":"Hello World !!!");
                chkClick=!chkClick;
            }
        });
    }
}
