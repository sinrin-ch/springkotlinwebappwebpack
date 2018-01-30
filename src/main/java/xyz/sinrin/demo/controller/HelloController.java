package xyz.sinrin.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.sinrin.demo.entity.TestBean;
import xyz.sinrin.demo.service.TestService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class HelloController {

    @Resource
    private TestService service;

    @RequestMapping("/hello")
    public String hello() {
//        System.out.println(service.getMsg());
        return "hello";
    }

    @RequestMapping("/hello2")
    @ResponseBody
    public List<TestBean> hello2() {
        return service.getBeans();
    }
}
