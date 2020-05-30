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
public class GraphAddBean implements Serializable {
    private static final long serialVersionUID = -7788049496946151791L;
    private String date;
    private int confirm;
    private int suspect;
}
