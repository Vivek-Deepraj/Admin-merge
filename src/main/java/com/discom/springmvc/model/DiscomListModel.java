package com.discom.springmvc.model;

public class DiscomListModel {
    private Long discomMasterId;
    private String discomName;

    public DiscomListModel() {
        super();

    }

    public DiscomListModel(Long discomMasterId, String discomName) {
        super();
        this.discomMasterId = discomMasterId;
        this.discomName = discomName;
    }

    public Long getDiscomMasterId() {
        return discomMasterId;
    }

    public void setDiscomMasterId(Long discomMasterId) {
        this.discomMasterId = discomMasterId;
    }

    public String getDiscomName() {
        return discomName;
    }

    public void setDiscomName(String discomName) {
        this.discomName = discomName;
    }

}
