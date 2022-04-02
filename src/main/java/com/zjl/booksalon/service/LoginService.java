package com.zjl.booksalon.service;

import com.zjl.booksalon.commons.result.AjaxResult;
import com.zjl.booksalon.commons.utils.StringUtils;
import com.zjl.booksalon.entity.UserInfo;
import com.zjl.booksalon.mapper.UserInfoMapper;
import com.zjl.booksalon.service.commons.RedisTemplateService;
import com.zjl.booksalon.service.commons.SendMailMessages;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Auther: ZJL
 * @Date: 2022/3/27 15:08
 * @Description:
 */
@Service
public class LoginService {
    private final static String USER_REGISTER = "register";
    private final static String USER_UPDATE = "update";

    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private SendMailMessages sendMailMessages;
    @Resource
    private RedisTemplateService redisService;

    //用户登录
    public AjaxResult login(UserInfo userInfo) {
        UserInfo resultUser = userInfoMapper.selectByUserEmail(userInfo.getUserEmail());
        if (resultUser == null) {
            return AjaxResult.error("该用户还没有注册，请先注册！");
        }
        if (resultUser.getUserPassword().equals(StringUtils.passwordMd5(userInfo.getUserPassword()))) {
            return AjaxResult.success("登录成功，欢迎你~");
        }
        return AjaxResult.error("登录失败，请检查账号和密码~");
    }

    //获取验证码
    public AjaxResult getRegisterCode(UserInfo userInfo, String titleType) {
        UserInfo resultUser = userInfoMapper.selectByUserEmail(userInfo.getUserEmail());
        //注册获取验证码
        if (titleType.equals(USER_REGISTER)) {
            if (resultUser != null) {
                return AjaxResult.error("该邮箱已经注册，请直接登录！");
            }
            sendMailMessages.sendMailHtmlCode(titleType, userInfo.getUserEmail());
            return AjaxResult.success("验证码发送成功");
        }
        //更新获取验证码
        if (titleType.equals(USER_UPDATE)) {
            if (resultUser == null) {
                return AjaxResult.error("该用户还没有注册，请先注册！");
            }
            sendMailMessages.sendMailHtmlCode(titleType, userInfo.getUserEmail());
            return AjaxResult.success("验证码发送成功");
        }
        return AjaxResult.error("获取验证码错误，请重试！");
    }

    //    注册和修改密码操作
    public AjaxResult registerAndUpdate(UserInfo userInfo, String code, String titleType) {
        UserInfo resultUser = userInfoMapper.selectByUserEmail(userInfo.getUserEmail());
        String value = redisService.get(userInfo.getUserEmail());
        //注册验证验证码并保存用户到数据库
        if (titleType.equals(USER_REGISTER)) {
            //if (resultUser != null) {
            //    return AjaxResult.error("该邮箱已经注册，请直接登录！");
            //}
            if (code.equals(value)) {
                userInfo.setUserPassword(StringUtils.passwordMd5(userInfo.getUserPassword()));
                userInfo.setNickName("BS_" + UUID.randomUUID().toString().substring(3, 10));
                userInfoMapper.insertUserInfo(userInfo);
                return AjaxResult.success("注册成功，请登录~");
            } else {
                return AjaxResult.error("注册失败，验证码错误，请重新获取！");
            }
        }
        //更改验证验证码并更新到数据库
        if (titleType.equals(USER_UPDATE)) {
            //if (resultUser == null) {
            //    return AjaxResult.error("该用户还没有注册，请先注册！");
            //}
            if (code.equals(value)) {
                userInfo.setUserPassword(StringUtils.passwordMd5(userInfo.getUserPassword()));
                userInfoMapper.updateByUserEmail(userInfo);
                return AjaxResult.success("密码修改成功，请登录~");
            } else {
                return AjaxResult.error("更改失败，验证码错误，请重新获取！");
            }
        }
        return AjaxResult.error("请输入验证码！");
    }

}
