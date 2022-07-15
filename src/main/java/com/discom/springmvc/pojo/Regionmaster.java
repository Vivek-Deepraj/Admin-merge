/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * @author Soumya
 */
@Entity
@Table(name = "regionmaster")
public class Regionmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull

    @Column(name = "regionName", nullable = false, length = 255)
    private String regionName;
    @Column(name = "isActive")
    private Boolean isActive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_updated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @Column(name = "last_updated_by", length = 255)
    private String lastUpdatedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_on", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "created_by", length = 255)
    private String createdBy;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "regionMasterId", nullable = false)
    private Long regionMasterId;
    @Column(name = "region", length = 25)
    private String region;

    public Regionmaster() {
    }

    public Regionmaster(Long regionMasterId) {
        this.regionMasterId = regionMasterId;
    }

    public Regionmaster(Long regionMasterId, String regionName, Date lastUpdated, Date createdOn) {
        this.regionMasterId = regionMasterId;
        this.regionName = regionName;
        this.lastUpdated = lastUpdated;
        this.createdOn = createdOn;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
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

    public Long getRegionMasterId() {
        return regionMasterId;
    }

    public void setRegionMasterId(Long regionMasterId) {
        this.regionMasterId = regionMasterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regionMasterId != null ? regionMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regionmaster)) {
            return false;
        }
        Regionmaster other = (Regionmaster) object;
        if ((this.regionMasterId == null && other.regionMasterId != null) || (this.regionMasterId != null && !this.regionMasterId.equals(other.regionMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ptc.common.pojo.Regionmaster[ regionMasterId=" + regionMasterId + " ]";
    }
}
