package com.example.mfs2020companion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.MainMenu);
    }

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, MainMenu.class);
        //intent.putExtra(LOGIN_EMAIL_KEY, fromEmail);
        return intent;
    }
}