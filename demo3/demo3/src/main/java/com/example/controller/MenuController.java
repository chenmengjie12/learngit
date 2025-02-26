package com.example.controller;

import com.example.pojo.MenuInfo;
import com.example.service.MenuService;
import com.example.util.ResultMsg;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
@CrossOrigin
public class MenuController {
    private MenuService menuSerivce = new MenuService();
    @GetMapping("/listcid")
    public ResultMsg listByCid(int cid){
        List<MenuInfo> menuInfos = null;
        if (cid==1){
            menuInfos = menuSerivce.listByCid(1, 3);

        }else if(cid==2){
            menuInfos = menuSerivce.listByCid(2, 10);
        }else if(cid==3){
            menuInfos = menuSerivce.listByCid(3, 3);
        }else if(cid==4){
            menuInfos = menuSerivce.listByCid(4, 6);
        }else if(cid==5) {
            menuInfos = menuSerivce.listByCid(5, 5);
        }
        return ResultMsg.returnSuccess("菜单显示成功",menuInfos);
    }
}
