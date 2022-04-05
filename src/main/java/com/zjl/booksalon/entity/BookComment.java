package com.zjl.booksalon.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * book_comment
 *
 * @author
 */
public class BookComment implements Serializable {
    /**
     * 书籍的id
     */
    private Integer bookId;

    /**
     * 书籍名称
     */
    private String bookName;

    /**
     * 评论者昵称，对应nick_name
     */
    private String commNickName;

    /**
     * 评论提交创建时间
     */
    private Date createTime;

    /**
     * 发表文章作者
     */
    private String nickName;

    /**
     * 评论
     */
    private String comment;

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

    public String getCommNickName() {
        return commNickName;
    }

    public void setCommNickName(String commNickName) {
        this.commNickName = commNickName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        BookComment other = (BookComment) that;
        return (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
                && (this.getBookName() == null ? other.getBookName() == null : this.getBookName().equals(other.getBookName()))
                && (this.getCommNickName() == null ? other.getCommNickName() == null : this.getCommNickName().equals(other.getCommNickName()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
                && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getBookName() == null) ? 0 : getBookName().hashCode());
        result = prime * result + ((getCommNickName() == null) ? 0 : getCommNickName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
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
        sb.append(", commNickName=").append(commNickName);
        sb.append(", createTime=").append(createTime);
        sb.append(", nickName=").append(nickName);
        sb.append(", comment=").append(comment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}