package com.db.school.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceContract orderService;

    @GetMapping
    public Order getOrder(@RequestParam("id") int id){
        return orderService.getOrder(id);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order customer) {
        return orderService.createOrder(customer);
    }

    @GetMapping("/all")
    public Order getAllOrder(){
        return orderService.getAllOrder();
    }

    @PutMapping("/put")
    @ResponseBody
    public Boolean insertIntoOrder(@RequestBody Order customer){
        return orderService.insertOrder(customer);
    }

    @PutMapping("/update")
    @ResponseBody
    public Boolean updateIntoOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

    @GetMapping("/delete")
    public Boolean deleteOrder(@RequestParam("id") int id){
        return orderService.deleteOrder(id);
    }
}
