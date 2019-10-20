package com.huang.Shop.admin.Controller;
import com.huang.Shop.admin.Service.UserService;
import com.huang.Shop.commons.Utils.ConstantUtils;
import com.huang.Shop.commons.Utils.CookieUtils;
import com.huang.Shop.commons.Utils.DateUtils;
import com.huang.Shop.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class LoginController {

    private Logger logger = Logger.getLogger("LoginController.class");

    @Autowired
    private UserService userService;

    @GetMapping(value = {"","/login"})
    public String toLoginPage(HttpServletRequest request,Model model){
        String userInfo = CookieUtils.getCookieValue(request,ConstantUtils.COOKIE_USER_INFO);
        if (!StringUtils.isEmpty(userInfo)){
            String[] userInfoArr = userInfo.split(":");
            model.addAttribute("email",userInfoArr[0]);
            model.addAttribute("password",userInfoArr[1]);
            model.addAttribute("isRemember",true);
        }
        return "Login";
    }


    @PostMapping(value = "/login")
    public String Login(String email, String password, String isRemember, Model model, HttpServletRequest request,
                        HttpServletResponse response ,HttpSession session){
        // 不勾选记住我
        if ("off".equals(isRemember)){
            CookieUtils.deleteCookie(request,response,ConstantUtils.COOKIE_USER_INFO);
        }

        List<User> users = userService.selectUserbyEmailandPassword(email,password);
        if (users.isEmpty()){
            model.addAttribute("MESSAGE","用户名或密码错误请重新输入");
            return "Login";
        }else {
            //勾选记住我
            if ("on".equals(isRemember)){
                CookieUtils.setCookie(request,response,ConstantUtils.COOKIE_USER_INFO,
                            String.format("%s:%s",email,password), 7*24*60*60);
            }
            session.setAttribute(ConstantUtils.USER_SESSION,users.get(0));
            System.out.println(DateUtils.getCurrentDateTime());
            return "redirect:/home";
        }
    }


}
