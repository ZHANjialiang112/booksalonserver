package com.zjl.booksalon.entity;

import java.io.Serializable;

/**
 * book_info
 *
 * @author
 */
public class BookInfoWithBLOBs extends BookInfo implements Serializable {
    /**
     * introduce，书籍介绍
     */
    private String bookIntro;

    /**
     * perception,作者感悟
     */
    private String bookPerce;

    private static final long serialVersionUID = 1L;

    public String getBookIntro() {
        return bookIntro;
    }

    public void setBookIntro(String bookIntro) {
        this.bookIntro = bookIntro;
    }

    public String getBookPerce() {
        return bookPerce;
    }

    public void setBookPerce(String bookPerce) {
        this.bookPerce = bookPerce;
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
        BookInfoWithBLOBs other = (BookInfoWithBLOBs) that;
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
                && (this.getCurrUserCollect() == null ? other.getCurrUserCollect() == null : this.getCurrUserCollect().equals(other.getCurrUserCollect()))
                && (this.getBookIntro() == null ? other.getBookIntro() == null : this.getBookIntro().equals(other.getBookIntro()))
                && (this.getBookPerce() == null ? other.getBookPerce() == null : this.getBookPerce().equals(other.getBookPerce()));
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
        result = prime * result + ((getBookIntro() == null) ? 0 : getBookIntro().hashCode());
        result = prime * result + ((getBookPerce() == null) ? 0 : getBookPerce().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bookIntro=").append(bookIntro);
        sb.append(", bookPerce=").append(bookPerce);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}