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
public class GraphPie implements Serializable {
    private static final long serialVersionUID = 7112218436989003652L;
    private String name;
    private String value;
}
