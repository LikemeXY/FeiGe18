package com.feige;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.feige"})
public class FeigeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeigeApplication.class, args);
    }

}
