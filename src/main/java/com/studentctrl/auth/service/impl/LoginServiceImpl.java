package com.studentctrl.auth.service.impl;

import com.studentctrl.auth.entity.User;
import com.studentctrl.auth.mapper.UserMapper;
import com.studentctrl.auth.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService{

    private UserMapper userMapper;

    @Autowired
    public LoginServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User selectByUserid(String userid) {
        return userMapper.selectByUserid(userid);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(String userid) {
        return userMapper.updateUser(userid);
    }

    @Override
    public int deleteUser(String userid) {
        return userMapper.deleteUser(userid);
    }

    @Override
    public List<User> selectUserList() {
        return userMapper.selectUserList();
    }

    @Override
    public List<String> selectUserRoleList(String userid) {
        return userMapper.selectUserRole(userid);
    }


}
