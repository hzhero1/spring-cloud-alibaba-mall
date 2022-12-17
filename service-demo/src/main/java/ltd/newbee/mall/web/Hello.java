package ltd.newbee.mall.web;

import ltd.newbee.mall.service.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class Hello {

    @Autowired
    HelloServiceImpl helloService;

    @GetMapping("/hello")
    public String hello() {
        return "hello from " + helloService.getName();
    }

}
