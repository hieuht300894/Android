package com.example.hieu.bienvaepkieudulieu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtCong, txtTru, txtNhan, txtChia;
    Button btnCong, btnTru, btnNhan, btnChia;
    EditText edtNum1, edtNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        event();
    }

    private void init(){
        txtCong=(TextView)findViewById(R.id.txtTong);
        txtTru=(TextView)findViewById(R.id.txtTru);
        txtNhan=(TextView)findViewById(R.id.txtNhan);
        txtChia=(TextView)findViewById(R.id.txtChia);

        btnCong=(Button)findViewById(R.id.btnCong);
        btnTru=(Button)findViewById(R.id.btnTru);
        btnNhan=(Button)findViewById(R.id.btnNhan);
        btnChia=(Button)findViewById(R.id.btnChia);

        edtNum1=(EditText) findViewById(R.id.edtNum1);
        edtNum2=(EditText)findViewById(R.id.edtNum2);
    }

    private void event(){
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cong();
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tru();
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nhan();
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chia();
            }
        });
    }

    private void cong(){
        Double a = 0.0, b = 0.0;
        try{
            a = Double.parseDouble(String.valueOf(edtNum1.getText()));
            b = Double.parseDouble(String.valueOf(edtNum2.getText()));
        }
        catch (Exception ex){

        }
        Double res = a + b;
        txtCong.setText("Tổng: " + res);
    }

    private void tru(){
        Double a = 0.0, b = 0.0;
        try{
            a = Double.parseDouble(String.valueOf(edtNum1.getText()));
            b = Double.parseDouble(String.valueOf(edtNum2.getText()));
        }
        catch (Exception ex){

        }
        Double res = a - b;
        txtTru.setText("Chia: " + res);
    }

    private void nhan(){
        Double a = 0.0, b = 0.0;
        try{
            a = Double.parseDouble(String.valueOf(edtNum1.getText()));
            b = Double.parseDouble(String.valueOf(edtNum2.getText()));
        }
        catch (Exception ex){

        }
        Double res = a * b;
        txtNhan.setText("Nhân: " + res);
    }

    private void chia(){
        Double a = 0.0, b = 1.0;
        try{
            a = Double.parseDouble(String.valueOf(edtNum1.getText()));
            b = Double.parseDouble(String.valueOf(edtNum2.getText()));
            if (b == 0)
                b = 1.0;
        }
        catch (Exception ex){

        }
        Double res = a / b;
        txtChia.setText("Chia: " + res);
    }
}
