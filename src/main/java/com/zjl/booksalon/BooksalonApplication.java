package com.zjl.booksalon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zjl.booksalon.mapper")
//@Import(SpringUtils.class)//导入自定义的工具类，如果SpringUtils不起作用需要该注解
@SpringBootApplication
public class BooksalonApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksalonApplication.class, args);
    }

}
