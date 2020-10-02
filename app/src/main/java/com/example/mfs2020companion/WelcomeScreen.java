package com.example.mfs2020companion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {
    private final static String WEBSITE_URL = "https://github.com/capitain96/AndroidProject";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //normal on create layout loading
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);
        setTitle("Main activity");

        //proceeding to the main menu
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> showSecondActivity());

        //clicklistener to get to my repository
        TextView urlTextView = findViewById(R.id.githubLink);
        urlTextView.setOnClickListener(v -> openUrl());
    }

    private void showSecondActivity() {
        //String email = emailEditText.getText().toString();
        Intent intent = MainMenu.createIntent(this);
        startActivity(intent);
    }

    private void openUrl() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(WEBSITE_URL));
        startActivity(intent);
    }
}