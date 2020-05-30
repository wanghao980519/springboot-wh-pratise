package com.wh.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author WangHao
 * 2020-05-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GraphBean implements Serializable {
    private static final long serialVersionUID = 1442996151833916237L;
    private String data;
    private int nowConfirm;
}
