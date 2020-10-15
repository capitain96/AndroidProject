package com.example.mfs2020companion;

import android.os.Bundle;
import android.util.Log;

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

        //proceeding to the changelogs
    }

}
