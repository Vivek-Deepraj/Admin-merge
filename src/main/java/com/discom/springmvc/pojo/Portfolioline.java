
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author neha.c
 */
@Entity
@Table(name = "portfolioline")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Portfolioline.findAll", query = "SELECT p FROM Portfolioline p"),
        @NamedQuery(name = "Portfolioline.findByPortfolioLineMasterId", query = "SELECT p FROM Portfolioline p WHERE p.portfolioLineMasterId = :portfolioLineMasterId"),
        @NamedQuery(name = "Portfolioline.findByPortfolioId", query = "SELECT p FROM Portfolioline p WHERE p.portfolioId = :portfolioId"),
        @NamedQuery(name = "Portfolioline.findByLine", query = "SELECT p FROM Portfolioline p WHERE p.line = :line"),
        @NamedQuery(name = "Portfolioline.findByLastUpdated", query = "SELECT p FROM Portfolioline p WHERE p.lastUpdated = :lastUpdated"),
        @NamedQuery(name = "Portfolioline.findByLastUpdatedBy", query = "SELECT p FROM Portfolioline p WHERE p.lastUpdatedBy = :lastUpdatedBy"),
        @NamedQuery(name = "Portfolioline.findByCreatedOn", query = "SELECT p FROM Portfolioline p WHERE p.createdOn = :createdOn"),
        @NamedQuery(name = "Portfolioline.findByCreatedBy", query = "SELECT p FROM Portfolioline p WHERE p.createdBy = :createdBy")})
public class Portfolioline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)

    @Column(name = "portfolioLineMasterId", nullable = false)
    private Long portfolioLineMasterId;

    @Column(name = "portfolioId", length = 255)
    private String portfolioId;

    @Column(name = "line", length = 50)
    private String line;
    @Basic(optional = false)

    @Column(name = "last_updated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @Column(name = "last_updated_by", length = 255)
    private String lastUpdatedBy;
    @Basic(optional = false)

    @Column(name = "created_on", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "created_by", length = 255)
    private String createdBy;

    public Portfolioline() {
    }

    public Portfolioline(Long portfolioLineMasterId) {
        this.portfolioLineMasterId = portfolioLineMasterId;
    }

    public Portfolioline(Long portfolioLineMasterId, Date lastUpdated, Date createdOn) {
        this.portfolioLineMasterId = portfolioLineMasterId;
        this.lastUpdated = lastUpdated;
        this.createdOn = createdOn;
    }

    public Long getPortfolioLineMasterId() {
        return portfolioLineMasterId;
    }

    public void setPortfolioLineMasterId(Long portfolioLineMasterId) {
        this.portfolioLineMasterId = portfolioLineMasterId;
    }

    public String getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
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
        hash += (portfolioLineMasterId != null ? portfolioLineMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Portfolioline)) {
            return false;
        }
        Portfolioline other = (Portfolioline) object;
        if ((this.portfolioLineMasterId == null && other.portfolioLineMasterId != null) || (this.portfolioLineMasterId != null && !this.portfolioLineMasterId.equals(other.portfolioLineMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ptc.common.pojo.Portfolioline[ portfolioLineMasterId=" + portfolioLineMasterId + " ]";
    }

}

