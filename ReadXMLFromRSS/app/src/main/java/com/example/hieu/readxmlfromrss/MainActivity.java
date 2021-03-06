package com.example.hieu.readxmlfromrss;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    EditText edtNoiDung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNoiDung = (EditText) findViewById(R.id.edtNoiDung);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadXML().execute("http://vnexpress.net/rss/thoi-su.rss");
            }
        });
    }

    class ReadXML extends AsyncTask<String, Integer, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            return getXMLFromURL(params[0]);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
        }

        @Override
        protected void onPostExecute(String s) {
            String result = "";
            XMLDOMParser xmlDom = new XMLDOMParser();
            Document doc = xmlDom.getDocument(s);
            NodeList node = doc.getElementsByTagName("item");
            for (int i = 0; i < node.getLength(); i++){
                Element element =(Element) node.item(i);
                result += "Title: ";
                result += xmlDom.getValue(element, "title");
                result += "\n";
            }
            edtNoiDung.setText(result);
            Toast.makeText(MainActivity.this, "Donwe.", Toast.LENGTH_SHORT);
        }
    }

    private static String getXMLFromURL(String theUrl)
    {
        StringBuilder content = new StringBuilder();

        try
        {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }
}
