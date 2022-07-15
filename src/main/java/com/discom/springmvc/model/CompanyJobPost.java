package com.discom.springmvc.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class CompanyJobPost {

    public Date startDate;
    public Date endDate;
    public List<Map<String, Object>> pojoClassList;
    private Integer id;
    private String com_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Map<String, Object>> getPojoClassList() {
        return pojoClassList;
    }

    public void setPojoClassList(List<Map<String, Object>> pojoClassList) {
        this.pojoClassList = pojoClassList;
    }

}
