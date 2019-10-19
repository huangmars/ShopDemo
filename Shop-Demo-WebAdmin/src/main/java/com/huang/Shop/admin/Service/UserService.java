package com.huang.Shop.admin.Service;
import com.huang.Shop.domain.User;
import java.util.List;


public interface UserService {
    public List<User> selectUserbyEmailandPassword(String email, String password);
}
