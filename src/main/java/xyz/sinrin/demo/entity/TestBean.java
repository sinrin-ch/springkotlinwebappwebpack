package xyz.sinrin.demo.entity;

import org.springframework.stereotype.Component;

//@Component  // 默认是singleton,可以用@Scope配置prototype
public class TestBean {
    private String ba;
    private String ta;


    public String getBa() {
        return ba;
    }

    public void setBa(String ba) {
        this.ba = ba;
    }

    public String getTa() {
        return ta;
    }

    public void setTa(String ta) {
        this.ta = ta;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "ba='" + ba + '\'' +
                ", ta='" + ta + '\'' +
                '}';
    }
}
