package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "jobAdsAndJobPostMapping")
@XmlRootElement
public class JobAdsAndJobPostMapping {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "jobads_id")
    private Integer jobadsId;

    @Column(name = "jobpost_id")
    private Integer jobpostId;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJobadsId() {
        return jobadsId;
    }

    public void setJobadsId(Integer jobadsId) {
        this.jobadsId = jobadsId;
    }

    public Integer getJobpostId() {
        return jobpostId;
    }

    public void setJobpostId(Integer jobpostId) {
        this.jobpostId = jobpostId;
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
        if (!(object instanceof JobAdsAndJobPostMapping)) {
            return false;
        }
        JobAdsAndJobPostMapping other = (JobAdsAndJobPostMapping) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.JobAdsAndJobPostMapping[ id=" + id + " ]";
    }


}
