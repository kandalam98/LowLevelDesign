package org.example.VendingMachine;

public class Product{
    Integer id;
    String productName;
    Integer price;

    public Product(Integer id, String productName, Integer price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
