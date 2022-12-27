package com.wzw.simple.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页类
 *
 * @author zewen.wang
 * @date 2022/12/27
 */
@Data
public class Paging<T> implements Serializable {
    private Long total;
    private List<T> data;

    public Paging() {}

    public Paging(Long total, List<T> data) {
        this.total = total;
        this.data = data;
    }

}
