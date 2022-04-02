package com.zjl.booksalon.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * user_info
 *
 * @author
 */
public class UserInfo implements Serializable {
    /**
     * id,自增主键
     */
    private Integer userId;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 用户头像地址
     */
    private String userImgurl;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 文章数量
     */
    private Integer articleNum;

    /**
     * 收藏文章数
     */
    private Integer collectNum;

    /**
     * 用户角色（1:user/2:admin）
     */
    private String roleId;

    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserImgurl() {
        return userImgurl;
    }

    public void setUserImgurl(String userImgurl) {
        this.userImgurl = userImgurl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(userId, userInfo.userId) && Objects.equals(userEmail, userInfo.userEmail) && Objects.equals(userPassword, userInfo.userPassword) && Objects.equals(userImgurl, userInfo.userImgurl) && Objects.equals(createTime, userInfo.createTime) && Objects.equals(updateTime, userInfo.updateTime) && Objects.equals(articleNum, userInfo.articleNum) && Objects.equals(collectNum, userInfo.collectNum) && Objects.equals(roleId, userInfo.roleId) && Objects.equals(nickName, userInfo.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userEmail, userPassword, userImgurl, createTime, updateTime, articleNum, collectNum, roleId, nickName);
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Integer articleNum) {
        this.articleNum = articleNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userImgurl='" + userImgurl + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", articleNum=" + articleNum +
                ", collectNum=" + collectNum +
                ", roleId='" + roleId + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}