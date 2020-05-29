package com.wh.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author WangHao
 * 2020-05-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("illness")
public class DataBean implements Serializable {
    private static final long serialVersionUID = 4997944716062571495L;
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
