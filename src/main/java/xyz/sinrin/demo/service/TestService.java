package xyz.sinrin.demo.service;

import org.springframework.stereotype.Service;
import xyz.sinrin.demo.dao.TestDAO;
import xyz.sinrin.demo.entity.TestBean;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

//    @Resource
//    private TestBean bean;
    @Resource
    private TestDAO dao;

//    public String getMsg(){
//        return bean.toString();
//    }

    public List<TestBean> getBeans(){
        return dao.getAll();
    }
}
