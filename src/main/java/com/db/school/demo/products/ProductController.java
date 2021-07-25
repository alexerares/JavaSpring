package com.db.school.demo.products;

import com.db.school.demo.customer.Customer;
import com.db.school.demo.customer.CustomerServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceContract productService;

    @GetMapping
    public Product getProduct(@RequestParam("cod") String cod){
        return productService.getProduct(cod);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/all")
    public Product getAllProduct(){
        return productService.getAllProduct();
    }

    @PutMapping("/put")
    @ResponseBody
    public Boolean insertIntoProduct(@RequestBody Product product){
        return productService.insertProduct(product);
    }

    @PutMapping("/update")
    @ResponseBody
    public Boolean updateIntoProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @GetMapping("/delete")
    public Boolean deleteProduct(@RequestParam("cod") String cod){
        return productService.deleteProduct(cod);
    }
}
