package com.wh.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataBean {
    private String area; // 区域
    private int nowConfirm; // 现有确诊
    private int confirm; // 累计确诊
    private int heal; // 治愈
    private int dead; // 死亡
}
