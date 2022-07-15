/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;


/**
 * @author Bijendra
 */
@Entity
@Table(name = "portfoliomaster")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Portfoliomaster.findAll", query = "SELECT p FROM Portfoliomaster p"),
        @NamedQuery(name = "Portfoliomaster.findByPortfolioMasterId", query = "SELECT p FROM Portfoliomaster p WHERE p.portfolioMasterId = :portfolioMasterId"),
        @NamedQuery(name = "Portfoliomaster.findByState", query = "SELECT p FROM Portfoliomaster p WHERE p.state = :state"),
        @NamedQuery(name = "Portfoliomaster.findByRegionCode", query = "SELECT p FROM Portfoliomaster p WHERE p.regionCode = :regionCode"),
        @NamedQuery(name = "Portfoliomaster.findByCompanyName", query = "SELECT p FROM Portfoliomaster p WHERE p.companyName = :companyName"),
        @NamedQuery(name = "Portfoliomaster.findByPortfolioId", query = "SELECT p FROM Portfoliomaster p WHERE p.portfolioId = :portfolioId"),
        @NamedQuery(name = "Portfoliomaster.findByPortfolioName", query = "SELECT p FROM Portfoliomaster p WHERE p.portfolioName = :portfolioName"),
        @NamedQuery(name = "Portfoliomaster.findByJoiningDate", query = "SELECT p FROM Portfoliomaster p WHERE p.joiningDate = :joiningDate"),
        @NamedQuery(name = "Portfoliomaster.findByStatus", query = "SELECT p FROM Portfoliomaster p WHERE p.status = :status"),
        @NamedQuery(name = "Portfoliomaster.findBySldc", query = "SELECT p FROM Portfoliomaster p WHERE p.sldc = :sldc"),
        @NamedQuery(name = "Portfoliomaster.findByBillingContactName", query = "SELECT p FROM Portfoliomaster p WHERE p.billingContactName = :billingContactName"),
        @NamedQuery(name = "Portfoliomaster.findByAddress", query = "SELECT p FROM Portfoliomaster p WHERE p.address = :address"),
        @NamedQuery(name = "Portfoliomaster.findByZipCode", query = "SELECT p FROM Portfoliomaster p WHERE p.zipCode = :zipCode"),
        @NamedQuery(name = "Portfoliomaster.findByOperationAddress", query = "SELECT p FROM Portfoliomaster p WHERE p.operationAddress = :operationAddress"),
        @NamedQuery(name = "Portfoliomaster.findByOperationzipCode", query = "SELECT p FROM Portfoliomaster p WHERE p.operationzipCode = :operationzipCode"),
        @NamedQuery(name = "Portfoliomaster.findByRemark", query = "SELECT p FROM Portfoliomaster p WHERE p.remark = :remark"),
        @NamedQuery(name = "Portfoliomaster.findByIsActive", query = "SELECT p FROM Portfoliomaster p WHERE p.isActive = :isActive"),
        @NamedQuery(name = "Portfoliomaster.findByLastUpdated", query = "SELECT p FROM Portfoliomaster p WHERE p.lastUpdated = :lastUpdated"),
        @NamedQuery(name = "Portfoliomaster.findByLastUpdatedBy", query = "SELECT p FROM Portfoliomaster p WHERE p.lastUpdatedBy = :lastUpdatedBy"),
        @NamedQuery(name = "Portfoliomaster.findByCreatedBy", query = "SELECT p FROM Portfoliomaster p WHERE p.createdBy = :createdBy"),
        @NamedQuery(name = "Portfoliomaster.findByCreatedOn", query = "SELECT p FROM Portfoliomaster p WHERE p.createdOn = :createdOn"),
        @NamedQuery(name = "Portfoliomaster.findByShortName", query = "SELECT p FROM Portfoliomaster p WHERE p.shortName = :shortName"),
        @NamedQuery(name = "Portfoliomaster.findByOperationContactName", query = "SELECT p FROM Portfoliomaster p WHERE p.operationContactName = :operationContactName")})
public class Portfoliomaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "portfolioMasterId", nullable = false)
    private Long portfolioMasterId;
    @Column(name = "state", length = 255)
    private String state;
    @Column(name = "region_code", length = 255)
    private String regionCode;
    @Column(name = "company_name", length = 255)
    private String companyName;
    @Column(name = "portfolioId", length = 255)
    private String portfolioId;
    @Column(name = "portfolioName", length = 255)
    private String portfolioName;
    @Column(name = "stateName", length = 255)
    private String stateName;
    @Column(name = "discom", length = 30)
    private String discom;
    @Column(name = "portfolioType", length = 255)
    private String portfolioType;
    @Column(name = "splitDiscom", length = 255)
    private String splitDiscom;
    @Column(name = "discomName", length = 255)
    private String discomName;
    @Column(name = "joiningDate")

    private String joiningDate;
    @Column(name = "status", length = 255)
    private String status;
    @Column(name = "sldc", length = 255)
    private String sldc;
    @Column(name = "billingContactName", length = 255)
    private String billingContactName;
    @Column(name = "address", length = 255)
    private String address;
    @Column(name = "zipCode", length = 255)
    private String zipCode;
    @Column(name = "operationAddress", length = 255)
    private String operationAddress;
    @Column(name = "operationzipCode", length = 255)
    private String operationzipCode;
    @Column(name = "remark", length = 255)
    private String remark;
    @Column(name = "isActive")
    private Boolean isActive;
    @Basic(optional = false)
    @Column(name = "last_updated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Column(name = "last_updated_by", length = 255)
    private String lastUpdatedBy;
    @Basic(optional = false)
    @Column(name = "created_by", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdBy;
    @Column(name = "created_on", length = 255)
    private String createdOn;
    @Column(name = "shortName", length = 233)
    private String shortName;
    @Column(name = "operationContactName", length = 255)
    private String operationContactName;
    @Column(name = "panNo", length = 20)
    private String panNo;
    @Column(name = "tanNo", length = 20)
    private String tanNo;
    @Column(name = "accountName", length = 255)
    private String accountName;
    @Column(name = "accountNo", length = 50)
    private String accountNo;
    @Column(name = "bankName", length = 255)
    private String bankName;
    @Column(name = "bankIFSC", length = 30)
    private String bankIFSC;
    @Column(name = "perConnection", length = 30)
    private String perConnection;
    @Transient
    private String operationMobile, operationContact, operationEmail, operationFax;
    @Transient
    private String billingMobile, billingContact, billingEmail, billingFax, pointOfConnection;
    @Column(name = "combine")
    private Boolean combine;
    @Column(name = "categoryType")
    private String categoryType;
    public Portfoliomaster() {
    }
    public Portfoliomaster(Long portfolioMasterId) {
        this.portfolioMasterId = portfolioMasterId;
    }
    public Portfoliomaster(Long portfolioMasterId, Date lastUpdated, Date createdBy) {
        this.portfolioMasterId = portfolioMasterId;
        this.lastUpdated = lastUpdated;
        this.createdBy = createdBy;
    }

    public String getPortfolioType() {
        return portfolioType;
    }

    public void setPortfolioType(String portfolioType) {
        this.portfolioType = portfolioType;
    }

    public String getSplitDiscom() {
        return splitDiscom;
    }

    public void setSplitDiscom(String splitDiscom) {
        this.splitDiscom = splitDiscom;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getDiscomName() {
        return discomName;
    }

    public void setDiscomName(String discomName) {
        this.discomName = discomName;
    }

    public Boolean getCombine() {
        return combine;
    }

    public void setCombine(Boolean combine) {
        this.combine = combine;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public Long getPortfolioMasterId() {
        return portfolioMasterId;
    }

    public void setPortfolioMasterId(Long portfolioMasterId) {
        this.portfolioMasterId = portfolioMasterId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSldc() {
        return sldc;
    }

    public void setSldc(String sldc) {
        this.sldc = sldc;
    }

    public String getBillingContactName() {
        return billingContactName;
    }

    public void setBillingContactName(String billingContactName) {
        this.billingContactName = billingContactName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getOperationAddress() {
        return operationAddress;
    }

    public void setOperationAddress(String operationAddress) {
        this.operationAddress = operationAddress;
    }

    public String getOperationzipCode() {
        return operationzipCode;
    }

    public void setOperationzipCode(String operationzipCode) {
        this.operationzipCode = operationzipCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Date createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getOperationContactName() {
        return operationContactName;
    }

    public void setOperationContactName(String operationContactName) {
        this.operationContactName = operationContactName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (portfolioMasterId != null ? portfolioMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Portfoliomaster)) {
            return false;
        }
        Portfoliomaster other = (Portfoliomaster) object;
        if ((this.portfolioMasterId == null && other.portfolioMasterId != null) || (this.portfolioMasterId != null && !this.portfolioMasterId.equals(other.portfolioMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ptc.Portfoliomaster[ portfolioMasterId=" + portfolioMasterId + " ]";
    }


    //	@Override
    public Long getId() {
        // TODO Auto-generated method stub
        return portfolioMasterId;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getTanNo() {
        return tanNo;
    }

    public void setTanNo(String tanNo) {
        this.tanNo = tanNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankIFSC() {
        return bankIFSC;
    }

    public void setBankIFSC(String bankIFSC) {
        this.bankIFSC = bankIFSC;
    }

    public String getOperationMobile() {
        return operationMobile;
    }

    public void setOperationMobile(String operationMobile) {
        this.operationMobile = operationMobile;
    }

    public String getOperationContact() {
        return operationContact;
    }

    public void setOperationContact(String operationContact) {
        this.operationContact = operationContact;
    }

    public String getOperationEmail() {
        return operationEmail;
    }

    public void setOperationEmail(String operationEmail) {
        this.operationEmail = operationEmail;
    }

    public String getOperationFax() {
        return operationFax;
    }

    public void setOperationFax(String operationFax) {
        this.operationFax = operationFax;
    }

    public String getBillingMobile() {
        return billingMobile;
    }

    public void setBillingMobile(String billingMobile) {
        this.billingMobile = billingMobile;
    }

    public String getBillingContact() {
        return billingContact;
    }

    public void setBillingContact(String billingContact) {
        this.billingContact = billingContact;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }

    public String getBillingFax() {
        return billingFax;
    }

    public void setBillingFax(String billingFax) {
        this.billingFax = billingFax;
    }

    public String getPerConnection() {
        return perConnection;
    }

    public void setPerConnection(String perConnection) {
        this.perConnection = perConnection;
    }

    public String getPointOfConnection() {
        return pointOfConnection;
    }

    public void setPointOfConnection(String pointOfConnection) {
        this.pointOfConnection = pointOfConnection;
    }

    public String getDiscom() {
        return discom;
    }

    public void setDiscom(String discom) {
        this.discom = discom;
    }
}
