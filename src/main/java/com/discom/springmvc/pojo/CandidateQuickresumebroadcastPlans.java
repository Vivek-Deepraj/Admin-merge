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
@Table(name = "candidate_quickresumebroadcast_plans")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "CandidateQuickresumebroadcastPlans.findAll", query = "SELECT c FROM CandidateQuickresumebroadcastPlans c"),
        @NamedQuery(name = "CandidateQuickresumebroadcastPlans.findById", query = "SELECT c FROM CandidateQuickresumebroadcastPlans c WHERE c.id = :id"),
        @NamedQuery(name = "CandidateQuickresumebroadcastPlans.findByPlanname", query = "SELECT c FROM CandidateQuickresumebroadcastPlans c WHERE c.planname = :planname"),
        @NamedQuery(name = "CandidateQuickresumebroadcastPlans.findByServicefee", query = "SELECT c FROM CandidateQuickresumebroadcastPlans c WHERE c.servicefee = :servicefee"),
        @NamedQuery(name = "CandidateQuickresumebroadcastPlans.findByProcessingrate", query = "SELECT c FROM CandidateQuickresumebroadcastPlans c WHERE c.processingrate = :processingrate"),
        @NamedQuery(name = "CandidateQuickresumebroadcastPlans.findByCgstrate", query = "SELECT c FROM CandidateQuickresumebroadcastPlans c WHERE c.cgstrate = :cgstrate"),
        @NamedQuery(name = "CandidateQuickresumebroadcastPlans.findBySgstrate", query = "SELECT c FROM CandidateQuickresumebroadcastPlans c WHERE c.sgstrate = :sgstrate"),
        @NamedQuery(name = "CandidateQuickresumebroadcastPlans.findByIgstrate", query = "SELECT c FROM CandidateQuickresumebroadcastPlans c WHERE c.igstrate = :igstrate"),
        @NamedQuery(name = "CandidateQuickresumebroadcastPlans.findByTotal", query = "SELECT c FROM CandidateQuickresumebroadcastPlans c WHERE c.total = :total"),
        @NamedQuery(name = "CandidateQuickresumebroadcastPlans.findByDuration", query = "SELECT c FROM CandidateQuickresumebroadcastPlans c WHERE c.duration = :duration"),
        @NamedQuery(name = "CandidateQuickresumebroadcastPlans.findByCreatedon", query = "SELECT c FROM CandidateQuickresumebroadcastPlans c WHERE c.createdon = :createdon"),
        @NamedQuery(name = "CandidateQuickresumebroadcastPlans.findByCreatedby", query = "SELECT c FROM CandidateQuickresumebroadcastPlans c WHERE c.createdby = :createdby"),
        @NamedQuery(name = "CandidateQuickresumebroadcastPlans.findByUpdatedon", query = "SELECT c FROM CandidateQuickresumebroadcastPlans c WHERE c.updatedon = :updatedon"),
        @NamedQuery(name = "CandidateQuickresumebroadcastPlans.findByUpdatedby", query = "SELECT c FROM CandidateQuickresumebroadcastPlans c WHERE c.updatedby = :updatedby")})
public class CandidateQuickresumebroadcastPlans implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "planname")
    private String planname;
    @Column(name = "servicefee")
    private String servicefee;
    @Column(name = "processingrate")
    private String processingrate;
    @Column(name = "cgstrate")
    private String cgstrate;
    @Column(name = "sgstrate")
    private String sgstrate;
    @Column(name = "igstrate")
    private String igstrate;
    @Column(name = "total")
    private String total;
    @Column(name = "duration")
    private String duration;
    @Basic(optional = false)
    @Column(name = "createdon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;
    @Column(name = "createdby")
    private String createdby;
    @Basic(optional = false)
    @Column(name = "updatedon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedon;
    @Column(name = "updatedby")
    private String updatedby;

    public CandidateQuickresumebroadcastPlans() {
    }

    public CandidateQuickresumebroadcastPlans(Integer id) {
        this.id = id;
    }

    public CandidateQuickresumebroadcastPlans(Integer id, Date createdon, Date updatedon) {
        this.id = id;
        this.createdon = createdon;
        this.updatedon = updatedon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanname() {
        return planname;
    }

    public void setPlanname(String planname) {
        this.planname = planname;
    }

    public String getServicefee() {
        return servicefee;
    }

    public void setServicefee(String servicefee) {
        this.servicefee = servicefee;
    }

    public String getProcessingrate() {
        return processingrate;
    }

    public void setProcessingrate(String processingrate) {
        this.processingrate = processingrate;
    }

    public String getCgstrate() {
        return cgstrate;
    }

    public void setCgstrate(String cgstrate) {
        this.cgstrate = cgstrate;
    }

    public String getSgstrate() {
        return sgstrate;
    }

    public void setSgstrate(String sgstrate) {
        this.sgstrate = sgstrate;
    }

    public String getIgstrate() {
        return igstrate;
    }

    public void setIgstrate(String igstrate) {
        this.igstrate = igstrate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getUpdatedon() {
        return updatedon;
    }

    public void setUpdatedon(Date updatedon) {
        this.updatedon = updatedon;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
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
        if (!(object instanceof CandidateQuickresumebroadcastPlans)) {
            return false;
        }
        CandidateQuickresumebroadcastPlans other = (CandidateQuickresumebroadcastPlans) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.CandidateQuickresumebroadcastPlans[ id=" + id + " ]";
    }

}
