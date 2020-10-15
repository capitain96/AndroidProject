package com.example.mfs2020companion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainMenu extends AppCompatActivity implements MyAdapter.OnMenuItemListener{
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

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images, this);
        menuItemsList.setAdapter(myAdapter);
        menuItemsList.setLayoutManager((new LinearLayoutManager(this)));
    }

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, MainMenu.class);
        //intent.putExtra(LOGIN_EMAIL_KEY, fromEmail);
        return intent;
    }

    @Override
    public void onMenuItemClick(int position) {
        Log.d(s1[position], "onMenuItemClick: ");
        //Intent intent = new Intent(this, NewActivity.class);
        //startActivity(intent);
    }
}