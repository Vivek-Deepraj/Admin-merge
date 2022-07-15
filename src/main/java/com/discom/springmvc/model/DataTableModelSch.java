package com.discom.springmvc.model;

import java.util.List;

public class DataTableModelSch {

    int total;
    List<?> pojoClassList;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getPojoClassList() {
        return pojoClassList;
    }

    public void setPojoClassList(List<?> pojoClassList) {
        this.pojoClassList = pojoClassList;
    }

}
