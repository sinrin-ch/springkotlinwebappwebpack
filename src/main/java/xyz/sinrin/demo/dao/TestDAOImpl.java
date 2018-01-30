package xyz.sinrin.demo.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import xyz.sinrin.demo.entity.TestBean;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TestDAOImpl implements TestDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TestBean> getAll() {
        String sql = "select * from test";
        List<TestBean> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TestBean.class));
//        List<TestBean> list = jdbcTemplate.queryForList(sql, TestBean.class);
        return list;
    }

    @Override
    public int save(TestBean bean) {
        String sql = "insert into test (ba,ta) values(?,?)";
        return jdbcTemplate.update(sql, bean.getBa(), bean.getTa());
    }

    @Override
    public int[] saveList(List<TestBean> beanList) {
        String sql = "insert into test (ba,ta) values(?,?)";
        return jdbcTemplate.batchUpdate(sql, beanList.stream().map(bean -> new Object[]{bean.getBa(), bean.getTa()}).collect(Collectors.toList()));
    }
}
