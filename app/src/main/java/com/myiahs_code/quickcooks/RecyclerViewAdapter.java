package com.myiahs_code.quickcooks;

import android.content.Context;
//import android.support.annotation.NonNull;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.myiahs_code.quickcooks.R.id.image_rec;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImageName = new ArrayList<>();

    private ArrayList<String> mImages = new ArrayList<>();

    private  ArrayList<String> mImageDec = new ArrayList<>();


    private Context mContext;

    private ViewGroup parent;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> mImageName, ArrayList<String> mImages, ArrayList<String> mImageDec) {
        this.mImageName = mImageName;
        this.mImages = mImages;
        this.mImageDec = mImageDec;
        this.mContext = mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent ,false);
          ViewHolder viewHolder = new ViewHolder(view);
          return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
                   Log.d(TAG,"onBindViewHolder:called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(viewHolder.image);


        viewHolder.imageName.setText(mImageName.get(position));

        viewHolder.imageDec.setText(mImageDec.get(position));

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick: clicked on : "+ mImageName.get(position));

                Toast.makeText(mContext,mImageName.get(position),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, InfoActivity.class);
                intent.putExtra("image_url", mImages.get(position));
                intent.putExtra("image_name", mImageName.get(position));
                intent.putExtra("image_rec", mImageDec.get(position));
                mContext.startActivity(intent);


            }
        });

    }


    @Override
    public int getItemCount() {
        return mImageName.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        CircleImageView image;
        TextView imageName;
        TextView imageDec;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            imageDec = itemView.findViewById(R.id.image_rec);
            parentLayout = itemView.findViewById(R.id.parent_layout);




        }
    }
}
