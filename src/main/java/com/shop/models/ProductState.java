package com.shop.models;

import lombok.Data;

/**
 * Created by Mateusz Marczuk
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 22.02.2018.
 */

public enum ProductState {

    NEW  ("NEW"),
    USED ("USED");

    private final String name;

    public String getName() {
        return name;
    }

    ProductState(String name) {
        this.name = name;
    }
}
