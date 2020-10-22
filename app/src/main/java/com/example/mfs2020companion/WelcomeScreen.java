package com.example.mfs2020companion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {
    private final static String WEBSITE_URL = "https://github.com/capitain96/AndroidProject";
    boolean nightmode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {




        //normal on create layout loading
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);
        setTitle("Main activity");

        //proceeding to the main menu
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> showMainMenu());

        //clicklistener to get to my repository
        TextView urlTextView = findViewById(R.id.githubLink);
        urlTextView.setOnClickListener(v -> openUrl());

        Button nightmodeButton = findViewById(R.id.nightmode);


        nightmodeButton.setOnClickListener(v -> ChangeDarkMode());
    }

    private void showMainMenu() {
        //String email = emailEditText.getText().toString();
        Intent intent = MainMenu.createIntent(this);
        startActivity(intent);
    }

    private void openUrl() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(WEBSITE_URL));
        startActivity(intent);
    }

    private void ChangeDarkMode() {
        Button nightmodeButton = findViewById(R.id.nightmode);
        View background = findViewById(R.id.welcome_screen);
        if(nightmode) {
            background.setBackgroundResource(R.drawable.runwaybyday);
            nightmodeButton.setText(getString(R.string.nightmode)); //problematic gotta fix this
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            nightmode = false;
        } else {
            background.setBackgroundResource(R.drawable.runwaybynight);
            nightmodeButton.setText(getString(R.string.daymode));
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            nightmode = true;
        }
    }
}