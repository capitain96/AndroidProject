package com.example.mfs2020companion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MainMenu extends AppCompatActivity implements MyAdapter.OnMenuItemListener{
    RecyclerView menuItemsList;
    String s1[], s2[];
    int images[] = {R.drawable.airport,
            R.drawable.airplane,
            R.drawable.airplanefinder,
            R.drawable.notebook,
            R.drawable.weather,
            R.drawable.vatsim,
            R.drawable.patchnotes};

    private FusedLocationProviderClient locationclient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        menuItemsList = findViewById(R.id.MenuItemsList);

        s1 = getResources().getStringArray(R.array.menu_items);
        s2 = getResources().getStringArray(R.array.menu_descriptions);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images, this);
        menuItemsList.setAdapter(myAdapter);
        menuItemsList.setLayoutManager((new LinearLayoutManager(this)));
    }

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, MainMenu.class);
        //intent.putExtra(LOGIN_EMAIL_KEY, fromEmail);
        return intent;
    }

    @Override
    public void onMenuItemClick(int position) {

        switch(position) {
            case 0://airports
                startAirportMenu();

                break;

            case 1://airplanes
                startPlaneMenu();

                break;

            case 2://airplane finder

                break;

            case 3://notebook

                break;

            case 4://weather data
                requestPermission();
                openWeatherUrl();
                break;

            case 5: //vatsim
                startVatsim();

                break;

            case 6: //changelog
                openChangelogUrl();
                break;

        }

    }

    private void openChangelogUrl() {
        final String WEBSITE_URL = "https://www.pcgames.de/Microsoft-Flight-Simulator-Spiel-15259/News/Termin-neues-Update-Patch-Notes-Aenderungen-1357087/"; //this is not the correct URL but the windows server is currently down
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(WEBSITE_URL));
        startActivity(intent);
    }

    private void openWeatherUrl() {


        Log.d("TAG", "openWeatherUrl: requested permission");

        locationclient = LocationServices.getFusedLocationProviderClient((this));

        if(ActivityCompat.checkSelfPermission(MainMenu.this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        locationclient.getLastLocation().addOnSuccessListener(MainMenu.this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {

                if(location != null) {

                    Log.d("TAG", "getting location worked");
                    String websiteUrl = "https://windy.com/?"+ location.toString();
                    Log.d("LOCATION", location.toString());
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(websiteUrl));
                    startActivity(intent);

                } else {
                    Log.d("TAG", "getting location failed");
                    String websiteUrl = "https://windy.com/";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(websiteUrl));
                    startActivity(intent);
                }

            }
        });


    }

    private void startVatsim() {
        Context context = this;
        Intent intent = Vatsim.createIntent(context);
        startActivity(intent);
    }

    private void startPlaneMenu() {
        Context context = this;
        Intent intent = PlaneMenu.createIntent(context);
        startActivity(intent);
    }

    private void startAirportMenu() {
        Context context = this;
        Intent intent = AirportMenu.createIntent(context);
        startActivity(intent);
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION},1);
        Log.d("requestPermission", "I was called!");
    }
}