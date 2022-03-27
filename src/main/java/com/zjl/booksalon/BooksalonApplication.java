package com.zjl.booksalon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zjl.booksalon.mapper")
@SpringBootApplication
public class BooksalonApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksalonApplication.class, args);
    }

}
