package com.wh.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author WangHao
 * 2020-05-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraphTotal implements Serializable {

    private String date;
    private int confirm;
    private int heal;
    private int dead;

}
