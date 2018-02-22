package com.shop.models;

import java.util.ArrayList;

/**
 * Created by Mateusz Marczuk
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 22.02.2018.
 */
public class ProductData {

    static ArrayList<Product> products = new ArrayList<>();


    //getAll
    public static ArrayList<Product> getAll(){
        return products;
    }
    //Add
    public static void add(Product product){
        products.add(product);
    }
    //Remove
    public static void remove(int id){

        Product productToRemove = getById(id);
        products.remove(productToRemove);
    }

    //getById
    public static Product getById(int id){
        Product theProduct = null;
        for (Product cProduct: products){
            if (cProduct.getProductId() == id){
                theProduct = cProduct;
            }
        }
        return theProduct;
    }
}
