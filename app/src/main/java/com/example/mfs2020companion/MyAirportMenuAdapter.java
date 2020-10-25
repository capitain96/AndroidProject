package com.example.mfs2020companion;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;
import java.util.List;

public class MyAirportMenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final int TYPE = 1;
    private final Context context;
    private final List<Object> listRecyclerItem;

    public MyAirportMenuAdapter(Context context, List<Object> listRecyclerItem) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;
    }

    public class AirportViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView ICAOCode;
        private TextView airportCode;
        private TextView runways;
        private ImageView image;

        public AirportViewHolder(@NonNull View itemView) {
            super (itemView);
            name = (TextView) itemView.findViewById(R.id.textView20);
            ICAOCode = (TextView) itemView.findViewById(R.id.textView24);
            airportCode = (TextView) itemView.findViewById(R.id.textView25);
            runways = (TextView) itemView.findViewById(R.id.textView26);
            image = (ImageView) itemView.findViewById(R.id.imageView22);


        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE :

            default:

                View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.airport_list_item, parent, false);

                return new AirportViewHolder((layoutView));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);

        switch (viewType) {
            case TYPE:
            default:

                AirportViewHolder airportViewHolder = (AirportViewHolder) holder;
                Airport airport = (Airport) listRecyclerItem.get(position);

                airportViewHolder.name.setText(airport.getName());
                airportViewHolder.ICAOCode.setText(airport.getICAOCode());
                airportViewHolder.airportCode.setText(airport.getAirportCode());
                airportViewHolder.runways.setText(airport.getRunways());

                String path = airport.getImagePath();
                byte[] data = readImageFromAssets(path);
                Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                airportViewHolder.image.setImageBitmap(bitmap);
        }

    }

    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }

    private byte[] readImageFromAssets(String path) {
        try {
            InputStream is = context.getAssets().open(path);
            byte[] imageBytes = new byte[is.available()];
            is.read(imageBytes);
            is.close();

            return imageBytes;
        } catch (Exception ignored) {
            return new byte[0];
        }
    }



}
