package com.wh.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author WangHao
 * 2020-06-1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapBean implements Serializable {
    private static final long serialVersionUID = 4937254037270445699L;
    /**区域*/
    private String name;
    /**现有确诊*/
    private int nowConfirm;
}
