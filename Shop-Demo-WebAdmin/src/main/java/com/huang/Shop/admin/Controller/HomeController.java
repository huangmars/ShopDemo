package com.huang.Shop.admin.Controller;
import com.huang.Shop.commons.Utils.ConstantUtils;
import com.huang.Shop.commons.Utils.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    @GetMapping(value = "/home")
    public String toHomePage(Model model){
        model.addAttribute("LoginTime", DateUtils.getCurrentDateTime());
        return "Home";
    }

    @GetMapping(value = "/logout")
    public String LogOut(HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession();
        session.removeAttribute(ConstantUtils.USER_SESSION);
        session.invalidate();
        return "redirect:/login";
    }
}
