package com.discom.springmvc.model;

import java.util.Date;

public class CompanyJobAdsResponse {

    private Integer id;
    private String companyName;
    private String jobAdsTemplate;
    private String createdby;
    private Date createdon;
    private String updatedby;
    private Date updatedon;
    private boolean isactive;
    private Integer jobAdsTemplateId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobAdsTemplate() {
        return jobAdsTemplate;
    }

    public void setJobAdsTemplate(String jobAdsTemplate) {
        this.jobAdsTemplate = jobAdsTemplate;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public Date getUpdatedon() {
        return updatedon;
    }

    public void setUpdatedon(Date updatedon) {
        this.updatedon = updatedon;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public Integer getJobAdsTemplateId() {
        return jobAdsTemplateId;
    }

    public void setJobAdsTemplateId(Integer jobAdsTemplateId) {
        this.jobAdsTemplateId = jobAdsTemplateId;
    }

}
