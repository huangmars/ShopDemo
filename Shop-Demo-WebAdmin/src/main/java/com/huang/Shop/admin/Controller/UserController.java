package com.huang.Shop.admin.Controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huang.Shop.admin.Service.UserService;
import com.huang.Shop.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.logging.Logger;


@Controller
public class UserController {

    private Logger logger = Logger.getLogger("UserController.class");

    @Autowired
    private UserService userService;


    @GetMapping(value = "/users")
    public String toUserPage(@RequestParam(defaultValue = "1", name = "pageNum") Integer pageNum, Model model){
        //创建PageHelper，后面紧跟的查询为分页查询
        PageHelper.startPage(pageNum, 5);
        List<User> users = userService.selectAllUser();
        //用pageInfo封装查询结果，然后交给页面
        PageInfo pageInfo = new PageInfo(users, 5);
        logger.info(pageInfo.toString());
        model.addAttribute("pageInfo",pageInfo);
        return "user";
    }

}
