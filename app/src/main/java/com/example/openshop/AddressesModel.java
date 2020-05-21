package com.example.openshop;

public class AddressesModel {

    private String fullName;
    private String address;
    private String pincode;
    private boolean selectedAddress;

    public AddressesModel(String fullName, String address, String pincode,boolean selectedAddress) {
        this.fullName = fullName;
        this.address = address;
        this.pincode = pincode;
        this.selectedAddress = selectedAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPincode() {
        return pincode;
    }

    public boolean getSelectedAddress() {
        return selectedAddress;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setSelectedAddress(boolean selectedAddress) {
        this.selectedAddress = selectedAddress;
    }
}
