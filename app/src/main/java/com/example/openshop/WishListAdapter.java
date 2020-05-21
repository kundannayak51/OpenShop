package com.example.openshop;

import android.content.Intent;
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

    private List<WishListModel> wishListModelList;
    private Boolean wishlist;

    public WishListAdapter(List<WishListModel> wishListModelList, Boolean wishlist) {
        this.wishListModelList = wishListModelList;
        this.wishlist = wishlist;
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //System.out.println("AAAAA\n");
                    Intent productDetailsIntent = new Intent(itemView.getContext(),ProductsDetailActivity.class);
                    itemView.getContext().startActivity(productDetailsIntent);
                }
            });
            // if this is used as wishlist adapter then only delete Btn will be visible
            if(wishlist){
                //System.out.println("QQQQMMM\n");
                deleteBtn.setVisibility(View.VISIBLE);
            }else{
                //System.out.println("QQQQ\n");
                deleteBtn.setVisibility(View.GONE);
            }

            if(wishlist){
                deleteBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(itemView.getContext(),"delete",Toast.LENGTH_SHORT).show();
                    }
                });
            }




        }
    }
}
