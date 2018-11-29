package com.myiahs_code.quickcooks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class InfoActivity extends AppCompatActivity {
    private static final String TAG = " ";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Log.d(TAG, "onCreate: started. ");
        getIncomingIntent();

    }
    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intent.  ");
        if(getIntent().hasExtra("image_url")&& getIntent().hasExtra("image_name")&& getIntent().hasExtra("image_rec")){
            Log.d(TAG, "getIncomingIntent: found intent extras. ");
            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String imageDec = getIntent().getStringExtra("image_rec");
            setImage(imageUrl,imageName,imageDec);

        }
    }
    private void setImage(String imageUrl, String imageName, String imageDec){
        Log.d(TAG, "setImage: setting image and name to widget ");

        TextView name = findViewById(R.id.image_description);
        name.setText(imageName);


        TextView dec = findViewById(R.id.image_recipe);
        dec.setText(imageDec);


        ImageView image = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);

    }
}

