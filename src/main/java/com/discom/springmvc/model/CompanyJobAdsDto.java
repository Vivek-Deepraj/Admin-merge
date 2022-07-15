package com.discom.springmvc.model;

public class CompanyJobAdsDto {

    private Integer companyId;
    private String jobAdsTemplate;
    private String createdby;
    private Integer jobAdsTemplateId;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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

    public Integer getJobAdsTemplateId() {
        return jobAdsTemplateId;
    }

    public void setJobAdsTemplateId(Integer jobAdsTemplateId) {
        this.jobAdsTemplateId = jobAdsTemplateId;
    }

}
