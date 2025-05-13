package org.example.recu_hacko.model;

import java.util.List;

public class Order {
    private String id;
    private String email;
    private List<String> products;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<String> getProducts() { return products; }
    public void setProducts(List<String> products) { this.products = products;}
}
