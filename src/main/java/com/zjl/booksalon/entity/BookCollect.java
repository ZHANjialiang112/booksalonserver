package com.zjl.booksalon.entity;

import java.io.Serializable;

/**
 * book_collect
 *
 * @author
 */
public class BookCollect implements Serializable {
    /**
     * 收藏书籍用户id
     */
    private Integer collUserId;

    /**
     * 书籍id
     */
    private Integer bctBookId;

    /**
     * 书籍文章发布作者id
     */
    private Integer bctUserId;

    private static final long serialVersionUID = 1L;

    public Integer getCollUserId() {
        return collUserId;
    }

    public void setCollUserId(Integer collUserId) {
        this.collUserId = collUserId;
    }

    public Integer getBctBookId() {
        return bctBookId;
    }

    public void setBctBookId(Integer bctBookId) {
        this.bctBookId = bctBookId;
    }

    public Integer getBctUserId() {
        return bctUserId;
    }

    public void setBctUserId(Integer bctUserId) {
        this.bctUserId = bctUserId;
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
        BookCollect other = (BookCollect) that;
        return (this.getCollUserId() == null ? other.getCollUserId() == null : this.getCollUserId().equals(other.getCollUserId()))
                && (this.getBctBookId() == null ? other.getBctBookId() == null : this.getBctBookId().equals(other.getBctBookId()))
                && (this.getBctUserId() == null ? other.getBctUserId() == null : this.getBctUserId().equals(other.getBctUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCollUserId() == null) ? 0 : getCollUserId().hashCode());
        result = prime * result + ((getBctBookId() == null) ? 0 : getBctBookId().hashCode());
        result = prime * result + ((getBctUserId() == null) ? 0 : getBctUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", collUserId=").append(collUserId);
        sb.append(", bctBookId=").append(bctBookId);
        sb.append(", bctUserId=").append(bctUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}