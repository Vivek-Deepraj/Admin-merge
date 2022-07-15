package com.discom.springmvc.model;

import java.util.List;

public class DataTableModel {

    int totalCount;
    List<?> entities;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<?> getEntities() {
        return entities;
    }

    public void setEntities(List<?> entities) {
        this.entities = entities;
    }

}
