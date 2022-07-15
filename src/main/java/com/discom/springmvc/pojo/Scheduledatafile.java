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
@Table(name = "scheduledatafile")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Scheduledatafile.findAll", query = "SELECT s FROM Scheduledatafile s"),
        @NamedQuery(name = "Scheduledatafile.findById", query = "SELECT s FROM Scheduledatafile s WHERE s.id = :id"),
        @NamedQuery(name = "Scheduledatafile.findByWpdid", query = "SELECT s FROM Scheduledatafile s WHERE s.wpdid = :wpdid"),
        @NamedQuery(name = "Scheduledatafile.findByScheduleDate", query = "SELECT s FROM Scheduledatafile s WHERE s.scheduleDate = :scheduleDate"),
        @NamedQuery(name = "Scheduledatafile.findByCreatedOn", query = "SELECT s FROM Scheduledatafile s WHERE s.createdOn = :createdOn"),
        @NamedQuery(name = "Scheduledatafile.findByCreatedBy", query = "SELECT s FROM Scheduledatafile s WHERE s.createdBy = :createdBy"),
        @NamedQuery(name = "Scheduledatafile.findByUploadedOn", query = "SELECT s FROM Scheduledatafile s WHERE s.uploadedOn = :uploadedOn"),
        @NamedQuery(name = "Scheduledatafile.findByUploadedBy", query = "SELECT s FROM Scheduledatafile s WHERE s.uploadedBy = :uploadedBy"),
        @NamedQuery(name = "Scheduledatafile.findByFileName", query = "SELECT s FROM Scheduledatafile s WHERE s.fileName = :fileName"),
        @NamedQuery(name = "Scheduledatafile.findByStatus", query = "SELECT s FROM Scheduledatafile s WHERE s.status = :status")})
public class Scheduledatafile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "wpdid")
    private long wpdid;
    @Basic(optional = false)
    @Column(name = "scheduleDate")

    private String scheduleDate;
    @Basic(optional = false)
    @Column(name = "createdOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "createdBy")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "uploadedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadedOn;
    @Column(name = "uploadedBy")
    private String uploadedBy;
    @Column(name = "fileName")
    private String fileName;
    @Column(name = "status")
    private String status;

    public Scheduledatafile() {
    }

    public Scheduledatafile(Long id) {
        this.id = id;
    }

    public Scheduledatafile(Long id, long wpdid, String scheduleDate, Date createdOn, Date uploadedOn) {
        this.id = id;
        this.wpdid = wpdid;
        this.scheduleDate = scheduleDate;
        this.createdOn = createdOn;
        this.uploadedOn = uploadedOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getWpdid() {
        return wpdid;
    }

    public void setWpdid(long wpdid) {
        this.wpdid = wpdid;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
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

    public Date getUploadedOn() {
        return uploadedOn;
    }

    public void setUploadedOn(Date uploadedOn) {
        this.uploadedOn = uploadedOn;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (!(object instanceof Scheduledatafile)) {
            return false;
        }
        Scheduledatafile other = (Scheduledatafile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Scheduledatafile[ id=" + id + " ]";
    }

}
