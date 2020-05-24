package com.example.openshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Deals of the Day");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycler_view_viewall);
        gridView = findViewById(R.id.grid_view_viewall);

        //same name should be used
        int layout_code = getIntent().getIntExtra("layout_code",-1);

        if(layout_code == 0){
            gridView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);

            List<WishListModel> wishListModelList = new ArrayList<>();
            wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone XR","Rs 49999","Rs 59999"));
            wishListModelList.add(new WishListModel(R.drawable.banner,"iPhone XR ffd","Rs 49999","Rs 59999"));
            wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone XR rgerh","Rs 49999","Rs 59999"));
            wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone XR thr","Rs 49999","Rs 59999"));
            wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone  wegwh","Rs 49999","Rs 59999"));
            //wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone XR trtn","Rs 49999","Rs 59999"));
            wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone XRdd","Rs 49999","Rs 59999"));
            wishListModelList.add(new WishListModel(R.drawable.banner,"iPhone XR ffd","Rs 49999","Rs 59999"));
            wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone XR rgerh","Rs 49999","Rs 59999"));
            wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone XR thr","Rs 49999","Rs 59999"));
            wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone  wegwh","Rs 49999","Rs 59999"));
            //wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone XR trtn","Rs 49999","Rs 59999"));

            WishListAdapter adapter = new WishListAdapter(wishListModelList,false);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }else if(layout_code == 1){
            //recyclerView.setVisibility(View.GONE);
            gridView.setVisibility(View.VISIBLE);
            List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();

            GridProductLayoutAdapter gridProductLayoutAdapter = new GridProductLayoutAdapter(horizontalProductScrollModelList);
            gridView.setAdapter(gridProductLayoutAdapter);
            gridProductLayoutAdapter.notifyDataSetChanged();
        }



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
