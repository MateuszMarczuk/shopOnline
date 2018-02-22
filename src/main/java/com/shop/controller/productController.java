package com.shop.controller;



import com.shop.models.Product;
import com.shop.models.ProductData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;


/**
 * Created by Mateusz Marczuk
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 15.02.2018.
 */

@Controller
public class productController {



    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String product(Model model){

        model.addAttribute("products", ProductData.getAll());
        model.addAttribute("title","List of product");
        return "product";
    }

    //only display
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProductForm(Model model){
        model.addAttribute("title", "Add product");
        model.addAttribute( new Product());
        return "addProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddProduct(@ModelAttribute @Valid Product newProduct, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("title", "Add product");
            return "addProduct";
        }
        ProductData.add(newProduct);
        return "redirect:/product";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String removeProductForm(Model model){
        model.addAttribute("products",ProductData.getAll());
        model.addAttribute("title","Remove your item");
        return "removeProduct";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String processedRemoveProduct(@RequestParam int[] productIds){
        for (int productId : productIds){
            ProductData.remove(productId);
        }
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
