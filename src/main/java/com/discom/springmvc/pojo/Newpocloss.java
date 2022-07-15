/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author B51endra.Chauhan
 */
@Entity
@Table(name = "newpocloss")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Newpocloss.findAll", query = "SELECT n FROM Newpocloss n"),
        @NamedQuery(name = "Newpocloss.findByPocLossMasterId", query = "SELECT n FROM Newpocloss n WHERE n.pocLossMasterId = :pocLossMasterId"),
        @NamedQuery(name = "Newpocloss.findByPortfolioId", query = "SELECT n FROM Newpocloss n WHERE n.portfolioId = :portfolioId"),
        @NamedQuery(name = "Newpocloss.findByValidityFromDate", query = "SELECT n FROM Newpocloss n WHERE n.validityFromDate = :validityFromDate"),
        @NamedQuery(name = "Newpocloss.findByValidityToDate", query = "SELECT n FROM Newpocloss n WHERE n.validityToDate = :validityToDate"),
        @NamedQuery(name = "Newpocloss.findByLossType", query = "SELECT n FROM Newpocloss n WHERE n.lossType = :lossType"),
        @NamedQuery(name = "Newpocloss.findByLossValue", query = "SELECT n FROM Newpocloss n WHERE n.lossValue = :lossValue"),
        @NamedQuery(name = "Newpocloss.findByStatus", query = "SELECT n FROM Newpocloss n WHERE n.status = :status"),
        @NamedQuery(name = "Newpocloss.findByFileName", query = "SELECT n FROM Newpocloss n WHERE n.fileName = :fileName"),
        @NamedQuery(name = "Newpocloss.findByUploadedBy", query = "SELECT n FROM Newpocloss n WHERE n.uploadedBy = :uploadedBy"),
        @NamedQuery(name = "Newpocloss.findByCreatedOn", query = "SELECT n FROM Newpocloss n WHERE n.createdOn = :createdOn"),
        @NamedQuery(name = "Newpocloss.findByLossType1", query = "SELECT n FROM Newpocloss n WHERE n.lossType1 = :lossType1"),
        @NamedQuery(name = "Newpocloss.findByIssuedate", query = "SELECT n FROM Newpocloss n WHERE n.issuedate = :issuedate")})
public class Newpocloss implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "pocLossMasterId", nullable = false)
    private Long pocLossMasterId;
    @Size(max = 255)
    @Column(name = "portfolioId", length = 255)
    private String portfolioId;
    @Column(name = "validity_FromDate")

    private String validityFromDate;
    @Column(name = "validity_ToDate")
    private String validityToDate;
    @Size(max = 50)
    @Column(name = "lossType", length = 50)
    private String lossType;
    @Size(max = 50)
    @Column(name = "lossValue", length = 50)
    private String lossValue;
    @Size(max = 50)
    @Column(name = "status", length = 50)
    private String status;
    @Size(max = 100)
    @Column(name = "fileName", length = 100)
    private String fileName;
    @Size(max = 255)
    @Column(name = "uploaded_by", length = 255)
    private String uploadedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_on", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "loss_Type", nullable = false, length = 50)
    private String lossType1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issuedate", nullable = false)

    private String issuedate;

    @Column(name = "lossDataId", nullable = false)
    private Integer lossDataId;

    public Newpocloss() {
    }

    public Newpocloss(Long pocLossMasterId) {
        this.pocLossMasterId = pocLossMasterId;
    }

    public Newpocloss(Long pocLossMasterId, Date createdOn, String lossType1, String issuedate) {
        this.pocLossMasterId = pocLossMasterId;
        this.createdOn = createdOn;
        this.lossType1 = lossType1;
        this.issuedate = issuedate;
    }

    public Long getPocLossMasterId() {
        return pocLossMasterId;
    }

    public void setPocLossMasterId(Long pocLossMasterId) {
        this.pocLossMasterId = pocLossMasterId;
    }

    public String getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getValidityFromDate() {
        return validityFromDate;
    }

    public void setValidityFromDate(String validityFromDate) {
        this.validityFromDate = validityFromDate;
    }

    public String getValidityToDate() {
        return validityToDate;
    }

    public void setValidityToDate(String validityToDate) {
        this.validityToDate = validityToDate;
    }

    public String getLossType() {
        return lossType;
    }

    public void setLossType(String lossType) {
        this.lossType = lossType;
    }

    public String getLossValue() {
        return lossValue;
    }

    public void setLossValue(String lossValue) {
        this.lossValue = lossValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getLossType1() {
        return lossType1;
    }

    public void setLossType1(String lossType1) {
        this.lossType1 = lossType1;
    }

    public String getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pocLossMasterId != null ? pocLossMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Newpocloss)) {
            return false;
        }
        Newpocloss other = (Newpocloss) object;
        if ((this.pocLossMasterId == null && other.pocLossMasterId != null) || (this.pocLossMasterId != null && !this.pocLossMasterId.equals(other.pocLossMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ptc.common.pojo.Newpocloss[ pocLossMasterId=" + pocLossMasterId + " ]";
    }

    public Integer getLossDataId() {
        return lossDataId;
    }

    public void setLossDataId(Integer lossDataId) {
        this.lossDataId = lossDataId;
    }

}
