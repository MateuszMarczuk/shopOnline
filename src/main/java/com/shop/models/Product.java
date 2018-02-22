package com.shop.models;

import lombok.Data;


/**
 * Created by Mateusz Marczuk
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 20.02.2018.
 */

@Data
public class Product {

    private String name;
    private String description;
    private int productId;
    public static int nextId = 1;

    public Product(){
        productId = nextId;
        nextId++;
    }

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
