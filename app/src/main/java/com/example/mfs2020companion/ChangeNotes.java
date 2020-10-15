package com.example.mfs2020companion;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.util.LogPrinter;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChangeNotes extends AppCompatActivity {
    private final static String WEBSITE_URL = "https://www.pcgames.de/Microsoft-Flight-Simulator-Spiel-15259/News/Termin-neues-Update-Patch-Notes-Aenderungen-1357087/"; //this is not the correct URL but the windows server is currently down

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("create", "ChangeNotes was created");

        //normal on create layout loading
        setContentView(R.layout.change_notes);
        setTitle("ChangeLog activity");

        //proceeding to the changelogs
        Button loginButton = findViewById(R.id.changeLogButton);
        loginButton.setOnClickListener(v -> openUrl());
    }

    private void openUrl() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(WEBSITE_URL));
        startActivity(intent);
    }


    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, ChangeNotes.class);
        Log.d("I logged something", "I got called!: ");
        return intent;
    }

}
