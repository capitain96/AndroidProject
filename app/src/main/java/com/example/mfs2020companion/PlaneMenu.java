package com.example.mfs2020companion;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlaneMenu extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        //normal on create layout loading
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plane_menu);
        setTitle("Main activity");

        //proceeding to the main menu
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> showMainMenu());

        //clicklistener to get to my repository
        TextView urlTextView = findViewById(R.id.githubLink);
        urlTextView.setOnClickListener(v -> openUrl());
    }
}
