package com.huang.Shop.admin.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

    @GetMapping(value = "/userlist")
    public String toUserPage(){
        return "user";
    }
}
