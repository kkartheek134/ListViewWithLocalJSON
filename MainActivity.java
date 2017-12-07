package com.android.gemini.localjsonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<MyPlaces> place;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);


        try {
            JSONObject jsonObject = new JSONObject(loadJSONFromAsset());
            JSONArray jsonArray = jsonObject.getJSONArray("places");
            place = new ArrayList<>(jsonArray.length());

            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                String name = jsonObject1.getString("name");
                double Latitude = jsonObject1.getDouble("Latitude");
                double Longitude = jsonObject1.getDouble("Longitude");

                Log.e("abc:",""+name+"\n"+Latitude+"\n"+Longitude);

                MyPlaces myPlaces = new MyPlaces(name,Latitude,Longitude);
                myPlaces.setName(name);
                myPlaces.setLatitude(Latitude);
                myPlaces.setLongitude(Longitude);

                place.add(myPlaces);

                Log.e("List:",""+place.get(i).toString());

                CustomAdapter adapter = new CustomAdapter(this,place);
                listView.setAdapter(adapter);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public String loadJSONFromAsset() {

        String json = null;
        try {
            InputStream is = getApplicationContext().getAssets().open("places.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return  null;

        }

        return json;

    }


    }



