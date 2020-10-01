package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main activity");

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> showSecondActivity());
    }

    private void showSecondActivity() {
        //String email = emailEditText.getText().toString();
        Intent intent = SecondActivity.createIntent(this);
        startActivity(intent);
    }
}