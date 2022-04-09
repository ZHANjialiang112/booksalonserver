package com.zjl.booksalon.commons.filetr;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjl.booksalon.commons.result.AjaxResult;
import com.zjl.booksalon.commons.result.HttpStatus;
import com.zjl.booksalon.commons.utils.JWTUtil;
import com.zjl.booksalon.commons.utils.SpringUtils;
import com.zjl.booksalon.commons.utils.StringUtils;
import com.zjl.booksalon.service.commons.RedisTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: ZJL
 * @Date: 2022/4/7 12:03
 * @Description:
 */
@Slf4j
public class ShiroFilter extends BasicHttpAuthenticationFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //这里只有返回false才会执行onAccessDenied方法,因为
        // return super.isAccessAllowed(request, response, mappedValue);
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //获取请求token
        String token = getRequestToken((HttpServletRequest) request);
        String login = ((HttpServletRequest) request).getServletPath();

        RedisTemplateService redisTemplateService = SpringUtils.getBean(RedisTemplateService.class);


        //判断是否是通用的/base请求，不需要拦截
        if (StringUtils.isMatch(login)) {
            logger.info("请求路径为：" + login + "，不需要拦截");
            return true;
        }

        //没有token
        if (StringUtils.isEmpty(token)) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            AjaxResult ajaxResult = AjaxResult.error(HttpStatus.UNAUTHORIZED, "请先登录后再操作！");
            String s = new ObjectMapper().writeValueAsString(ajaxResult);
            response.getWriter().print(s);
            logger.error("请求路径==：" + login + "没有token");
            return false;
        }

        JWTUtil.verify(token);
        //从当前shiro中获得用户信息
        String userEmail = JWTUtil.getUserEmail(token);
        String userToken = redisTemplateService.get(userEmail);
        if (userToken.equals(token)) {
            //TODO 判断token是否需要更新，如果需要就更新（视情况而定）
            //if (JWTUtil.isNeedUpdate(token)) {
            //    String updateToken = JWTUtil.updateToken(token);
            //    redisTemplateService.saveToken(userEmail, updateToken);
            //}
            logger.info("请求路径==：" + login + "通过过滤");
            return true;
        } else {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            AjaxResult ajaxResult = AjaxResult.error(HttpStatus.UNAUTHORIZED, "登录已过期，请重新登录！");
            String s = new ObjectMapper().writeValueAsString(ajaxResult);
            response.getWriter().print(s);
            logger.error("请求路径==：" + login + "无效token");
        }
        return false;
    }

    private String getRequestToken(HttpServletRequest request) {
        //默认从请求头中获得token
        return request.getHeader("Token");
    }

    /**
     * Check if a given log record should be published.
     *
     * @param record a LogRecord
     * @return true if the log record should be published.
     */
}

