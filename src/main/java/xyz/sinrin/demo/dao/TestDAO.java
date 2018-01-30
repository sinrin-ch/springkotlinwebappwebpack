package xyz.sinrin.demo.dao;

import xyz.sinrin.demo.entity.TestBean;

import java.util.List;

public interface TestDAO {
    List<TestBean> getAll();

    int save(TestBean bean);

    int[] saveList(List<TestBean> beanList);
}
