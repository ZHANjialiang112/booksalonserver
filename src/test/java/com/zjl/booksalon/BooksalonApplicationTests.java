package com.zjl.booksalon;

import com.zjl.booksalon.commons.utils.StringUtils;
import com.zjl.booksalon.service.commons.RedisTemplateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BooksalonApplicationTests {

    @Autowired
    private RedisTemplateService redisTemplateService;

    @Test
    void contextLoads() {
    }

    @Test
    public void passWordMd5() {
        String s = StringUtils.passwordMd5("123456");
        System.out.println(s);
    }

    @Test
    public void testRedisCOde() {
        String s = redisTemplateService.get("2655919500@qq.com");
        System.out.println(s == null);
    }
}
