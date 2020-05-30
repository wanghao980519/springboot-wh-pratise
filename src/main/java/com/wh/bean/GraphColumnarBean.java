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
public class GraphColumnarBean implements Serializable, Comparable<GraphColumnarBean> {
    private static final long serialVersionUID = 3541833570959349060L;
    private String area;
    private int fromAbroad;

    @Override
    public int compareTo(GraphColumnarBean o) {
        return o.getFromAbroad() - this.getFromAbroad();
    }
}
