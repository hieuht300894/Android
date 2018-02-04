package com.example.hieu.dichuyenmanhinh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnNext;
    EditText edtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMsg = (EditText)findViewById(R.id.edtMsg);
        btnNext = (Button)findViewById(R.id.btnGoScreen);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Screen2Activity.class);
                intent.putExtra("msg", edtMsg.getText().toString());
                startActivity(intent);
            }
        });
    }
}
