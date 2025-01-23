package cn.poethan.ezcarcustomer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "cn.poethan.ezcar")
@MapperScan("cn.poethan.ezcar")
@SpringBootApplication
public class EzcarCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EzcarCustomerApplication.class, args);
    }

}
