/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;


/**
 * @author Soumya
 */
@Entity
@Table(name = "statemaster")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Statemaster.findAll", query = "SELECT s FROM Statemaster s"),
        @NamedQuery(name = "Statemaster.findByStateMasterId", query = "SELECT s FROM Statemaster s WHERE s.stateMasterId = :stateMasterId"),
        @NamedQuery(name = "Statemaster.findByStateName", query = "SELECT s FROM Statemaster s WHERE s.stateName = :stateName"),
        @NamedQuery(name = "Statemaster.findByMainregionName", query = "SELECT s FROM Statemaster s WHERE s.mainregionName = :mainregionName"),
        @NamedQuery(name = "Statemaster.findBySubRegionName", query = "SELECT s FROM Statemaster s WHERE s.subRegionName = :subRegionName"),
        @NamedQuery(name = "Statemaster.findByIsActive", query = "SELECT s FROM Statemaster s WHERE s.isActive = :isActive"),
        @NamedQuery(name = "Statemaster.findByLastUpdated", query = "SELECT s FROM Statemaster s WHERE s.lastUpdated = :lastUpdated"),
        @NamedQuery(name = "Statemaster.findByLastUpdatedBy", query = "SELECT s FROM Statemaster s WHERE s.lastUpdatedBy = :lastUpdatedBy"),
        @NamedQuery(name = "Statemaster.findByCreatedOn", query = "SELECT s FROM Statemaster s WHERE s.createdOn = :createdOn"),
        @NamedQuery(name = "Statemaster.findByCreatedBy", query = "SELECT s FROM Statemaster s WHERE s.createdBy = :createdBy")})
public class Statemaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "stateMasterId", nullable = false)
    private Long stateMasterId;
    @Basic(optional = false)
    @NotNull

    @Column(name = "stateName", nullable = false, length = 255)
    private String stateName;
    @Basic(optional = false)
    @NotNull

    @Column(name = "mainregionName", nullable = false, length = 255)
    private String mainregionName;
    @Basic(optional = false)
    @NotNull

    @Column(name = "subRegionName", nullable = false, length = 255)
    private String subRegionName;
    @Column(name = "region", length = 40)
    private String region;
    @Column(name = "isActive")
    private Boolean isActive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_updated", nullable = false)

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
    public Statemaster() {
    }

    public Statemaster(Long stateMasterId) {
        this.stateMasterId = stateMasterId;
    }

    public Statemaster(Long stateMasterId, String stateName, String mainregionName, String subRegionName, Date lastUpdated, Date createdOn) {
        this.stateMasterId = stateMasterId;
        this.stateName = stateName;
        this.mainregionName = mainregionName;
        this.subRegionName = subRegionName;
        this.lastUpdated = lastUpdated;
        this.createdOn = createdOn;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Long getStateMasterId() {
        return stateMasterId;
    }

    public void setStateMasterId(Long stateMasterId) {
        this.stateMasterId = stateMasterId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getMainregionName() {
        return mainregionName;
    }

    public void setMainregionName(String mainregionName) {
        this.mainregionName = mainregionName;
    }

    public String getSubRegionName() {
        return subRegionName;
    }

    public void setSubRegionName(String subRegionName) {
        this.subRegionName = subRegionName;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateMasterId != null ? stateMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statemaster)) {
            return false;
        }
        Statemaster other = (Statemaster) object;
        if ((this.stateMasterId == null && other.stateMasterId != null) || (this.stateMasterId != null && !this.stateMasterId.equals(other.stateMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ptc.common.pojo.Statemaster[ stateMasterId=" + stateMasterId + " ]";
    }

}

