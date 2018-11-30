package com.myiahs_code.quickcooks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.the_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
            Toast.makeText(this,"Item 1 selected",Toast.LENGTH_SHORT).show();
            return true;
            case R.id.item2:
                Toast.makeText(this,"Item 2 selected",Toast.LENGTH_SHORT).show();

                return true;
            case R.id.item3:
                Toast.makeText(this,"Item 3 selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                Toast.makeText(this,"Item 4 selected",Toast.LENGTH_SHORT).show();
                return true;
                default:
                    return super.onOptionsItemSelected(item);

        }
    }

    //vars
    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mImageUrl = new ArrayList<>();
    private ArrayList<String> mImageDec = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate: started. ");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    initImageBiteMap();

    }
    private void initImageBiteMap(){
        Log.d(TAG,"initImageBitmap: preparing bitmap. ");

        mImageUrl.add("https://assets.bonappetit.com/photos/5aa9665c275dc52331d9184b/16:9/w_1200,c_limit/pantry-pasta.jpg");
        mName.add("Pantry Pasta");
        mImageDec.add("Quick Fresh pasta dish");
        mImageUrl.add("https://static01.nyt.com/images/2017/08/02/dining/02COOKING_CHICKENPAPRIKASH2/02COOKING_CHICKENPAPRIKASH2-articleLarge.jpg");
        mName.add("Chicken Paprikash");
        mImageDec.add(" It’s a dish that pairs beautifully with butter-slicked egg noodles.");
        mImageUrl.add("https://www.creative-culinary.com/wp-content/uploads/strawberry-margarita-1.jpg");
        mName.add("Fresh Strawberry Margaritas");
        mImageDec.add(" Fresh Strawberry Margarita for Cinco de Mayo");

        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG,"initRecyclerView: init recyclerView.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,mName,mImageUrl,mImageDec);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
