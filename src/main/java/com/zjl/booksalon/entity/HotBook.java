package com.zjl.booksalon.entity;

import java.io.Serializable;

/**
 * hot_book
 *
 * @author
 */
public class HotBook implements Serializable {
    /**
     * 记录对应book的id
     */
    private Integer htBookId;

    /**
     * 是否本周最热是否本周最热（0：不是，1：是）
     */
    private String isHot;

    private static final long serialVersionUID = 1L;

    public Integer getHtBookId() {
        return htBookId;
    }

    public void setHtBookId(Integer htBookId) {
        this.htBookId = htBookId;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
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
        HotBook other = (HotBook) that;
        return (this.getHtBookId() == null ? other.getHtBookId() == null : this.getHtBookId().equals(other.getHtBookId()))
                && (this.getIsHot() == null ? other.getIsHot() == null : this.getIsHot().equals(other.getIsHot()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHtBookId() == null) ? 0 : getHtBookId().hashCode());
        result = prime * result + ((getIsHot() == null) ? 0 : getIsHot().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", htBookId=").append(htBookId);
        sb.append(", isHot=").append(isHot);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}