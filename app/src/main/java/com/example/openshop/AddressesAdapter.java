package com.example.openshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.openshop.DeliveryActivity.SELECT_ADDRESS;
import static com.example.openshop.MyAccountFragment.MANAGE_ADDRESS;
import static com.example.openshop.MyAddressesActivity.refreshItem;

public class AddressesAdapter extends RecyclerView.Adapter<AddressesAdapter.ViewHolder> {

    private List<AddressesModel> addressesModelList;
    private int MODE;
    private int preSelectedPosition = -1;

    public AddressesAdapter(List<AddressesModel> addressesModelList,int MODE) {
        this.addressesModelList = addressesModelList;
        this.MODE = MODE;
    }

    @NonNull
    @Override
    public AddressesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.addresses_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressesAdapter.ViewHolder viewHolder, int position) {
        String name = addressesModelList.get(position).getFullName();
        String address = addressesModelList.get(position).getAddress();
        String pincode = addressesModelList.get(position).getPincode();
        boolean selectedAddress = addressesModelList.get(position).getSelectedAddress();

        viewHolder.setData(name,address,pincode,selectedAddress,position);

    }

    @Override
    public int getItemCount() {
        return addressesModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView fullName;
        private TextView address;
        private TextView pincode;
        private ImageView icon;
        private LinearLayout optionContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fullName = itemView.findViewById(R.id.name_addr_item);
            address = itemView.findViewById(R.id.address_addr_item);
            pincode = itemView.findViewById(R.id.pincode_addr_item);
            icon = itemView.findViewById(R.id.icon_view_addr_item);
            optionContainer = itemView.findViewById(R.id.option_container_addr_item);
        }
        private void setData(String username, String userAddr, String userPin, boolean selectedAddr, final int position)
        {
            fullName.setText(username);
            address.setText(userAddr);
            pincode.setText(userPin);

            //select_address when user click deleivery button....a check mark will be shown at on address
            if(MODE == SELECT_ADDRESS){
                icon.setImageResource(R.drawable.greencheck);
                if(selectedAddr){
                    icon.setVisibility(View.VISIBLE);
                    preSelectedPosition = position;
                }else {
                    icon.setVisibility(View.GONE);
                }

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(preSelectedPosition != position){
                            addressesModelList.get(position).setSelectedAddress(true);
                            addressesModelList.get(preSelectedPosition).setSelectedAddress(false);
                            refreshItem(position,preSelectedPosition);
                            preSelectedPosition = position;
                        }
                    }
                });

            }else if(MODE == MANAGE_ADDRESS){
                optionContainer.setVisibility(View.GONE);
                icon.setImageResource(R.drawable.threedot);

                icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        optionContainer.setVisibility(View.VISIBLE);
                        refreshItem(preSelectedPosition,preSelectedPosition);
                        preSelectedPosition = position;
                    }
                });

                //if we dont want to show wdit or remove....simply click on any item view
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        refreshItem(preSelectedPosition,preSelectedPosition);
                        preSelectedPosition = -1;
                    }
                });
            }
        }
    }
}
