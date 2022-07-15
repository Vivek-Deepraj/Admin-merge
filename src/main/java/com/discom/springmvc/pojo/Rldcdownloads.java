/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


/**
 * @author admin
 */
@Entity
@Table(name = "rldcdownloads")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Rldcdownloads.findAll", query = "SELECT r FROM Rldcdownloads r"),
        @NamedQuery(name = "Rldcdownloads.findByMasterid", query = "SELECT r FROM Rldcdownloads r WHERE r.masterid = :masterid"),
        @NamedQuery(name = "Rldcdownloads.findById", query = "SELECT r FROM Rldcdownloads r WHERE r.id = :id"),
        @NamedQuery(name = "Rldcdownloads.findByRldc", query = "SELECT r FROM Rldcdownloads r WHERE r.rldc = :rldc"),
        @NamedQuery(name = "Rldcdownloads.findByWpdname", query = "SELECT r FROM Rldcdownloads r WHERE r.wpdname = :wpdname"),
        @NamedQuery(name = "Rldcdownloads.findByWpdid", query = "SELECT r FROM Rldcdownloads r WHERE r.wpdid = :wpdid"),
        @NamedQuery(name = "Rldcdownloads.findByScheduledate", query = "SELECT r FROM Rldcdownloads r WHERE r.scheduledate = :scheduledate"),
        @NamedQuery(name = "Rldcdownloads.findByRevno", query = "SELECT r FROM Rldcdownloads r WHERE r.revno = :revno"),
        @NamedQuery(name = "Rldcdownloads.findByFilename", query = "SELECT r FROM Rldcdownloads r WHERE r.filename = :filename"),
        @NamedQuery(name = "Rldcdownloads.findByIsdownloaded", query = "SELECT r FROM Rldcdownloads r WHERE r.isdownloaded = :isdownloaded"),
        @NamedQuery(name = "Rldcdownloads.findByDownloaddate", query = "SELECT r FROM Rldcdownloads r WHERE r.downloaddate = :downloaddate"),
        @NamedQuery(name = "Rldcdownloads.findByDownloadby", query = "SELECT r FROM Rldcdownloads r WHERE r.downloadby = :downloadby")})
public class Rldcdownloads implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "masterid")
    private Long masterid;
    @Basic(optional = false)
    @Column(name = "schedulemasterid")
    private long schedulemasterid;
    @Column(name = "rldc")
    private String rldc;
    @Column(name = "wpdname")
    private String wpdname;
    @Column(name = "wpdid")
    private String wpdid;
    @Column(name = "scheduledate")
    private String scheduledate;
    @Column(name = "revno")
    private Integer revno;
    @Column(name = "filename")
    private String filename;
    @Column(name = "isdownloaded")
    private Boolean isdownloaded;
    @Column(name = "downloaddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date downloaddate;
    @Column(name = "downloadby")
    private String downloadby;
    @Column(name = "rldcrevno")
    private Integer rldcrevno;
    @Column(name = "wpdmasterid")
    private long wpdmasterid;
    @Column(name = "regionfor")
    private String regionfor;
    @Column(name = "rldcscheduledatetime")
    private String rldcscheduledatetime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rldcDownloadMasterid")
    private Collection<Rldcschedulesources> rldcschedulesourcesCollection;

    public Rldcdownloads() {
    }

    public Rldcdownloads(Long masterid) {
        this.masterid = masterid;
    }

    public Long getMasterid() {
        return masterid;
    }

    public void setMasterid(Long masterid) {
        this.masterid = masterid;
    }


    public String getRldc() {
        return rldc;
    }

    public void setRldc(String rldc) {
        this.rldc = rldc;
    }

    public String getWpdname() {
        return wpdname;
    }

    public void setWpdname(String wpdname) {
        this.wpdname = wpdname;
    }

    public String getWpdid() {
        return wpdid;
    }

    public void setWpdid(String wpdid) {
        this.wpdid = wpdid;
    }

    public String getScheduledate() {
        return scheduledate;
    }

    public void setScheduledate(String scheduledate) {
        this.scheduledate = scheduledate;
    }

    public Integer getRevno() {
        return revno;
    }

    public void setRevno(Integer revno) {
        this.revno = revno;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Boolean getIsdownloaded() {
        return isdownloaded;
    }

    public void setIsdownloaded(Boolean isdownloaded) {
        this.isdownloaded = isdownloaded;
    }

    public Date getDownloaddate() {
        return downloaddate;
    }

    public void setDownloaddate(Date downloaddate) {
        this.downloaddate = downloaddate;
    }

    public String getDownloadby() {
        return downloadby;
    }

    public void setDownloadby(String downloadby) {
        this.downloadby = downloadby;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (masterid != null ? masterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rldcdownloads)) {
            return false;
        }
        Rldcdownloads other = (Rldcdownloads) object;
        if ((this.masterid == null && other.masterid != null) || (this.masterid != null && !this.masterid.equals(other.masterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Rldcdownloads[ masterid=" + masterid + " ]";
    }

    public Integer getRldcrevno() {
        return rldcrevno;
    }

    public void setRldcrevno(Integer rldcrevno) {
        this.rldcrevno = rldcrevno;
    }

    public long getSchedulemasterid() {
        return schedulemasterid;
    }

    public void setSchedulemasterid(long schedulemasterid) {
        this.schedulemasterid = schedulemasterid;
    }

    public long getWpdmasterid() {
        return wpdmasterid;
    }

    public void setWpdmasterid(long wpdmasterid) {
        this.wpdmasterid = wpdmasterid;
    }

    public String getRegionfor() {
        return regionfor;
    }

    public void setRegionfor(String regionfor) {
        this.regionfor = regionfor;
    }

    public String getRldcscheduledatetime() {
        return rldcscheduledatetime;
    }

    public void setRldcscheduledatetime(String rldcscheduledatetime) {
        this.rldcscheduledatetime = rldcscheduledatetime;
    }

    public Collection<Rldcschedulesources> getRldcschedulesourcesCollection() {
        return rldcschedulesourcesCollection;
    }

    public void setRldcschedulesourcesCollection(Collection<Rldcschedulesources> rldcschedulesourcesCollection) {
        this.rldcschedulesourcesCollection = rldcschedulesourcesCollection;
    }
}
