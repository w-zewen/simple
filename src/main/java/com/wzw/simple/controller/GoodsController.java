package com.wzw.simple.controller;

import com.wzw.simple.bean.Response;
import com.wzw.simple.service.GoodsService;
import com.wzw.simple.store.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * todo
 *
 * @author zewen.wang
 * @date 2022/12/26
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/list")
    public Response<List<Goods>> list(){
        List<Goods> list = goodsService.list();
        return Response.success(list);
    }

}
