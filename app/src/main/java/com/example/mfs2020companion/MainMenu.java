package com.example.mfs2020companion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainMenu extends AppCompatActivity {
    RecyclerView menuItemsList;
    String s1[], s2[];
    int images[] = {R.drawable.airport,
            R.drawable.airplane,
            R.drawable.airplanefinder,
            R.drawable.notebook,
            R.drawable.weather,
            R.drawable.vatsim,
            R.drawable.patchnotes};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        menuItemsList = findViewById(R.id.MenuItemsList);

        s1 = getResources().getStringArray(R.array.menu_items);
        s2 = getResources().getStringArray(R.array.menu_descriptions);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);
    }

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, MainMenu.class);
        //intent.putExtra(LOGIN_EMAIL_KEY, fromEmail);
        return intent;
    }
}