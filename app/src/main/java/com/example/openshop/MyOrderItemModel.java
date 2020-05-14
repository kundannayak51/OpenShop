package com.example.openshop;

public class MyOrderItemModel {
    private int productImage;
    private String productTitle;
    private String delieveryStatus;

    public MyOrderItemModel(int productImage, String productTitle, String delieveryStatus) {
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.delieveryStatus = delieveryStatus;
    }

    public int getProductImage() {
        return productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public String getDelieveryStatus() {
        return delieveryStatus;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public void setDelieveryStatus(String delieveryStatus) {
        this.delieveryStatus = delieveryStatus;
    }
}
