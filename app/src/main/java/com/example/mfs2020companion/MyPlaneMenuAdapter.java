package com.example.mfs2020companion;


import android.content.Context;
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

                planeViewHolder.name.setText(plane.getName());
                planeViewHolder.cruiseSpeed.setText(plane.getCruiseSpeed());
                planeViewHolder.maxAltitude.setText(plane.getMaxAltitude());
                planeViewHolder.range.setText(plane.getRange());

                String path = "R.drawable." + plane.getImagePath();
                Uri uri = Uri.fromFile(new File(path));

                //planeViewHolder.image.setImageResource(uri);
        }

    }

    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }
}
