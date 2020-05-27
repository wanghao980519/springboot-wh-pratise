package com.wh.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.bean.DataBean;
import com.wh.handler.DataHandler;
import com.wh.handler.JsoupHandler;
import com.wh.mapper.DataMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WangHao
 * 2020-05-25
 */
@Service
public class DataServiceImpl extends ServiceImpl<DataMapper, DataBean> implements DataService {
//    @Override
//    public List<DataBean> getDate() {
//        List<DataBean> result = null;
//        try {
//            result = DataHandler.getDate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    @Override
//    public List<DataBean> listById(int id) {
//        if (id == 1) {
//            return DataHandler.getDate();
//        }
//        return JsoupHandler.getDate();
//    }


}
