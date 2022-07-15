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
 * @author admin
 */
@Entity
@Table(name = "discommaster")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Discommaster.findAll", query = "SELECT d FROM Discommaster d"),
        @NamedQuery(name = "Discommaster.findByDiscomMasterId", query = "SELECT d FROM Discommaster d WHERE d.discomMasterId = :discomMasterId"),
        @NamedQuery(name = "Discommaster.findByStateName", query = "SELECT d FROM Discommaster d WHERE d.stateName = :stateName"),
        @NamedQuery(name = "Discommaster.findByDiscomName", query = "SELECT d FROM Discommaster d WHERE d.discomName = :discomName"),
        @NamedQuery(name = "Discommaster.findByLine", query = "SELECT d FROM Discommaster d WHERE d.line = :line"),
        @NamedQuery(name = "Discommaster.findByLastUpdated", query = "SELECT d FROM Discommaster d WHERE d.lastUpdated = :lastUpdated"),
        @NamedQuery(name = "Discommaster.findByLastUpdatedBy", query = "SELECT d FROM Discommaster d WHERE d.lastUpdatedBy = :lastUpdatedBy"),
        @NamedQuery(name = "Discommaster.findByCreatedOn", query = "SELECT d FROM Discommaster d WHERE d.createdOn = :createdOn"),
        @NamedQuery(name = "Discommaster.findByCreatedBy", query = "SELECT d FROM Discommaster d WHERE d.createdBy = :createdBy")})
public class Discommaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "discomMasterId")
    private Long discomMasterId;
    @Basic(optional = false)
    @Column(name = "stateName")
    private String stateName;
    @Basic(optional = false)
    @Column(name = "discomName")
    private String discomName;
    @Basic(optional = false)
    @Column(name = "line")
    private String line;
    @Basic(optional = false)
    @Column(name = "last_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Column(name = "last_updated_by")
    private String lastUpdatedBy;
    @Basic(optional = false)
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "created_by")
    private String createdBy;
    @Transient
    private boolean line1, line2, line3, line4, line5, line6, line7, line8, line9;

    public Discommaster() {
    }

    public Discommaster(Long discomMasterId) {
        this.discomMasterId = discomMasterId;
    }

    public Discommaster(Long discomMasterId, String stateName, String discomName, String line, Date lastUpdated, Date createdOn) {
        this.discomMasterId = discomMasterId;
        this.stateName = stateName;
        this.discomName = discomName;
        this.line = line;
        this.lastUpdated = lastUpdated;
        this.createdOn = createdOn;
    }

    public Long getDiscomMasterId() {
        return discomMasterId;
    }

    public void setDiscomMasterId(Long discomMasterId) {
        this.discomMasterId = discomMasterId;
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

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
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
        hash += (discomMasterId != null ? discomMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discommaster)) {
            return false;
        }
        Discommaster other = (Discommaster) object;
        if ((this.discomMasterId == null && other.discomMasterId != null) || (this.discomMasterId != null && !this.discomMasterId.equals(other.discomMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ptc.common.pojo.Discommaster[ discomMasterId=" + discomMasterId + " ]";
    }

    public boolean isLine1() {
        return line1;
    }

    public void setLine1(boolean line1) {
        this.line1 = line1;
    }

    public boolean isLine2() {
        return line2;
    }

    public void setLine2(boolean line2) {
        this.line2 = line2;
    }

    public boolean isLine3() {
        return line3;
    }

    public void setLine3(boolean line3) {
        this.line3 = line3;
    }

    public boolean isLine4() {
        return line4;
    }

    public void setLine4(boolean line4) {
        this.line4 = line4;
    }

    public boolean isLine5() {
        return line5;
    }

    public void setLine5(boolean line5) {
        this.line5 = line5;
    }

    public boolean isLine6() {
        return line6;
    }

    public void setLine6(boolean line6) {
        this.line6 = line6;
    }

    public boolean isLine7() {
        return line7;
    }

    public void setLine7(boolean line7) {
        this.line7 = line7;
    }

    public boolean isLine8() {
        return line8;
    }

    public void setLine8(boolean line8) {
        this.line8 = line8;
    }

    public boolean isLine9() {
        return line9;
    }

    public void setLine9(boolean line9) {
        this.line9 = line9;
    }

}
