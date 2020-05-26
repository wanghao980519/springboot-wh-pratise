package com.wh.service;

import com.wh.bean.DataBean;

import java.util.List;

/**
 * @author WangHao
 * 2020-05-25
 */
public interface DataService {
    /**
     * 从指定网站获取数据，进行解析头返回结果
     * @return List<DataBean>
     */
    List<DataBean> getDate();

}
