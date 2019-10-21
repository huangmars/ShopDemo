package com.huang.Shop.admin.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class EmployeeController {

    private Logger logger = Logger.getLogger("EmployeeController.class");

    @GetMapping("/emps")
    public String toEmpPage(){
        return "employee";
    }

}
