package com.db.school.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceContract customerService;

    @GetMapping
    public Customer getCustomer(@RequestParam("id") int id){
        return customerService.getCustomer(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/all")
    public Customer getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @PutMapping("/put")
    @ResponseBody
    public Boolean insertIntoCustomer(@RequestBody Customer customer){
        return customerService.insertCustomer(customer);
    }

    @PutMapping("/update")
    @ResponseBody
    public Boolean updateIntoCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @GetMapping("/delete")
    public Boolean deleteCustomer(@RequestParam("id") int id){
        return customerService.deleteCustomer(id);
    }
}

