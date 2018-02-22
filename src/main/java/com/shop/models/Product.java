package com.shop.models;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Created by Mateusz Marczuk
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 20.02.2018.
 */

@Data
public class Product {

    @NotNull
    @Size(min = 3, max = 20, message = "product name must have more than 3 characters and less than 20")
    private String name;

    @NotNull
    @Size(min = 3, max = 50,message = "Description must have more than 3 characters and less than 50")
    private String description;


    private ProductState state;

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
