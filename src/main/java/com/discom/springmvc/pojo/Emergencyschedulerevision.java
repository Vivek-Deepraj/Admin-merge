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
@Table(name = "emergencyschedulerevision")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Emergencyschedulerevision.findAll", query = "SELECT e FROM Emergencyschedulerevision e"),
        @NamedQuery(name = "Emergencyschedulerevision.findById", query = "SELECT e FROM Emergencyschedulerevision e WHERE e.id = :id"),
        @NamedQuery(name = "Emergencyschedulerevision.findByWpdmasterid", query = "SELECT e FROM Emergencyschedulerevision e WHERE e.wpdmasterid = :wpdmasterid"),
        @NamedQuery(name = "Emergencyschedulerevision.findByRevision", query = "SELECT e FROM Emergencyschedulerevision e WHERE e.revision = :revision"),
        @NamedQuery(name = "Emergencyschedulerevision.findByScheduleDate", query = "SELECT e FROM Emergencyschedulerevision e WHERE e.scheduleDate = :scheduleDate"),
        @NamedQuery(name = "Emergencyschedulerevision.findByCreatedby", query = "SELECT e FROM Emergencyschedulerevision e WHERE e.createdby = :createdby"),
        @NamedQuery(name = "Emergencyschedulerevision.findByUpdatedby", query = "SELECT e FROM Emergencyschedulerevision e WHERE e.updatedby = :updatedby"),
        @NamedQuery(name = "Emergencyschedulerevision.findByCreatedon", query = "SELECT e FROM Emergencyschedulerevision e WHERE e.createdon = :createdon"),
        @NamedQuery(name = "Emergencyschedulerevision.findByUpdatedon", query = "SELECT e FROM Emergencyschedulerevision e WHERE e.updatedon = :updatedon")})
public class Emergencyschedulerevision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "wpdmasterid")
    private long wpdmasterid;
    @Column(name = "revision")
    private String revision;
    @Column(name = "schedule_date")

    private String scheduleDate;
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "updatedby")
    private String updatedby;
    @Column(name = "createdon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;
    @Column(name = "updatedon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedon;
    @Column(name = "ltoano")
    private String ltoano;

    public Emergencyschedulerevision() {
    }

    public Emergencyschedulerevision(Long id) {
        this.id = id;
    }

    public Emergencyschedulerevision(Long id, long wpdmasterid) {
        this.id = id;
        this.wpdmasterid = wpdmasterid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getWpdmasterid() {
        return wpdmasterid;
    }

    public void setWpdmasterid(long wpdmasterid) {
        this.wpdmasterid = wpdmasterid;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public Date getUpdatedon() {
        return updatedon;
    }

    public void setUpdatedon(Date updatedon) {
        this.updatedon = updatedon;
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
        if (!(object instanceof Emergencyschedulerevision)) {
            return false;
        }
        Emergencyschedulerevision other = (Emergencyschedulerevision) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Emergencyschedulerevision[ id=" + id + " ]";
    }

    public String getLtoano() {
        return ltoano;
    }

    public void setLtoano(String ltoano) {
        this.ltoano = ltoano;
    }

}
