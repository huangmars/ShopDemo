package com.huang.Shop.admin.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping(value = "/home")
    public String toHomePage(){
        return "Home";
    }
}
