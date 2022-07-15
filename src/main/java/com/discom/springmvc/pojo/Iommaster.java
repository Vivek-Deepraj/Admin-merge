package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "iommaster")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Iommaster.findAll", query = "SELECT a FROM Iommaster a")})

public class Iommaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)

    @Column(name = "id")
    private Long id;
    @Basic(optional = false)


    @Column(name = "iomNumber", length = 255)
    private String iomNumber;

    @Column(name = "sellerPortfolio", length = 255)
    private String sellerPortfolio;

    @Column(name = "buyerPortfolio", length = 255)
    private String buyerPortfolio;

    @Column(name = "quantum", length = 255)
    private String quantum;
    @Column(name = "contractType", length = 255)
    private String contractType;

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
    @Column(name = "fromDate")

    private String fromDate;

    @Column(name = "toDate")

    private String toDate;


    public Iommaster() {
    }

    public Iommaster(Long id) {
        this.id = id;
    }

    public Iommaster(Long id, String iomNumber, Date lastUpdatedOn, Date createdOn) {
        this.id = id;
        this.iomNumber = iomNumber;
        this.lastUpdatedOn = lastUpdatedOn;
        this.createdOn = createdOn;
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

    public String getSellerPortfolio() {
        return sellerPortfolio;
    }

    public void setSellerPortfolio(String sellerPortfolio) {
        this.sellerPortfolio = sellerPortfolio;
    }

    public String getBuyerPortfolio() {
        return buyerPortfolio;
    }

    public void setBuyerPortfolio(String buyerPortfolio) {
        this.buyerPortfolio = buyerPortfolio;
    }

    public String getQuantum() {
        return quantum;
    }

    public void setQuantum(String quantum) {
        this.quantum = quantum;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
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
        if (!(object instanceof Iommaster)) {
            return false;
        }
        Iommaster other = (Iommaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ptc.Iommaster[ id=" + id + " ]";
    }

}
