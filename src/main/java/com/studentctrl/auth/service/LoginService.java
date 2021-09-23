package com.studentctrl.auth.service;

import com.studentctrl.auth.entity.User;

import java.util.List;
import java.util.Map;

public interface LoginService {
    public User selectByUserid(String userid);
    public int insertUser(User user);
    public int updateUser(String userid);
    public int deleteUser(String userid);
    public List<User> selectUserList();
    public List<String> selectUserRoleList(String userid);
}
