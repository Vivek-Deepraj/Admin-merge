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
@Table(name = "passwordhistorymaster")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Passwordhistorymaster.findAll", query = "SELECT p FROM Passwordhistorymaster p"),
        @NamedQuery(name = "Passwordhistorymaster.findByPassMasterId", query = "SELECT p FROM Passwordhistorymaster p WHERE p.passMasterId = :passMasterId"),
        @NamedQuery(name = "Passwordhistorymaster.findByUserMasterId", query = "SELECT p FROM Passwordhistorymaster p WHERE p.userMasterId = :userMasterId"),
        @NamedQuery(name = "Passwordhistorymaster.findByPassword", query = "SELECT p FROM Passwordhistorymaster p WHERE p.password = :password"),
        @NamedQuery(name = "Passwordhistorymaster.findByIsActive", query = "SELECT p FROM Passwordhistorymaster p WHERE p.isActive = :isActive"),
        @NamedQuery(name = "Passwordhistorymaster.findByLastUpdatedBy", query = "SELECT p FROM Passwordhistorymaster p WHERE p.lastUpdatedBy = :lastUpdatedBy"),
        @NamedQuery(name = "Passwordhistorymaster.findByCreatedOn", query = "SELECT p FROM Passwordhistorymaster p WHERE p.createdOn = :createdOn")})
public class Passwordhistorymaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "passMasterId")
    private Long passMasterId;
    @Basic(optional = false)
    @Column(name = "userMasterId")
    private String userMasterId;
    @Column(name = "password")
    private String password;
    @Column(name = "isActive")
    private Boolean isActive;
    @Column(name = "last_updated_by")
    private String lastUpdatedBy;
    @Basic(optional = false)
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public Passwordhistorymaster() {
    }

    public Passwordhistorymaster(Long passMasterId) {
        this.passMasterId = passMasterId;
    }

    public Passwordhistorymaster(Long passMasterId, String userMasterId, Date createdOn) {
        this.passMasterId = passMasterId;
        this.userMasterId = userMasterId;
        this.createdOn = createdOn;
    }

    public Long getPassMasterId() {
        return passMasterId;
    }

    public void setPassMasterId(Long passMasterId) {
        this.passMasterId = passMasterId;
    }

    public String getUserMasterId() {
        return userMasterId;
    }

    public void setUserMasterId(String userMasterId) {
        this.userMasterId = userMasterId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (passMasterId != null ? passMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passwordhistorymaster)) {
            return false;
        }
        Passwordhistorymaster other = (Passwordhistorymaster) object;
        if ((this.passMasterId == null && other.passMasterId != null) || (this.passMasterId != null && !this.passMasterId.equals(other.passMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Passwordhistorymaster[ passMasterId=" + passMasterId + " ]";
    }

}
