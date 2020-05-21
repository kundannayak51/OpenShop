package com.example.openshop;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyWishlistFragment extends Fragment {


    public MyWishlistFragment() {
        // Required empty public constructor
    }

    private RecyclerView wishlistRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_wishlist, container, false);
        wishlistRecyclerView = view.findViewById(R.id.my_wishlist_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        wishlistRecyclerView.setLayoutManager(layoutManager);

        List<WishListModel> wishListModelList = new ArrayList<>();
        wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone XR","Rs 49999","Rs 59999"));
        wishListModelList.add(new WishListModel(R.drawable.banner,"iPhone XR ffd","Rs 49999","Rs 59999"));
        wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone XR rgerh","Rs 49999","Rs 59999"));
        wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone XR thr","Rs 49999","Rs 59999"));
        wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone  wegwh","Rs 49999","Rs 59999"));
        wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone XR trtn","Rs 49999","Rs 59999"));
        wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone XRdd","Rs 49999","Rs 59999"));
        wishListModelList.add(new WishListModel(R.drawable.banner,"iPhone XR ffd","Rs 49999","Rs 59999"));
        wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone XR rgerh","Rs 49999","Rs 59999"));
        wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone XR thr","Rs 49999","Rs 59999"));
        wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone  wegwh","Rs 49999","Rs 59999"));
        wishListModelList.add(new WishListModel(R.drawable.productimage,"iPhone XR trtn","Rs 49999","Rs 59999"));

        WishListAdapter wishListAdapter = new WishListAdapter(wishListModelList,true);
        wishlistRecyclerView.setAdapter(wishListAdapter);
        wishListAdapter.notifyDataSetChanged();

        return view;
    }

}
