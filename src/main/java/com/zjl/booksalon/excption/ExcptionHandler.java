package com.zjl.booksalon.excption;

import com.zjl.tokentest.comments.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author wenman
 * @Auther: ZJL
 * @Date: 2021/12/11 14:17
 * @Description:
 */
@ControllerAdvice(basePackages = {"com.zjl.tokentest.controller"})
public class ExcptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public AjaxResult handleExpction(Exception e){
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            return AjaxResult.error(stringWriter.getBuffer().toString());
        } catch (Exception exception) {
            logger.info("打印堆栈异常信息：" + exception.getMessage());
        }
        return AjaxResult.error(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(EventException.class)
    public AjaxResult handlerEventException(EventException e){
        logger.info("打印请求事件出错的信息：" + e.getMsg());
        return AjaxResult.error(e.getCode(), e.getMsg());
    }
}
