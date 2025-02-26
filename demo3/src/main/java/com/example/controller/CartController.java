package com.example.controller;

import com.example.VO.CartVO;
import com.example.pojo.Cart;
import com.example.service.CartService;
import com.example.util.ResultMsg;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {
    CartService cartService = new CartService();
    @GetMapping("/listbyuid")
    //接收用户ID uid，返回该用户的购物车列表
    public ResultMsg listByUid(int uid){
        List<CartVO> cartVOS = cartService.listByUid(uid);
        return ResultMsg.returnSuccess("显示成功",cartVOS);
    }
    @PostMapping ("/add")
    public ResultMsg add(@RequestBody Cart cart){
        System.out.println("cart"+cart);
        boolean b = cartService.addCart(cart);
        if (b) {
            return ResultMsg.returnSuccess("添加购物车成功");
        }else {
            return ResultMsg.returnError("添加购物车失败");
        }
    }
    @DeleteMapping ("/del")
    public ResultMsg del(int cid){
        boolean b = cartService.delCart(cid);
        if (b) {
            return ResultMsg.returnSuccess("删除成功");
        }else {
            return ResultMsg.returnError("删除失败");
        }
    }
}
