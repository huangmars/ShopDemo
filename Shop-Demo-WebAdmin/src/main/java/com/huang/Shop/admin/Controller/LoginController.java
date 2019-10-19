package com.huang.Shop.admin.Controller;
import com.huang.Shop.admin.Service.UserService;
import com.huang.Shop.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"","/login"})
    public String toLoginPage(){
        return "Login";
    }


    @PostMapping(value = "/login")
    public String Login(String email, String password, Model model,HttpSession session){
        List<User> users = userService.selectUserbyEmailandPassword(email,password);
        if (users.isEmpty()){
            model.addAttribute("MESSAGE","用户名或密码错误请重新输入");
            return "Login";
        }else {
            System.out.println("12321321");
            session.setAttribute("LOGIN_USER",users.get(0));
            return "redirect:/home";
        }
    }
}
