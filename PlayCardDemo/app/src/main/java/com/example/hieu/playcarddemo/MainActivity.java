package com.example.hieu.playcarddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView img1, img2, img3, imgOpen;
    TextView  txtImgName1, txtImgName2, txtImgName3;
    Integer count = 0;
    int imgDefault = R.drawable.question_mark_xxl;
    Integer[] images = new Integer[]{
            R.drawable.c2_1, R.drawable.c2_2, R.drawable.c2_3, R.drawable.c2_4,
            R.drawable.c3_1, R.drawable.c3_2, R.drawable.c3_3, R.drawable.c3_4,
            R.drawable.c4_1, R.drawable.c4_2, R.drawable.c4_3, R.drawable.c4_4,
            R.drawable.c5_1, R.drawable.c5_2, R.drawable.c5_3, R.drawable.c5_4,
            R.drawable.c6_1, R.drawable.c6_2, R.drawable.c6_3, R.drawable.c6_4,
            R.drawable.c7_1, R.drawable.c7_2, R.drawable.c7_3, R.drawable.c7_4,
            R.drawable.c8_1, R.drawable.c8_2, R.drawable.c8_3, R.drawable.c8_4,
            R.drawable.c9_1, R.drawable.c9_2, R.drawable.c9_3, R.drawable.c9_4,
            R.drawable.c10_1, R.drawable.c10_2, R.drawable.c10_3, R.drawable.c10_4,
            R.drawable.cj_1, R.drawable.cj_2, R.drawable.cj_3, R.drawable.cj_4,
            R.drawable.cq_1, R.drawable.cq_2, R.drawable.cq_3, R.drawable.cq_4,
            R.drawable.ck_1, R.drawable.ck_2, R.drawable.ck_3, R.drawable.ck_4,
            R.drawable.ca_1, R.drawable.ca_2, R.drawable.ca_3, R.drawable.ca_4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        event();
    }

    private void init(){
        img1 = (ImageView)findViewById(R.id.img1);
        img2 = (ImageView)findViewById(R.id.img2);
        img3 = (ImageView)findViewById(R.id.img3);
        imgOpen = (ImageView)findViewById(R.id.imgOpen);
        txtImgName1 = (TextView)findViewById(R.id.txtImgName1);
        txtImgName2 = (TextView)findViewById(R.id.txtImgName2);
        txtImgName3 = (TextView)findViewById(R.id.txtImgName3);

        randomCard();
    }

    private void event(){
        imgOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCard();
            }
        });
    }

    private void openCard() {
        if (count >= 0 && count <= 2) {
            if (count == 0) {
                img1.setImageResource(images[0]);
                txtImgName1.setText(getNameCard(getFileName(String.valueOf(getResources().getText(images[count])))));
            }
            else if (count == 1) {
                img2.setImageResource(images[1]);
                txtImgName2.setText(getNameCard(getFileName(String.valueOf(getResources().getText(images[count])))));
            }
            else if (count == 2) {
                img3.setImageResource(images[2]);
                txtImgName3.setText(getNameCard(getFileName(String.valueOf(getResources().getText(images[count])))));
            }
            count++;
        }
        else{
            img1.setImageResource(imgDefault);
            img2.setImageResource(imgDefault);
            img3.setImageResource(imgDefault);
            txtImgName1.setText("");
            txtImgName2.setText("");
            txtImgName3.setText("");
            count = 0;
            randomCard();
        }
    }

    private void randomCard(){
        int nLoop = 100;
        for (int i=0; i<nLoop; i++){
            Random ran = new Random();
            int x = ran.nextInt(images.length);
            int y = ran.nextInt(images.length);
            Integer temp = images[x];
            images[x] = images[y];
            images[y] = temp;
        }
    }

    private String getFileName(String filePath){
        File f = new File(filePath);
        String fileName = f.getName();
        int index = fileName.indexOf('.');
        return fileName.substring(0, index);
    }

    private String getNameCard(String str){
        int index = str.indexOf('_');
        String name = str.substring(1, index);
        String nameCard = "";
        switch (name){
            case "2":
                nameCard = "Heo";
                break;
            case "j":
                nameCard = "Bồi";
                break;
            case "q":
                nameCard = "Đầm";
                break;
            case "k":
                nameCard = "Già";
                break;
            case "a":
                nameCard = "Xì";
                break;
            default:
                nameCard = name;
        }
        Integer propCard = Integer.parseInt(str.substring(index + 1));
        String nPropCard = "";
        switch (propCard){
            case 1:
                nPropCard = "Bích";
                break;
            case 2:
                nPropCard = "Chuồn";
                break;
            case 3:
                nPropCard = "Rô";
                break;
            case 4:
                nPropCard = "Cơ";
                break;
        }
        Toast.makeText(MainActivity.this, nameCard + " " + nPropCard, Toast.LENGTH_SHORT).show();
        return nameCard + " " + nPropCard;
    }
}
