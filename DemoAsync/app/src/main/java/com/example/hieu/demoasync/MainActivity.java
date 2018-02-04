package com.example.hieu.demoasync;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    ImageView imgAnh;
    ProgressBar progPercent;
    TextView txtPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        event();
    }

    private void init() {
        imgAnh = (ImageView)findViewById(R.id.imgAnh);
        progPercent = (ProgressBar)findViewById(R.id.progBarPercent);
        txtPercent = (TextView)findViewById(R.id.txtPercent);

    }

    private void event() {
        imgAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadImage();
            }
        });
    }

    private void LoadImage() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new LoadImageInternet().execute("http://i1033.photobucket.com/albums/a414/hieu_hoang1/k20d-image_zps6xjczfv0.jpg");
            }
        });
    }

    private class LoadImageInternet extends AsyncTask<String, Integer, String>{

        Bitmap bmp;

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                URLConnection conection = url.openConnection();
                conection.connect();

                // this will be useful so that you can show a tipical 0-100% progress bar
                int lenghtOfFile = conection.getContentLength();

                // Download the file
                BufferedInputStream bis = new BufferedInputStream(url.openStream(), 1024 * 8);
                ByteArrayOutputStream baos = new ByteArrayOutputStream ();

                int len = 0;
                long total = 0;
                byte[] buffer = new byte[1024];

                while((len = bis.read(buffer)) != -1){
                    total += len;
                    baos.write(buffer, 0, len);
                    byte[] data = baos.toByteArray();
                    bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
                    publishProgress((int)(total*100/lenghtOfFile));
                }
                baos.close();
                bis.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            imgAnh.setImageBitmap(bmp);
            Toast.makeText(MainActivity.this, "Load Done", Toast.LENGTH_SHORT).show();
/*            txtPercent.setText("Process: 100%");
            progPercent.setProgress(100);*/
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int value = values[0];
            //imgAnh.setImageBitmap(bmp);
            String msg = "";
            if (bmp != null){
                msg = "Process: ";
            }
            txtPercent.setText(msg + String.valueOf(value)+"%");
            progPercent.setProgress(value);
        }
    }
}
