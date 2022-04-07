package com.zjl.booksalon.config;

import com.zjl.booksalon.commons.filetr.ShiroFilter;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


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

        //HashMap<String, Filter> filterHashMap = new HashMap<>(16);
        //filterHashMap.put("jwt", new ShiroFilter());

        Map<String, Filter> filterMap = new HashMap<>(16);
        filterMap.put("jwt", new ShiroFilter());
        bean.setFilters(filterMap);
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
        filterChainMap.put("/base", "anon");
        filterChainMap.put("/**", "jwt");
        //普通用户权限
        filterChainMap.put("/user/user", "perms[per:user]");
        //管理员权限
        filterChainMap.put("/user/admin", "perms[per:admin]");

        bean.setFilterChainDefinitionMap(filterChainMap);
        bean.setUnauthorizedUrl("/unauthor");
        bean.setLoginUrl("/toLogin");
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
