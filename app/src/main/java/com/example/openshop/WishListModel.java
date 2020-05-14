package com.example.openshop;

public class WishListModel {
    private int productImage;
    private String title;
    private String productPrice;
    private String cuttedPrice;

    public WishListModel(int productImage, String title, String productPrice, String cuttedPrice) {
        this.productImage = productImage;
        this.title = title;
        this.productPrice = productPrice;
        this.cuttedPrice = cuttedPrice;
    }

    public int getProductImage() {
        return productImage;
    }

    public String getTitle() {
        return title;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getCuttedPrice() {
        return cuttedPrice;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public void setCuttedPrice(String cuttedPrice) {
        this.cuttedPrice = cuttedPrice;
    }
}
