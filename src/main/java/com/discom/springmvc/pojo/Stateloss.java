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
 * @author B51endra.Chauhan
 */
@Entity
@Table(name = "stateloss")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Stateloss.findAll", query = "SELECT s FROM Stateloss s"),
        @NamedQuery(name = "Stateloss.findByStateLossMasterId", query = "SELECT s FROM Stateloss s WHERE s.stateLossMasterId = :stateLossMasterId"),
        @NamedQuery(name = "Stateloss.findByLossType", query = "SELECT s FROM Stateloss s WHERE s.lossType = :lossType"),
        @NamedQuery(name = "Stateloss.findByState", query = "SELECT s FROM Stateloss s WHERE s.state = :state"),
        @NamedQuery(name = "Stateloss.findByLine", query = "SELECT s FROM Stateloss s WHERE s.line = :line"),
        @NamedQuery(name = "Stateloss.findByLossType1", query = "SELECT s FROM Stateloss s WHERE s.lossType1 = :lossType1"),
        @NamedQuery(name = "Stateloss.findByLossValue", query = "SELECT s FROM Stateloss s WHERE s.lossValue = :lossValue"),
        @NamedQuery(name = "Stateloss.findByCreatedOn", query = "SELECT s FROM Stateloss s WHERE s.createdOn = :createdOn"),
        @NamedQuery(name = "Stateloss.findByArchive", query = "SELECT s FROM Stateloss s WHERE s.archive = :archive"),
        @NamedQuery(name = "Stateloss.findByIssuedate", query = "SELECT s FROM Stateloss s WHERE s.issuedate = :issuedate"),
        @NamedQuery(name = "Stateloss.findByPeriodfrom", query = "SELECT s FROM Stateloss s WHERE s.periodfrom = :periodfrom"),
        @NamedQuery(name = "Stateloss.findByPeriodto", query = "SELECT s FROM Stateloss s WHERE s.periodto = :periodto")})
public class Stateloss implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)

    @Column(name = "stateLossMasterId", nullable = false)
    private Long stateLossMasterId;

    @Column(name = "loss_Type", length = 50)
    private String lossType;

    @Column(name = "state", length = 100)
    private String state;

    @Column(name = "line", length = 100)
    private String line;

    @Column(name = "lossType", length = 50)
    private String lossType1;

    @Column(name = "lossValue", length = 100)
    private String lossValue;
    @Column(name = "created_on")

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdOn;

    @Column(name = "archive", length = 255)
    private String archive;
    @Basic(optional = false)

    @Column(name = "issuedate", nullable = false)

    private String issuedate;
    @Basic(optional = false)

    @Column(name = "periodfrom", nullable = false)

    private String periodfrom;


    @Column(name = "periodto", nullable = true)

    private String periodto;
    private String fileName;
    private int revision;
    @Column(name = "lossDataId", nullable = false)
    private Integer lossDataId;

    public Stateloss() {
    }


    public Stateloss(Long stateLossMasterId) {
        this.stateLossMasterId = stateLossMasterId;
    }

    public Stateloss(Long stateLossMasterId, String issuedate, String periodfrom, String periodto) {
        this.stateLossMasterId = stateLossMasterId;
        this.issuedate = issuedate;
        this.periodfrom = periodfrom;
        this.periodto = periodto;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getStateLossMasterId() {
        return stateLossMasterId;
    }

    public void setStateLossMasterId(Long stateLossMasterId) {
        this.stateLossMasterId = stateLossMasterId;
    }

    public String getLossType() {
        return lossType;
    }

    public void setLossType(String lossType) {
        this.lossType = lossType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getLossType1() {
        return lossType1;
    }

    public void setLossType1(String lossType1) {
        this.lossType1 = lossType1;
    }

    public String getLossValue() {
        return lossValue;
    }

    public void setLossValue(String lossValue) {
        this.lossValue = lossValue;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getArchive() {
        return archive;
    }

    public void setArchive(String archive) {
        this.archive = archive;
    }

    public String getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }

    public String getPeriodfrom() {
        return periodfrom;
    }

    public void setPeriodfrom(String periodfrom) {
        this.periodfrom = periodfrom;
    }

    public String getPeriodto() {
        return periodto;
    }

    public void setPeriodto(String periodto) {
        this.periodto = periodto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateLossMasterId != null ? stateLossMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stateloss)) {
            return false;
        }
        Stateloss other = (Stateloss) object;
        if ((this.stateLossMasterId == null && other.stateLossMasterId != null) || (this.stateLossMasterId != null && !this.stateLossMasterId.equals(other.stateLossMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ptc.common.pojo.Stateloss[ stateLossMasterId=" + stateLossMasterId + " ]";
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public Integer getLossDataId() {
        return lossDataId;
    }

    public void setLossDataId(Integer lossDataId) {
        this.lossDataId = lossDataId;
    }

}
