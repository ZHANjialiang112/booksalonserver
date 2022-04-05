package com.zjl.booksalon.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * book_info
 *
 * @author
 */
public class BookInfo implements Serializable {
    /**
     * id,自增主键
     */
    private Integer bookId;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 书籍图像地址
     */
    private String bookImgurl;

    /**
     * 书籍作者名称
     */
    private String bookAuther;

    /**
     * 被收藏数
     */
    private Integer collectNum;

    /**
     * 上传文章作者
     */
    private String userEmail;

    /**
     * 上传用户昵称
     */
    private String bkNickName;

    /**
     * 是否提交审核，可用于用户已保存，但未提交（0：没有，1：已提交）
     */
    private String isSubmit;

    /**
     * 审核是否通过，审核通过用户可查看（0:没通过，1：通过）
     */
    private String isCheckSucc;

    /**
     * 文章创建时间
     */
    private Date createTime;

    /**
     * 文章更新时间
     */
    private Date updateTime;

    /**
     * 当前用户是否已经收藏
     */
    private String currUserCollect;

    private static final long serialVersionUID = 1L;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookImgurl() {
        return bookImgurl;
    }

    public void setBookImgurl(String bookImgurl) {
        this.bookImgurl = bookImgurl;
    }

    public String getBookAuther() {
        return bookAuther;
    }

    public void setBookAuther(String bookAuther) {
        this.bookAuther = bookAuther;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getBkNickName() {
        return bkNickName;
    }

    public void setBkNickName(String bkNickName) {
        this.bkNickName = bkNickName;
    }

    public String getIsSubmit() {
        return isSubmit;
    }

    public void setIsSubmit(String isSubmit) {
        this.isSubmit = isSubmit;
    }

    public String getIsCheckSucc() {
        return isCheckSucc;
    }

    public void setIsCheckSucc(String isCheckSucc) {
        this.isCheckSucc = isCheckSucc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCurrUserCollect() {
        return currUserCollect;
    }

    public void setCurrUserCollect(String currUserCollect) {
        this.currUserCollect = currUserCollect;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BookInfo other = (BookInfo) that;
        return (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
                && (this.getBookName() == null ? other.getBookName() == null : this.getBookName().equals(other.getBookName()))
                && (this.getBookImgurl() == null ? other.getBookImgurl() == null : this.getBookImgurl().equals(other.getBookImgurl()))
                && (this.getBookAuther() == null ? other.getBookAuther() == null : this.getBookAuther().equals(other.getBookAuther()))
                && (this.getCollectNum() == null ? other.getCollectNum() == null : this.getCollectNum().equals(other.getCollectNum()))
                && (this.getUserEmail() == null ? other.getUserEmail() == null : this.getUserEmail().equals(other.getUserEmail()))
                && (this.getBkNickName() == null ? other.getBkNickName() == null : this.getBkNickName().equals(other.getBkNickName()))
                && (this.getIsSubmit() == null ? other.getIsSubmit() == null : this.getIsSubmit().equals(other.getIsSubmit()))
                && (this.getIsCheckSucc() == null ? other.getIsCheckSucc() == null : this.getIsCheckSucc().equals(other.getIsCheckSucc()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getCurrUserCollect() == null ? other.getCurrUserCollect() == null : this.getCurrUserCollect().equals(other.getCurrUserCollect()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getBookName() == null) ? 0 : getBookName().hashCode());
        result = prime * result + ((getBookImgurl() == null) ? 0 : getBookImgurl().hashCode());
        result = prime * result + ((getBookAuther() == null) ? 0 : getBookAuther().hashCode());
        result = prime * result + ((getCollectNum() == null) ? 0 : getCollectNum().hashCode());
        result = prime * result + ((getUserEmail() == null) ? 0 : getUserEmail().hashCode());
        result = prime * result + ((getBkNickName() == null) ? 0 : getBkNickName().hashCode());
        result = prime * result + ((getIsSubmit() == null) ? 0 : getIsSubmit().hashCode());
        result = prime * result + ((getIsCheckSucc() == null) ? 0 : getIsCheckSucc().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCurrUserCollect() == null) ? 0 : getCurrUserCollect().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bookId=").append(bookId);
        sb.append(", bookName=").append(bookName);
        sb.append(", bookImgurl=").append(bookImgurl);
        sb.append(", bookAuther=").append(bookAuther);
        sb.append(", collectNum=").append(collectNum);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", bkNickName=").append(bkNickName);
        sb.append(", isSubmit=").append(isSubmit);
        sb.append(", isCheckSucc=").append(isCheckSucc);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", currUserCollect=").append(currUserCollect);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}