package com.zjl.booksalon.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @author wenman
 * @Auther: ZJL
 * @Date: 2021/12/5 15:29
 * @Description:
 */
@Configuration
public class ShiroConfig {
    //配置类的三大属性
    //一、shiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器
        /**
         * anon:无需认证就可访问
         * authc:必须认证了才能访问
         * user：必须拥有，记住我，功能才能使用
         * perms：拥有对某个资源的权限才能访问
         * role：拥有某个角色权限才能访问
         */
        LinkedHashMap<String, String> filterChainMap = new LinkedHashMap<>();
//        filterChainMap.put("/user/add", "authc");
//        filterChainMap.put("/user/update", "authc");
//        可以使用通配符
//        filterChainMap.put("/user/*", "authc");
        filterChainMap.put("/user/admin", "perms[user:admin]");
        filterChainMap.put("/user/add", "perms[user:edit]");
        filterChainMap.put("/user/update", "perms[user:view]");

        bean.setFilterChainDefinitionMap(filterChainMap);
        bean.setLoginUrl("/toLogin");
        //bean.setUnauthorizedUrl("/unauthor");
        return bean;
    }

    //二、DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //三、创建realm 对象，需要自定义类
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }
}
