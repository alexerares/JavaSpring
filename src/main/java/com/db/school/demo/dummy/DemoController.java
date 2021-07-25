package com.db.school.demo.dummy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private int counter;
    public DemoController() {
        System.out.println("----------------> DemoController was created! <--------------------");
    }

    @GetMapping("/demo")
    public String getCustomer(@RequestParam("name") String name){
        counter++;
        return "Data about customer " + name + " - " + counter;
    }
}
