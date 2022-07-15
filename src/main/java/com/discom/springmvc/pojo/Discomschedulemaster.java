/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


/**
 * @author Bijendra
 */
@Entity
@Table(name = "discomschedulemaster")
public class Discomschedulemaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "schedule_masterid")
    private Long scheduleMasterid;
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Column(name = "schedule_date")

    private String scheduleDate;
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "request_desc")
    private String requestDesc;

    @Column(name = "revisionno")
    private Integer revisionno;
    @Column(name = "sendmail")
    private Boolean sendmail;
    @Column(name = "download")
    private Boolean download;
    @Column(name = "downloadtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date downloadtime;
    @Column(name = "contractdemand")
    private String contractdemand;
    @Column(name = "downloadby")
    private String downloadby;
    @Column(name = "fileName")
    private String fileName;

    @Column(name = "discomdownload")
    private Boolean discomdownload;
    @Column(name = "discomdownloadtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date discomdownloadtime;
    @Column(name = "discomdownloadby")
    private String discomdownloadby;
    @Column(name = "discomcreated")
    private Boolean discomcreated;
    @Column(name = "discomcreatedtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date discomcreatedtime;
    @Column(name = "discomcreatedby")
    private String discomcreatedby;
    @Column(name = "rldcdownload")
    private Boolean rldcdownload;
    @Column(name = "ltoano")
    private String ltoano;
    @Column(name = "savedtill")
    private String savedtill;
    @Column(name = "rldcrevno")
    private String rldcrevno;
    @Column(name = "rldcdatetime")
    private String rldcdatetime;
    @Transient
    private String ltoanodisp;
    @Transient
    private String creationDate, schedulestrdate, schedulestrtime, schedulestrdateandday;
    @Transient
    private String wpdid, wpdname, serialno, discomname, region;
    @Transient
    private Boolean modify;
    @Transient
    private String buyers;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "scheduleMasterid")
    private Collection<Discomschedulesources> discomschedulesourcesCollection;

    public Discomschedulemaster() {
    }

    public Discomschedulemaster(Long scheduleMasterid) {
        this.scheduleMasterid = scheduleMasterid;
    }
    public Discomschedulemaster(Long scheduleMasterid, long id) {
        this.scheduleMasterid = scheduleMasterid;
        this.id = id;
    }

    public String getRldcrevno() {
        return rldcrevno;
    }

    public void setRldcrevno(String rldcrevno) {
        this.rldcrevno = rldcrevno;
    }

    public String getRldcdatetime() {
        return rldcdatetime;
    }

    public void setRldcdatetime(String rldcdatetime) {
        this.rldcdatetime = rldcdatetime;
    }

    public String getSavedtill() {
        return savedtill;
    }

    public void setSavedtill(String savedtill) {
        this.savedtill = savedtill;
    }

    public Long getScheduleMasterid() {
        return scheduleMasterid;
    }

    public void setScheduleMasterid(Long scheduleMasterid) {
        this.scheduleMasterid = scheduleMasterid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLtoanodisp() {
        return ltoanodisp;
    }

    public void setLtoanodisp(String ltoanodisp) {
        this.ltoanodisp = ltoanodisp;
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

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getRequestDesc() {
        return requestDesc;
    }

    public void setRequestDesc(String requestDesc) {
        this.requestDesc = requestDesc;
    }

    @XmlTransient
    public Collection<Discomschedulesources> getDiscomschedulesourcesCollection() {
        return discomschedulesourcesCollection;
    }

    public void setDiscomschedulesourcesCollection(Collection<Discomschedulesources> discomschedulesourcesCollection) {
        this.discomschedulesourcesCollection = discomschedulesourcesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scheduleMasterid != null ? scheduleMasterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discomschedulemaster)) {
            return false;
        }
        Discomschedulemaster other = (Discomschedulemaster) object;
        if ((this.scheduleMasterid == null && other.scheduleMasterid != null) || (this.scheduleMasterid != null && !this.scheduleMasterid.equals(other.scheduleMasterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ptc.Discomschedulemaster[ scheduleMasterid=" + scheduleMasterid + " ]";
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getRevisionno() {
        return revisionno;
    }

    public void setRevisionno(Integer revisionno) {
        this.revisionno = revisionno;
    }

    public Boolean getSendmail() {
        return sendmail;
    }

    public void setSendmail(Boolean sendmail) {
        this.sendmail = sendmail;
    }

    public Boolean getModify() {
        return modify;
    }

    public void setModify(Boolean modify) {
        this.modify = modify;
    }

    public String getSchedulestrdate() {
        return schedulestrdate;
    }

    public void setSchedulestrdate(String schedulestrdate) {
        this.schedulestrdate = schedulestrdate;
    }

    public String getSchedulestrtime() {
        return schedulestrtime;
    }

    public void setSchedulestrtime(String schedulestrtime) {
        this.schedulestrtime = schedulestrtime;
    }

    public String getSchedulestrdateandday() {
        return schedulestrdateandday;
    }

    public void setSchedulestrdateandday(String schedulestrdateandday) {
        this.schedulestrdateandday = schedulestrdateandday;
    }

    public Date getDownloadtime() {
        return downloadtime;
    }

    public void setDownloadtime(Date downloadtime) {
        this.downloadtime = downloadtime;
    }

    public Boolean getDownload() {
        return download;
    }

    public void setDownload(Boolean download) {
        this.download = download;
    }

    public String getWpdid() {
        return wpdid;
    }

    public void setWpdid(String wpdid) {
        this.wpdid = wpdid;
    }

    public String getWpdname() {
        return wpdname;
    }

    public void setWpdname(String wpdname) {
        this.wpdname = wpdname;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getContractdemand() {
        return contractdemand;
    }

    public void setContractdemand(String contractdemand) {
        this.contractdemand = contractdemand;
    }

    public String getDownloadby() {
        return downloadby;
    }

    public void setDownloadby(String downloadby) {
        this.downloadby = downloadby;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Boolean getDiscomdownload() {
        return discomdownload;
    }

    public void setDiscomdownload(Boolean discomdownload) {
        this.discomdownload = discomdownload;
    }

    public Date getDiscomdownloadtime() {
        return discomdownloadtime;
    }

    public void setDiscomdownloadtime(Date discomdownloadtime) {
        this.discomdownloadtime = discomdownloadtime;
    }

    public String getDiscomdownloadby() {
        return discomdownloadby;
    }

    public void setDiscomdownloadby(String discomdownloadby) {
        this.discomdownloadby = discomdownloadby;
    }

    public Boolean getDiscomcreated() {
        return discomcreated;
    }

    public void setDiscomcreated(Boolean discomcreated) {
        this.discomcreated = discomcreated;
    }

    public Date getDiscomcreatedtime() {
        return discomcreatedtime;
    }

    public void setDiscomcreatedtime(Date discomcreatedtime) {
        this.discomcreatedtime = discomcreatedtime;
    }

    public String getDiscomcreatedby() {
        return discomcreatedby;
    }

    public void setDiscomcreatedby(String discomcreatedby) {
        this.discomcreatedby = discomcreatedby;
    }

    public String getDiscomname() {
        return discomname;
    }

    public void setDiscomname(String discomname) {
        this.discomname = discomname;
    }

    public Boolean getRldcdownload() {
        return rldcdownload;
    }

    public void setRldcdownload(Boolean rldcdownload) {
        this.rldcdownload = rldcdownload;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    public String getLtoano() {
        return ltoano;
    }

    public void setLtoano(String ltoano) {
        this.ltoano = ltoano;
    }

    public String getBuyers() {
        return buyers;
    }

    public void setBuyers(String buyers) {
        this.buyers = buyers;
    }

}
