package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
    }

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, SecondActivity.class);
        //intent.putExtra(LOGIN_EMAIL_KEY, fromEmail);
        return intent;
    }
}