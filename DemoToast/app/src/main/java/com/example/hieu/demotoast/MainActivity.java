package com.example.hieu.demotoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            Truyền vào 3 tham số
            - Màn hình hiện tại
            - Nội dung hiển thị
            - Thời gian hiển thị
        */
        Toast toast = Toast.makeText(
                MainActivity.this,
                "Hello World !!!",
                Toast.LENGTH_SHORT
        );
        toast.show();
    }
}
