package com.zjl.booksalon;

import com.zjl.booksalon.commons.utils.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BooksalonApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void passWordMd5() {
        String s = StringUtils.passwordMd5("123456");
        System.out.println(s);
    }
}
