package com.wh.service;

import com.wh.bean.DataBean;
import com.wh.handler.DataHandler;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WangHao
 * 2020-05-25
 */
@Service
public class DataServiceImpl implements DataService {
    @Override
    public List<DataBean> getDate() {
        List<DataBean> result = null;
        try {
            result = DataHandler.getDate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
