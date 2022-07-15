/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.discom.springmvc.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author bijendra
 */
@Entity
@Table(name = "rldcschedulesources")
@NamedQueries({
        @NamedQuery(name = "Rldcschedulesources.findAll", query = "SELECT r FROM Rldcschedulesources r"),
        @NamedQuery(name = "Rldcschedulesources.findById", query = "SELECT r FROM Rldcschedulesources r WHERE r.id = :id"),
        @NamedQuery(name = "Rldcschedulesources.findBySource", query = "SELECT r FROM Rldcschedulesources r WHERE r.source = :source"),
        @NamedQuery(name = "Rldcschedulesources.findByPower", query = "SELECT r FROM Rldcschedulesources r WHERE r.power = :power"),
        @NamedQuery(name = "Rldcschedulesources.findByScheduledate", query = "SELECT r FROM Rldcschedulesources r WHERE r.scheduledate = :scheduledate"),
        @NamedQuery(name = "Rldcschedulesources.findByApplicantname", query = "SELECT r FROM Rldcschedulesources r WHERE r.applicantname = :applicantname"),
        @NamedQuery(name = "Rldcschedulesources.findByFromState", query = "SELECT r FROM Rldcschedulesources r WHERE r.fromState = :fromState"),
        @NamedQuery(name = "Rldcschedulesources.findByFromUtility", query = "SELECT r FROM Rldcschedulesources r WHERE r.fromUtility = :fromUtility"),
        @NamedQuery(name = "Rldcschedulesources.findByToState", query = "SELECT r FROM Rldcschedulesources r WHERE r.toState = :toState"),
        @NamedQuery(name = "Rldcschedulesources.findByToUtility", query = "SELECT r FROM Rldcschedulesources r WHERE r.toUtility = :toUtility"),
        @NamedQuery(name = "Rldcschedulesources.findByApprovalNo", query = "SELECT r FROM Rldcschedulesources r WHERE r.approvalNo = :approvalNo"),
        @NamedQuery(name = "Rldcschedulesources.findByRoute", query = "SELECT r FROM Rldcschedulesources r WHERE r.route = :route"),
        @NamedQuery(name = "Rldcschedulesources.findBySendmail", query = "SELECT r FROM Rldcschedulesources r WHERE r.sendmail = :sendmail"),
        @NamedQuery(name = "Rldcschedulesources.findByTotal", query = "SELECT r FROM Rldcschedulesources r WHERE r.total = :total")})
public class Rldcschedulesources implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "source")
    private String source;
    @Column(name = "power")
    private String power;
    @Column(name = "revisionno")
    private Integer revisionno;
    @Column(name = "scheduledate")

    private String scheduledate;
    @Column(name = "applicantname")
    private String applicantname;
    @Column(name = "from_state")
    private String fromState;
    @Column(name = "from_utility")
    private String fromUtility;
    @Column(name = "to_state")
    private String toState;
    @Column(name = "to_utility")
    private String toUtility;
    @Column(name = "approval_no")
    private String approvalNo;
    @Column(name = "route")
    private String route;
    @Column(name = "sendmail")
    private Boolean sendmail;
    @Column(name = "total")
    private String total;
    @JoinColumn(name = "rldc_download_masterid", referencedColumnName = "masterid")
    @ManyToOne(optional = false)
    private Rldcdownloads rldcDownloadMasterid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Collection<Rldcscheduledetail> rldcscheduledetailCollection;

    public Rldcschedulesources() {
    }

    public Rldcschedulesources(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getScheduledate() {
        return scheduledate;
    }

    public void setScheduledate(String scheduledate) {
        this.scheduledate = scheduledate;
    }

    public String getApplicantname() {
        return applicantname;
    }

    public void setApplicantname(String applicantname) {
        this.applicantname = applicantname;
    }

    public String getFromState() {
        return fromState;
    }

    public void setFromState(String fromState) {
        this.fromState = fromState;
    }

    public String getFromUtility() {
        return fromUtility;
    }

    public void setFromUtility(String fromUtility) {
        this.fromUtility = fromUtility;
    }

    public String getToState() {
        return toState;
    }

    public void setToState(String toState) {
        this.toState = toState;
    }

    public String getToUtility() {
        return toUtility;
    }

    public void setToUtility(String toUtility) {
        this.toUtility = toUtility;
    }

    public String getApprovalNo() {
        return approvalNo;
    }

    public void setApprovalNo(String approvalNo) {
        this.approvalNo = approvalNo;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Boolean getSendmail() {
        return sendmail;
    }

    public void setSendmail(Boolean sendmail) {
        this.sendmail = sendmail;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Rldcdownloads getRldcDownloadMasterid() {
        return rldcDownloadMasterid;
    }

    public void setRldcDownloadMasterid(Rldcdownloads rldcDownloadMasterid) {
        this.rldcDownloadMasterid = rldcDownloadMasterid;
    }

    public Collection<Rldcscheduledetail> getRldcscheduledetailCollection() {
        return rldcscheduledetailCollection;
    }

    public void setRldcscheduledetailCollection(Collection<Rldcscheduledetail> rldcscheduledetailCollection) {
        this.rldcscheduledetailCollection = rldcscheduledetailCollection;
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
        if (!(object instanceof Rldcschedulesources)) {
            return false;
        }
        Rldcschedulesources other = (Rldcschedulesources) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Rldcschedulesources[ id=" + id + " ]";
    }

    public Integer getRevisionno() {
        return revisionno;
    }

    public void setRevisionno(Integer revisionno) {
        this.revisionno = revisionno;
    }

}
