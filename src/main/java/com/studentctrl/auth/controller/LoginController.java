package com.studentctrl.auth.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.studentctrl.auth.entity.User;
import com.studentctrl.auth.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping (value = "userLogin")
    public JSONObject getUser(@RequestBody User user) throws JSONException {
        User login = loginService.selectByUserid(user.getUserid());
        JSONObject jsonObject = new JSONObject();
        if (login != null) {
            jsonObject.put("username", login.getUsername());
            jsonObject.put("path", "home");
        } else {
            jsonObject.put("path", "login");
        }
        return jsonObject;
    }

    @PostMapping(value = "insertUser")
    public JSONObject insertUser(@RequestBody User user) throws JSONException {
        int count = loginService.insertUser(user);
        JSONObject jsonObject = new JSONObject();
        if (count > 0) {
            jsonObject.put("message", "插入成功!");
        }

        return jsonObject;
    }

    @PostMapping(value = "selectUser")
    public JSONArray selectUserList() throws JSONException {
        List<User> list = loginService.selectUserList();
        JSONArray jsonArray = new JSONArray();
        if (list.size() == 0) {
//            jsonArray.put("message", "无数据!");
        } else {
            jsonArray = (JSONArray) JSONArray.toJSON(list);
        }

        return jsonArray;
    }

    @PostMapping(value = "selectUserRole")
    public List<String> selectUserRoleList(@RequestBody User user) throws JSONException {
        List<String> list = loginService.selectUserRoleList(user.getUserid());
//        JSONArray jsonArray = new JSONArray();
//        if (list.size() == 0) {
////            jsonArray.put("message", "无数据!");
//        } else {
//            jsonArray = (JSONArray) JSONArray.toJSON(list);
//        }

        return list;
    }
}
