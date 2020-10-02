package com.example.mfs2020companion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.MainMenu);
        setTitle("Main activity");

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> showSecondActivity());
    }

    private void showSecondActivity() {
        //String email = emailEditText.getText().toString();
        Intent intent = MainMenu.createIntent(this);
        startActivity(intent);
    }
}