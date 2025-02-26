package com.example.controller;

import com.example.pojo.UserInfo;
import com.example.service.UserService;
import com.example.service.UserService;
import com.example.util.ResultMsg;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    private UserService userService = new UserService();
    @PostMapping("/login")
    public ResultMsg login(@RequestBody UserInfo user){
        UserInfo u1 = userService.login(user.getLoginname(), user.getPass());
        if (u1!=null){
            return ResultMsg.returnSuccess("登录成功",u1);
        }else {
            return ResultMsg.returnError("登录失败");
        }
    }
    @GetMapping("/list")
    public List<UserInfo> list(){
        return userService.list();
    }
    @GetMapping("/queryid")
    public ResultMsg queryById(Integer id){
        UserInfo userInfo = userService.selectOne(id);
        if (userInfo==null){
            return ResultMsg.returnError("无此员工信息");
        }else {
            return ResultMsg.returnSuccess("查询成功",userInfo);
        }
    }
    @GetMapping("/queryname")
    public ResultMsg queryById(String name){
        UserInfo userInfo = userService.queryByName(name);
        if(userInfo==null){
           return ResultMsg.returnSuccess("可以添加该用户");
        }else {
            return ResultMsg.returnError("员工已存在");
        }
    }
    @PostMapping("/add")
    public ResultMsg add(@RequestBody UserInfo userInfo){
        UserInfo u1 = userService.queryByName(userInfo.getLoginname());
        System.out.println("u1====="+u1);
        if(u1!=null){
            return ResultMsg.returnError("登录名重复失败");
        }else{
            boolean add = userService.add(userInfo);
            if (add){
                return ResultMsg.returnSuccess("添加用户成功");
            } else {
                return ResultMsg.returnError("添加用户失败");
            }

        }
    }
    @DeleteMapping("/del")
    public ResultMsg del(Integer id){
        boolean flag = userService.del(id);
        if(flag){
            return ResultMsg.returnSuccess("删除用户成功");
        }else{
            return ResultMsg.returnError("删除用户失败");
        }
    }
    @PutMapping ("/upd")
    public ResultMsg upd(@RequestBody UserInfo userInfo){
        boolean flag = userService.upd(userInfo);
        if(flag){
            return ResultMsg.returnSuccess("更新用户成功");
        }else{
            return ResultMsg.returnError("更新用户失败");
        }
    }
}
