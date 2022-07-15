package com.discom.springmvc.utils;

import java.util.List;

public class DataTablesTO<T> implements java.io.Serializable {

    private static final long serialVersionUID = -8220588043068200705L;
    private List<T> entities;
    private int sEcho;
    private Integer totalCount;
    private Integer iTotalDisplayRecords;

    public int getsEcho() {
        return sEcho;
    }

    public void setsEcho(int sEcho) {
        this.sEcho = sEcho;
    }

    public Integer getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(Integer iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getEntities() {
        return entities;
    }

    public void setEntities(List<T> entities) {
        this.entities = entities;
    }

}
