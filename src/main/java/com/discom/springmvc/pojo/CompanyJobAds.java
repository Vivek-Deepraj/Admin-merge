package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "companyjobads")
@XmlRootElement
public class CompanyJobAds implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "job_ads_template")
    private String jobAdsTemplate;

    @Column(name = "createdby")
    private String createdby;

    @Column(name = "createdon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;

    @Column(name = "updatedby")
    private String updatedby;

    @Column(name = "updatedon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedon;

    @Column(name = "isactive")
    private boolean isactive;

    @Column(name = "jobads_templateId")
    private Integer jobAdsTemplateId;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyJobAds)) {
            return false;
        }
        CompanyJobAds other = (CompanyJobAds) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.CompanyJobAds[ id=" + id + " ]";
    }

}
