package com.wzw.simple.store.mapper;

import com.wzw.simple.store.model.Goods;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface GoodsMapper extends Mapper<Goods> {
}