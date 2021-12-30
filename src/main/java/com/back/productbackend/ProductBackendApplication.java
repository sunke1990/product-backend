package com.back.productbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author admin
 */
@SpringBootApplication
@MapperScan("com.back.productbackend.db")
public class ProductBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductBackendApplication.class, args);
    }

}
