package com.example.mfs2020companion;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public class MyPlaneMenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final int TYPE = 1;
    private final Context context;
    private final List<Object> listRecyclerItem;

    public MyPlaneMenuAdapter(Context context, List<Object> listRecyclerItem) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;
    }

    public class PlaneViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView cruiseSpeed;
        private TextView maxAltitude;
        private TextView range;
        private ImageView image;
        //private int image; //don't know yet how to implement the image

        public PlaneViewHolder(@NonNull View itemView) {
            super (itemView);
            name = (TextView) itemView.findViewById(R.id.textView);
            cruiseSpeed = (TextView) itemView.findViewById(R.id.textView4);
            maxAltitude = (TextView) itemView.findViewById(R.id.textView5);
            range = (TextView) itemView.findViewById(R.id.textView6);
            image = (ImageView) itemView.findViewById(R.id.imageView2);


        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE :

            default:

                View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.plane_list_item, parent, false);

                return new PlaneViewHolder((layoutView));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);

        switch (viewType) {
            case TYPE:
            default:

                PlaneViewHolder planeViewHolder = (PlaneViewHolder) holder;
                Plane plane = (Plane) listRecyclerItem.get(position);

                planeViewHolder.name.append(plane.getName());
                planeViewHolder.cruiseSpeed.append("\n" + plane.getCruiseSpeed());
                planeViewHolder.maxAltitude.append("\n" + plane.getMaxAltitude());
                planeViewHolder.range.append("\n" + plane.getRange());

                String path = plane.getImagePath();
                byte[] data = readImageFromAssets(path);
                Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                planeViewHolder.image.setImageBitmap(bitmap);
        }

    }

    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }

    private byte[] readImageFromAssets(String uri) {
        try {
            InputStream is = context.getAssets().open("android-mascot.png");
            byte[] imageBytes = new byte[is.available()];
            is.read(imageBytes);
            is.close();

            return imageBytes;
        } catch (Exception ignored) {
            return new byte[0];
        }
    }



}
