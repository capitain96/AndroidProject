package com.example.mfs2020companion;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Vatsim extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("create", "ChangeNotes was created");

        //normal on create layout loading
        setContentView(R.layout.vatsim);
        setTitle("Vatsim activity");

        Button vattasticButton = findViewById(R.id.vattasticButton);
        vattasticButton.setOnClickListener(v -> openVattasticUrl());

        Button vatsimButton = findViewById(R.id.vatsimButton);
        vatsimButton.setOnClickListener(v -> openVatsimUrl());

        Button flightplanButton = findViewById(R.id.flightplanButton);
        flightplanButton.setOnClickListener(v -> openFlightPlanUrl());

        Button simbriefButton = findViewById(R.id.simbriefButton);
        simbriefButton.setOnClickListener(v -> openSimBriefUrl());
    }

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, Vatsim.class);
        return intent;
    }

    private void openVattasticUrl() {
        final String WEBSITE_URL = "http://www.vattastic.com";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(WEBSITE_URL));
        startActivity(intent);
    }

    private void openVatsimUrl() {
        final String WEBSITE_URL = "https://www.vatsim.net";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(WEBSITE_URL));
        startActivity(intent);
    }

    private void openFlightPlanUrl() {
        final String WEBSITE_URL = "https://my.vatsim.net/pilots/flightplan"; //to get into this you need a login, can this be done somehow?
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(WEBSITE_URL));
        startActivity(intent);
    }

    private void openSimBriefUrl() {
        final String WEBSITE_URL = "https://www.simbrief.com/home/";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(WEBSITE_URL));
        startActivity(intent);
    }

}
