package com.zjl.booksalon.commons.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zjl.booksalon.entity.UserInfo;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

/**
 * @author admin
 */
public class JWTUtil {

    //设置的一个密钥
    private static final String USER_SRCRET = "booksalon";

    public static final Date expireTime() {
        //创建一个日历
        Calendar instance = Calendar.getInstance();
        //默认令牌过期时间8小时
        instance.add(Calendar.HOUR, 12);
        return instance.getTime();
    }

    public static String updateToken(String update) {
        try {
            return JWT.create()
                    .withSubject(update)
                    .withExpiresAt(expireTime())
                    .sign(Algorithm.HMAC256(USER_SRCRET));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取token
     *
     * @param u user
     * @return token
     */
//    public static String getToken(UserDetails u) {
//        //创建一个日历
//        Calendar instance = Calendar.getInstance();
//        //默认令牌过期时间8小时
//        instance.add(Calendar.HOUR, 1);
//
//        //创建JWT并在负载中加入用户id，和电话
//        JWTCreator.Builder builder = JWT.create();
//        builder.withClaim("id", u.getUsername());
//                //.withClaim("phone", u.getAuthorities());
//
//        return builder.withExpiresAt(instance.getTime())
//                .sign(Algorithm.HMAC256(USER_SRCRET));
////        return builder.sign(Algorithm.HMAC256(USER_SRCRET));
//    }

    //shiro
    public static String getToken(UserInfo u) {
        //创建一个日历
        Calendar instance = Calendar.getInstance();
        //默认令牌过期时间8小时
        instance.add(Calendar.HOUR, 12);

        //创建JWT并在负载中加入用户id，和电话
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim("userEmail", u.getUserEmail());

        try {
            return builder.withExpiresAt(instance.getTime())
                    .sign(Algorithm.HMAC256(USER_SRCRET));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
//        return builder.sign(Algorithm.HMAC256(USER_SRCRET));
    }

    /**
     * 验证token合法性 成功返回token
     */
    public static DecodedJWT verify(String token) throws Exception {
        if (token == null) {
            throw new Exception("token不能为空");
        }
        JWTVerifier build = JWT.require(Algorithm.HMAC256(USER_SRCRET)).build();
        return build.verify(token);
    }

    //获取token中的userEmail
    public static String getUserEmail(String token) throws Exception {
        DecodedJWT verify = verify(token);
        return verify.getClaim("userEmail").asString();
    }

    /**
     * 检查token是否需要更新
     *
     * @param token
     * @return
     */
    public static boolean isNeedUpdate(String token) {
        //获取token过期时间
        Date expiresAt = null;
        try {
            expiresAt = JWT.require(Algorithm.HMAC256(USER_SRCRET))
                    .build()
                    .verify(token)
                    .getExpiresAt();
        } catch (TokenExpiredException e) {
            return true;
        } catch (Exception e) {
            throw new RuntimeException("token验证失败");
        }
        //如果剩余过期时间少于过期时常的一般时 需要更新
        return (expiresAt.getTime() - System.currentTimeMillis()) / 1000 / 60 / 60 < 3;

    }


   /* public static void main(String[] args) {
        DecodedJWT verify = verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTcxMDg1MDAsInVzZXJuYW1lIjoiYWRtaW4ifQ.geBEtpluViRUg66_P7ZisN3I_d4e32Wms8mFoBYM5f0");
        System.out.println(verify.getClaim("password").asString());
    }*/
}

