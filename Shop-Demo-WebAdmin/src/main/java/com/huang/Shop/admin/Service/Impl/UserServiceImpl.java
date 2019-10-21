package com.huang.Shop.admin.Service.Impl;
import com.huang.Shop.admin.Mapper.UserMapper;
import com.huang.Shop.admin.Service.UserService;
import com.huang.Shop.domain.User;
import com.huang.Shop.domain.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Transactional(readOnly = true)
    public List<User> selectUserbyEmailandPassword(String email, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andTEmailEqualTo(email).andTPasswordEqualTo(password);
        return userMapper.selectByExample(example);
    }


    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }
}
