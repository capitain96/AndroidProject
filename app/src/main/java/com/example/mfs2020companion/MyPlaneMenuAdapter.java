package com.example.mfs2020companion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyPlaneMenuAdapter {



    String planeNames[], cruiseSpeed[]; //do you really want to do it this way? maybe do it as an object?
    int images[]; //maybe as an object?
    Context context;
    private MyAdapter.OnMenuItemListener myOnMenuItemListener;

    public MyAdapter(Context ct, String s1[], String s2[], int img[], MyAdapter.OnMenuItemListener myOnMenuItemListener) {
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
        this.myOnMenuItemListener = myOnMenuItemListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        TextView myText1, myText2;
        ImageView myImage;
        MyAdapter.OnMenuItemListener onMenuItemListener;

        public MyViewHolder(@NonNull View itemView, MyAdapter.OnMenuItemListener onMenuItemListener) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.menuItemTitle);
            myText2 = itemView.findViewById(R.id.menuItemDescription);
            myImage = itemView.findViewById(R.id.menuItemImage);
            this.onMenuItemListener = onMenuItemListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onMenuItemListener.onMenuItemClick(getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.menu_row, parent, false);
        return new MyAdapter.MyViewHolder(view, myOnMenuItemListener);
    }

    @Override
    public void onBindViewHolder  (@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public interface OnMenuItemListener {
        void onMenuItemClick(int position);
    }

}
