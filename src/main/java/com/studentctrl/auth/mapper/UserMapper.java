package com.studentctrl.auth.mapper;

import com.alibaba.fastjson.JSONObject;
import com.studentctrl.auth.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    User selectByUserid(String userid);
    int insertUser(User user);
    int updateUser(String userid);
    int deleteUser(String userid);

    List<User> selectUserList();
    List<String> selectUserRole(String userid);
}
