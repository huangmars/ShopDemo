package com.huang.Shop.admin.Intercepto;
import com.huang.Shop.commons.Utils.ConstantUtils;
import com.huang.Shop.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;


public class PermissionController implements HandlerInterceptor {

    private Logger logger = Logger.getLogger("PermissionController.class");


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView.getViewName().endsWith("Login")){
            User user = (User) request.getSession().getAttribute(ConstantUtils.USER_SESSION);
            if (user!=null){
                response.sendRedirect("/admin/home");
            }
        }
    }


}
