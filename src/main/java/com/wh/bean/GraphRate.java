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
public class GraphRate implements Serializable {
    private static final long serialVersionUID = 6105345198798860990L;
    private String date;
    private String healRate;
    private String deadRate;
}
