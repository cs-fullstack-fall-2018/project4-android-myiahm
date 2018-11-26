package com.myiahs_code.quickcooks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mImageUrl = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate: started. ");

    initImageBiteMap();

    }
    private void initImageBiteMap(){
        Log.d(TAG,"initImageBitmap: preparing bitmap. ");

        mImageUrl.add("https://assets.bonappetit.com/photos/5aa9665c275dc52331d9184b/16:9/w_1200,c_limit/pantry-pasta.jpg");
        mName.add("Pantry Pasta");
        mImageUrl.add("https://static01.nyt.com/images/2017/08/02/dining/02COOKING_CHICKENPAPRIKASH2/02COOKING_CHICKENPAPRIKASH2-articleLarge.jpg");
        mName.add("Chicken Paprikash");
        mImageUrl.add("https://www.creative-culinary.com/wp-content/uploads/strawberry-margarita-1.jpg");
        mName.add("Fresh Strawberry Margaritas");
        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG,"initRecyclerView: init recyclerView.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,mName,mImageUrl);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
