/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author bijendra.chauhan
 */
@Entity
@Table(name = "agreement_details", schema = "")
public class AgreementDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    //@NotNull
    @Column(name = "agreementDetailsId", nullable = false)
    private Long agreementDetailsId;


    @Basic(optional = false)
    @NotNull
    @Column(name = "from_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromTime;

    @Basic(optional = false)
    @NotNull
    @Column(name = "to_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date toTime;


    @Column(name = "isActive")
    private Boolean isActive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_updated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Size(max = 255)
    @Column(name = "last_updated_by", length = 255)
    private String lastUpdatedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_on", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Size(max = 255)
    @Column(name = "created_by", length = 255)
    private String createdBy;
    /*
     * @Column(name = "bidMasterId") private Long bidMasterId;
     */

    @Column(name = "value", precision = 8, scale = 2)
    private Double value;

    @JoinColumn(name = "agreementMasterId", referencedColumnName = "agreementMasterId")
    @ManyToOne(optional = false)
    private Agreementmaster agreementMasterId;

    public AgreementDetails() {
    }

    public AgreementDetails(Long agreementDetailsId) {
        this.agreementDetailsId = agreementDetailsId;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agreementDetailsId != null ? agreementDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgreementDetails)) {
            return false;
        }
        AgreementDetails other = (AgreementDetails) object;
        if ((this.agreementDetailsId == null && other.agreementDetailsId != null) || (this.agreementDetailsId != null && !this.agreementDetailsId.equals(other.agreementDetailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.IomDetails[ agreementDetailsId=" + agreementDetailsId + " ]";
    }


    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Long getAgreementDetailsId() {
        return agreementDetailsId;
    }

    public void setAgreementDetailsId(Long agreementDetailsId) {
        this.agreementDetailsId = agreementDetailsId;
    }

    public Agreementmaster getAgreementMasterId() {
        return agreementMasterId;
    }

    public void setAgreementMasterId(Agreementmaster agreementMasterId) {
        this.agreementMasterId = agreementMasterId;
    }


}
