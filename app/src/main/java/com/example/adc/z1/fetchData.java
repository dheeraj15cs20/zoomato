package com.example.adc.z1;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by adc on 27-Jun-18.
 */

public class fetchData extends AsyncTask<Void,Void,Void> {
    String data="";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url= new URL("https://developers.zomato.com/api/v2.1/collections?city_id=280");

            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            InputStream inputStream= httpURLConnection.getInputStream();
            BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while (line != null){
                line=bufferedReader.readLine();
                data=data = line;
            }
            JSONArray JA= new JSONArray(data);
            for (int i=0; i<JA.length(); i++){
                JSONObject JO= (JSONObject) JA.get(i);

            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.data.setText(this.data);
    }
}
