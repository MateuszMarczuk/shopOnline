package com.shop.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


/**
 * Created by Mateusz Marczuk
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 15.02.2018.
 */

@Controller
public class productController {

    static ArrayList<String> products = new ArrayList<>();


    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String product(Model model){

        model.addAttribute("products", products);
        model.addAttribute("title","List of product");
        return "product";
    }

    //only display
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProductForm(Model model){
        model.addAttribute("title", "Add product");
        return "addProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddProduct(@RequestParam String productName){
        products.add(productName);
        return "redirect:/product";
    }


//
//    @Autowired
//    private ProductRepository productService;


//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }

//
//    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
//    public String listProducts(Model model){
//        model.addAttribute("products", productService.listAll());
//        return "product/list";
//    }
//
//    @RequestMapping(value = "/product/show/{id}", method = RequestMethod.GET)
//    public String getProduct(@PathVariable Long id, Model model){
//        model.addAttribute("product", productService.getById(id));
//        return "product/show";
//    }




}
