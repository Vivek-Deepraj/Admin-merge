package com.discom.springmvc.model;

public class IOMListModel {
    private Long id;
    private String iomNumber;

    public IOMListModel(Long id, String iomNumber) {
        super();
        this.id = id;
        this.iomNumber = iomNumber;
    }

    public IOMListModel() {
        super();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIomNumber() {
        return iomNumber;
    }

    public void setIomNumber(String iomNumber) {
        this.iomNumber = iomNumber;
    }

}
