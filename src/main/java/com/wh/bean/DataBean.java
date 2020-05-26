package com.wh.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WangHao
 * 2020-05-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor


public class DataBean {
    /**区域*/
    private String area;
    /**现有确诊*/
    private int nowConfirm;
    /**累计确诊*/
    private int confirm;
    /**治愈*/
    private int heal;
    /**死亡*/
    private int dead;
}
