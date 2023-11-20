package ma.enset.tpjdbc.com.dao.entities;

import java.io.Serializable;

public class Product implements Serializable {
    private Long id;
    private String name;
    private double price;

    private double quantity;

    public Product(String name, double price,double quantity){
        this.name = name;
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
