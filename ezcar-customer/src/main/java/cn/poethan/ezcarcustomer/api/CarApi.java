package cn.poethan.ezcarcustomer.api;

import cn.poethan.ezcar.service.impl.CarServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/c")
@RestController
public class CarApi {

    @GetMapping("/get")
    public String get(Long id) {
        return "123";
    }
}
