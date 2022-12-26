package com.wzw.simple.store.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 表名：goods
 * 表注释：用户信息表
*/
public class Goods implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 商品品类
     */
    @Column(name = "goods_type")
    private String goodsType;

    /**
     * 商品库存
     */
    @Column(name = "goods_in_stock")
    private Integer goodsInStock;

    /**
     * 商品图片
     */
    @Column(name = "goods_pic")
    private String goodsPic;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取商品名称
     *
     * @return goodsName - 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置商品名称
     *
     * @param goodsName 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 获取商品品类
     *
     * @return goodsType - 商品品类
     */
    public String getGoodsType() {
        return goodsType;
    }

    /**
     * 设置商品品类
     *
     * @param goodsType 商品品类
     */
    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    /**
     * 获取商品库存
     *
     * @return goodsInStock - 商品库存
     */
    public Integer getGoodsInStock() {
        return goodsInStock;
    }

    /**
     * 设置商品库存
     *
     * @param goodsInStock 商品库存
     */
    public void setGoodsInStock(Integer goodsInStock) {
        this.goodsInStock = goodsInStock;
    }

    /**
     * 获取商品图片
     *
     * @return goodsPic - 商品图片
     */
    public String getGoodsPic() {
        return goodsPic;
    }

    /**
     * 设置商品图片
     *
     * @param goodsPic 商品图片
     */
    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsType=").append(goodsType);
        sb.append(", goodsInStock=").append(goodsInStock);
        sb.append(", goodsPic=").append(goodsPic);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}