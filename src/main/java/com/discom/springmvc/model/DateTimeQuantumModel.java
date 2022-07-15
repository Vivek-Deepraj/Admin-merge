package com.discom.springmvc.model;

import java.util.List;
import java.util.Map;

public class DateTimeQuantumModel {
    private String id, type;
    private List<Map<String, String>> details;

    public DateTimeQuantumModel() {
        super();

    }

    public DateTimeQuantumModel(String id, String type, List<Map<String, String>> details) {
        super();
        this.id = id;
        this.type = type;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Map<String, String>> getDetails() {
        return details;
    }

    public void setDetails(List<Map<String, String>> details) {
        this.details = details;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
