package com.zjl.booksalon.config;

import com.zjl.booksalon.commons.result.HttpStatus;
import com.zjl.booksalon.entity.UserInfo;
import com.zjl.booksalon.entity.UserRole;
import com.zjl.booksalon.excption.EventException;
import com.zjl.booksalon.mapper.UserInfoMapper;
import com.zjl.booksalon.service.UserRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wenman
 * @Auther: ZJL
 * @Date: 2021/12/5 15:32
 * @Description:
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * Retrieves the AuthorizationInfo for the given principals from the underlying data store.  When returning
     * an instance from this method, you might want to consider using an instance of
     * {@link SimpleAuthorizationInfo SimpleAuthorizationInfo}, as it is suitable in most cases.
     *
     * @param principals the primary identifying principals of the AuthorizationInfo that should be retrieved.
     * @return the AuthorizationInfo associated with this principals.
     * @see SimpleAuthorizationInfo
     */
//    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //授权操作
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Subject subject = SecurityUtils.getSubject();
        //User user = (User) subject.getPrincipal();
        UserInfo user = (UserInfo) subject.getPrincipal();
        UserRole userRolePermission = userRoleService.getUserRolePermission(user.getUserEmail());
        //List list = userService.queryUserPermissionsList(user.getUsername());
        //subject.getPrincipal();
//        利用user对象，获取user对应的相关权限并加入到授权中
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String next = (String) iterator.next();
//            info.addStringPermission(next);
//        }
        info.addStringPermission(userRolePermission.getPermission());
        info.addStringPermission(userRolePermission.getRole());
        return info;
    }


    /**
     * Retrieves authentication data from an implementation-specific datasource (RDBMS, LDAP, etc) for the given
     * authentication token.
     * <p/>
     * For most datasources, this means just 'pulling' authentication data for an associated subject/user and nothing
     * more and letting Shiro do the rest.  But in some systems, this method could actually perform EIS specific
     * log-in logic in addition to just retrieving data - it is up to the Realm implementation.
     * <p/>
     * A {@code null} return value means that no account could be associated with the specified token.
     *
     * @param token the authentication token containing the user's principal and credentials.
     * @return an {@link AuthenticationInfo} object containing account data resulting from the
     * authentication ONLY if the lookup is successful (i.e. account exists and is valid, etc.)
     * @throws AuthenticationException if there is an error acquiring data or performing
     *                                 realm-specific authentication logic for the specified <tt>token</tt>
     */
//    认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取当前的用户
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
//        封装用户的登录数据
        UserInfo userInfo = userInfoMapper.selectByUserEmail(userToken.getUsername());
        if (userInfo == null) {
            throw new EventException(HttpStatus.BAD_REQUEST, "用户不存在，请确认账号是否正确！");
        } else if (userInfo.getUserPassword().equals(new String(userToken.getPassword()))) {
            throw new EventException(HttpStatus.BAD_REQUEST, "密码不匹配，请确认密码正确！");
        }
        //发送认证信息{principal:要义;credentials:证书;realmName:领域名称}
//        new SimpleAuthenticationInfo(Object principal, Object credentials, String realmName)
//        如果要把对应的用户传到授权的环节，就要在principal上放置user
        return new SimpleAuthenticationInfo(userInfo, userInfo.getUserPassword(), "");
    }
}
