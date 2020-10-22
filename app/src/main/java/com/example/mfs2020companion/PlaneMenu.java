package com.example.mfs2020companion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PlaneMenu extends AppCompatActivity {

    private RecyclerView planesRecyclerView;
    private List<Object> viewItems = new ArrayList<>();

    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    protected void onCreate(Bundle savedInstanceState) {

        //normal on create layout loading
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plane_menu);

        planesRecyclerView = (RecyclerView) findViewById(R.id.planesRecyclerView);

        planesRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        planesRecyclerView.setLayoutManager(layoutManager);

        myAdapter = new MyPlaneMenuAdapter(this, viewItems);
        planesRecyclerView.setAdapter(myAdapter);

        addItemsFromJSON();

    }

    private void addItemsFromJSON() {
        try{

            String jsonDataString = readJSONDataFromFile();
            JSONArray jsonArray = new JSONArray(jsonDataString);

            for (int i = 0; i<jsonArray.length(); i++) {

                JSONObject itemObj = jsonArray.getJSONObject(i);

                String name = itemObj.getString("name");
                int cruiseSpeed = itemObj.getInt("cruiseSpeed");
                int maxAltitude = itemObj.getInt("maxAltitude");
                int range = itemObj.getInt("range");
                String imagePath = itemObj.getString("imagePath");

                Plane plane = new Plane(name, cruiseSpeed, maxAltitude, range, imagePath);
                viewItems.add(plane);
            }
        } catch (Exception e) {

        }

    }

    private String readJSONDataFromFile() throws IOException {

        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try {

            String jsonString = null;
            inputStream = getResources().openRawResource(R.raw.airplanes);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader( inputStream, "UTF-8")
            );

            while((jsonString = bufferedReader.readLine()) != null) {
                builder.append(jsonString);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return new String(builder);
    }

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, PlaneMenu.class);
        return intent;
    }
}
