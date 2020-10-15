package com.example.mfs2020companion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

        switch(position) {
            case 0://airports

                break;

            case 1://airplanes

                break;

            case 2://airplane finder

                break;

            case 3://notebook

                break;

            case 4://weather data
                openWeathergUrl();
                break;

            case 5: //vatsim

                break;

            case 6: //changelog
                openChangelogUrl();
                break;

        }

    }

    private void openChangelogUrl() {
        final String WEBSITE_URL = "https://www.pcgames.de/Microsoft-Flight-Simulator-Spiel-15259/News/Termin-neues-Update-Patch-Notes-Aenderungen-1357087/"; //this is not the correct URL but the windows server is currently down
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(WEBSITE_URL));
        startActivity(intent);
    }

    private void openWeathergUrl() {
        final String WEBSITE_URL = "https://windy.com";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(WEBSITE_URL));
        startActivity(intent);
    }
}