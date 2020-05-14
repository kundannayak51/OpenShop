package com.example.openshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.ViewHolder> {

    List<WishListModel> wishListModelList;

    public WishListAdapter(List<WishListModel> wishListModelList) {
        this.wishListModelList = wishListModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wishlist_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        int resource = wishListModelList.get(position).getProductImage();
        String title = wishListModelList.get(position).getTitle();
        String productPrice = wishListModelList.get(position).getProductPrice();
        String cuttedPrice = wishListModelList.get(position).getCuttedPrice();

        viewHolder.setData(resource,title,productPrice,cuttedPrice);

    }

    @Override
    public int getItemCount() {
        return wishListModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productTitle;
        private TextView productPrice;
        private TextView cuttedPrice;
        private View priceCut;
        private ImageView deleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.product_image_wishlist);
            productTitle = itemView.findViewById(R.id.product_title_wishlist);
            productPrice = itemView.findViewById(R.id.product_price_wishlist);
            cuttedPrice = itemView.findViewById(R.id.cutted_price_wishlist);
            priceCut = itemView.findViewById(R.id.price_cut_wishlist);
            deleteBtn = itemView.findViewById(R.id.delete_btn_wishlist);

        }

        private void setData(int resource,String title,String price,String cutPrice){
            productImage.setImageResource(resource);
            productTitle.setText(title);
            productPrice.setText(price);
            cuttedPrice.setText(cutPrice);

            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),"delete",Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
