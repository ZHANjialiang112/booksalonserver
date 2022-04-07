//package com.zjl.booksalon.commons.interceptor;
//
//import com.auth0.jwt.exceptions.AlgorithmMismatchException;
//import com.auth0.jwt.exceptions.SignatureVerificationException;
//import com.auth0.jwt.exceptions.TokenExpiredException;
//import com.zjl.booksalon.commons.utils.JWTUtil;
//import com.zjl.booksalon.service.commons.RedisTemplateService;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Objects;
//
///**
// * @Auther: ZJL
// * @Date: 2022/4/7 11:06
// * @Description:
// */
//@Slf4j
//public class TokenInterceptor implements HandlerInterceptor {
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//   private RedisTemplateService redisTemplateService;
//
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=utf-8");
//        String token = request.getHeader("Token");
//        if (token == null || "".equals(token)) {
//
//            response.getWriter().print("该用户没有登录！");
//            return false;
//        }
//        if (JWTUtil.isNeedUpdate(token)){
//            String newToken = JWTUtil.updateToken(token);
//            response.setHeader("Token",newToken);
//        }
//        Object o = redisTemplateService.get(token);
//        if (Objects.isNull(o)) {
//            response.getWriter().print("token错误！");
//            return false;
//        }
//        try {
//            JWTUtil.verify(token);
//        } catch (SignatureVerificationException e) {
//            logger.error("无效签名！ 错误 ->", e);
//            return false;
//        }
//        catch (TokenExpiredException e) {
//            log.error("token过期！ 错误 ->", e);
//            return false;
//        }
//        catch (AlgorithmMismatchException e) {
//            logger.error("token算法不一致！ 错误 ->", e);
//            return false;
//        } catch (Exception e) {
//            logger.error("token无效！ 错误 ->", e);
//            return false;
//        }
//
//
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }
//}
