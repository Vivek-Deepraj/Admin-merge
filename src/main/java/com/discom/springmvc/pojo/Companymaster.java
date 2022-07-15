package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;


@Entity

@Table(name = "companymaster")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Companymaster.findAll", query = "SELECT c FROM Companymaster c"),
        @NamedQuery(name = "Companymaster.findByCompanyMasterId", query = "SELECT c FROM Companymaster c WHERE c.companyMasterId = :companyMasterId"),
        @NamedQuery(name = "Companymaster.findByCompanyName", query = "SELECT c FROM Companymaster c WHERE c.companyName = :companyName"),
        @NamedQuery(name = "Companymaster.findByCompanyAddress", query = "SELECT c FROM Companymaster c WHERE c.companyAddress = :companyAddress"),
        @NamedQuery(name = "Companymaster.findByCompanyHO", query = "SELECT c FROM Companymaster c WHERE c.companyHO = :companyHO"),
        @NamedQuery(name = "Companymaster.findByEmailid", query = "SELECT c FROM Companymaster c WHERE c.emailid = :emailid"),
        @NamedQuery(name = "Companymaster.findByRemark", query = "SELECT c FROM Companymaster c WHERE c.remark = :remark"),
        @NamedQuery(name = "Companymaster.findByIsActive", query = "SELECT c FROM Companymaster c WHERE c.isActive = :isActive"),
        @NamedQuery(name = "Companymaster.findByLastUpdatedOn", query = "SELECT c FROM Companymaster c WHERE c.lastUpdatedOn = :lastUpdatedOn"),
        @NamedQuery(name = "Companymaster.findByLastUpdatedBy", query = "SELECT c FROM Companymaster c WHERE c.lastUpdatedBy = :lastUpdatedBy"),
        @NamedQuery(name = "Companymaster.findByCreatedOn", query = "SELECT c FROM Companymaster c WHERE c.createdOn = :createdOn"),
        @NamedQuery(name = "Companymaster.findByCreatedBy", query = "SELECT c FROM Companymaster c WHERE c.createdBy = :createdBy"),
        @NamedQuery(name = "Companymaster.findByJoiningDate", query = "SELECT c FROM Companymaster c WHERE c.joiningDate = :joiningDate")})
public class Companymaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)

    @Column(name = "companyMasterId")
    private Long companyMasterId;
    @Basic(optional = false)


    @Column(name = "companyName", length = 255)
    private String companyName;

    @Column(name = "companyAddress", length = 255)
    private String companyAddress;

    @Column(name = "companyHO", length = 255)
    private String companyHO;


    @Column(name = "zipCode", length = 16777215)
    private String zipCode;


    @Column(name = "phoneno", length = 16777215)
    private String phoneno;


    @Column(name = "mobileno", length = 16777215)
    private String mobileno;


    @Column(name = "faxno1", length = 16777215)
    private String faxno1;

    @Column(name = "faxno2", length = 16777215)
    private String faxno2;

    @Column(name = "emailid", length = 50)
    private String emailid;

    @Column(name = "remark", length = 255)
    private String remark;
    @Column(name = "isActive")
    private Boolean isActive;
    @Basic(optional = false)

    @Column(name = "last_updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedOn;

    @Column(name = "last_updated_by", length = 255)
    private String lastUpdatedBy;
    @Basic(optional = false)

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "created_by", length = 255)
    private String createdBy;
    @Column(name = "joiningDate")

    private String joiningDate;


    public Companymaster() {
    }

    public Companymaster(Long companyMasterId) {
        this.companyMasterId = companyMasterId;
    }

    public Companymaster(Long companyMasterId, String companyName, Date lastUpdatedOn, Date createdOn) {
        this.companyMasterId = companyMasterId;
        this.companyName = companyName;
        this.lastUpdatedOn = lastUpdatedOn;
        this.createdOn = createdOn;
    }

    public Long getCompanyMasterId() {
        return companyMasterId;
    }

    public void setCompanyMasterId(Long companyMasterId) {
        this.companyMasterId = companyMasterId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyHO() {
        System.out.println("out Ho " + companyHO);
        return companyHO;
    }

    public void setCompanyHO(String companyHO) {
        System.out.println("Ho " + companyHO);
        this.companyHO = companyHO;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getFaxno1() {
        return faxno1;
    }

    public void setFaxno1(String faxno1) {
        this.faxno1 = faxno1;
    }

    public String getFaxno2() {
        return faxno2;
    }

    public void setFaxno2(String faxno2) {
        this.faxno2 = faxno2;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
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

    public Date getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(Date lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyMasterId != null ? companyMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Companymaster)) {
            return false;
        }
        Companymaster other = (Companymaster) object;
        if ((this.companyMasterId == null && other.companyMasterId != null) || (this.companyMasterId != null && !this.companyMasterId.equals(other.companyMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ptc.common.pojo.Companymaster[ companyMasterId=" + companyMasterId + " ]";
    }

}
