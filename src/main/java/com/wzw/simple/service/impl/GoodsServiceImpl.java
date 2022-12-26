package com.wzw.simple.service.impl;

import com.wzw.simple.service.GoodsService;
import com.wzw.simple.store.mapper.GoodsMapper;
import com.wzw.simple.store.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * todo
 *
 * @author zewen.wang
 * @date 2022/12/26
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> list() {
        return goodsMapper.selectAll();
    }

}
