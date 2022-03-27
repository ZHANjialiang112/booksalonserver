package com.zjl.booksalon.service;

import com.zjl.booksalon.commons.result.AjaxResult;
import com.zjl.booksalon.commons.utils.StringUtils;
import com.zjl.booksalon.entity.UserInfo;
import com.zjl.booksalon.mapper.UserinfoMapper;
import com.zjl.booksalon.service.commons.SendMailMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: ZJL
 * @Date: 2022/3/27 15:08
 * @Description:
 */
@Service
public class LoginService {

    @Resource
    private UserinfoMapper userinfoMapper;
    @Autowired
    private SendMailMessages sendMailMessages;

    //用户登录
    public AjaxResult login(UserInfo userInfo) {
        UserInfo resultUser = userinfoMapper.queryUserByeMail(userInfo.getEmail());
        if (resultUser == null) {
            return AjaxResult.error("该用户还没有注册，请先注册！");
        }
        if (resultUser.getPassword().equals(StringUtils.passwordMd5(userInfo.getPassword()))) {
            return AjaxResult.success("登录成功，欢迎你~");
        }
        return AjaxResult.error("登录失败，请检查账号和密码~");
    }

    //获取验证码
    public AjaxResult getRegisterCode(UserInfo userInfo) {
        UserInfo resultUser = userinfoMapper.queryUserByeMail(userInfo.getEmail());
        if (resultUser != null) {
            return AjaxResult.error("该邮箱已经注册，请直接登录！");
        }
        sendMailMessages.sendMailHtmlCode(SendMailMessages.MAIL_REGISTER_TYPE, userInfo.getEmail());
        return AjaxResult.success("验证码发送成功");
    }

    //    注册和修改密码操作
    public AjaxResult registerAndUpdate(UserInfo userInfo, String code) {
        //TODO 获取redis验证码进行校验，判断用户是否存在，存在就进行更新操作，不存在就进行注册操作
        return AjaxResult.success();
    }

}
