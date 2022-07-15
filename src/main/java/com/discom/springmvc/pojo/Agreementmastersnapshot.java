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
@Table(name = "agreementmastersnapshot")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Agreementmastersnapshot.findAll", query = "SELECT a FROM Agreementmastersnapshot a"),
        @NamedQuery(name = "Agreementmastersnapshot.findByAgreementSnapshotMasterId", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.agreementSnapshotMasterId = :agreementSnapshotMasterId"),
        @NamedQuery(name = "Agreementmastersnapshot.findByAgreementMasterId", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.agreementMasterId = :agreementMasterId"),
        @NamedQuery(name = "Agreementmastersnapshot.findByStartDate", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.startDate = :startDate"),
        @NamedQuery(name = "Agreementmastersnapshot.findByEndDate", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.endDate = :endDate"),
        @NamedQuery(name = "Agreementmastersnapshot.findByApplicationNo", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.applicationNo = :applicationNo"),
        @NamedQuery(name = "Agreementmastersnapshot.findByLtoano", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.ltoano = :ltoano"),
        @NamedQuery(name = "Agreementmastersnapshot.findByMinenergy", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.minenergy = :minenergy"),
        @NamedQuery(name = "Agreementmastersnapshot.findByMaxenergy", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.maxenergy = :maxenergy"),
        @NamedQuery(name = "Agreementmastersnapshot.findByFileName", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.fileName = :fileName"),
        @NamedQuery(name = "Agreementmastersnapshot.findBySellerportfolio", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.sellerportfolio = :sellerportfolio"),
        @NamedQuery(name = "Agreementmastersnapshot.findByPowerSold", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.powerSold = :powerSold"),
        @NamedQuery(name = "Agreementmastersnapshot.findByPpaStartDate", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.ppaStartDate = :ppaStartDate"),
        @NamedQuery(name = "Agreementmastersnapshot.findByPpaEndDate", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.ppaEndDate = :ppaEndDate"),
        @NamedQuery(name = "Agreementmastersnapshot.findByBuyerportfolio", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.buyerportfolio = :buyerportfolio"),
        @NamedQuery(name = "Agreementmastersnapshot.findByPowerPurchased", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.powerPurchased = :powerPurchased"),
        @NamedQuery(name = "Agreementmastersnapshot.findByPsaStartDate", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.psaStartDate = :psaStartDate"),
        @NamedQuery(name = "Agreementmastersnapshot.findByPsaEndDate", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.psaEndDate = :psaEndDate"),
        @NamedQuery(name = "Agreementmastersnapshot.findByCreatedOn", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.createdOn = :createdOn"),
        @NamedQuery(name = "Agreementmastersnapshot.findByCreatedBy", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.createdBy = :createdBy"),
        @NamedQuery(name = "Agreementmastersnapshot.findByUpdatedby", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.updatedby = :updatedby"),
        @NamedQuery(name = "Agreementmastersnapshot.findByUpdatedon", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.updatedon = :updatedon"),
        @NamedQuery(name = "Agreementmastersnapshot.findByStatus", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.status = :status"),
        @NamedQuery(name = "Agreementmastersnapshot.findByContractno", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.contractno = :contractno"),
        @NamedQuery(name = "Agreementmastersnapshot.findByEnclosure", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.enclosure = :enclosure"),
        @NamedQuery(name = "Agreementmastersnapshot.findByPpadiscomname", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.ppadiscomname = :ppadiscomname"),
        @NamedQuery(name = "Agreementmastersnapshot.findByPpasourcedest", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.ppasourcedest = :ppasourcedest"),
        @NamedQuery(name = "Agreementmastersnapshot.findByPparequisition", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.pparequisition = :pparequisition"),
        @NamedQuery(name = "Agreementmastersnapshot.findByPsadiscomname", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.psadiscomname = :psadiscomname"),
        @NamedQuery(name = "Agreementmastersnapshot.findByPsasourcedest", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.psasourcedest = :psasourcedest"),
        @NamedQuery(name = "Agreementmastersnapshot.findByPsarequisition", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.psarequisition = :psarequisition"),
        @NamedQuery(name = "Agreementmastersnapshot.findByRevision", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.revision = :revision"),
        @NamedQuery(name = "Agreementmastersnapshot.findByRevise", query = "SELECT a FROM Agreementmastersnapshot a WHERE a.revise = :revise")})
public class Agreementmastersnapshot implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "agreementSnapshotMasterId")
    private Long agreementSnapshotMasterId;
    @Basic(optional = false)
    @Column(name = "agreementMasterId")
    private long agreementMasterId;
    @Basic(optional = false)
    @Column(name = "startDate")

    private String startDate;
    @Basic(optional = false)
    @Column(name = "endDate")

    private String endDate;
    @Column(name = "applicationNo")
    private String applicationNo;
    @Column(name = "ltoano")
    private String ltoano;
    @Basic(optional = false)
    @Column(name = "minenergy")
    private String minenergy;
    @Basic(optional = false)
    @Column(name = "maxenergy")
    private String maxenergy;
    @Column(name = "fileName")
    private String fileName;
    @Basic(optional = false)
    @Column(name = "sellerportfolio")
    private String sellerportfolio;
    @Basic(optional = false)
    @Column(name = "powerSold")
    private String powerSold;
    @Basic(optional = false)
    @Column(name = "ppaStartDate")

    private String ppaStartDate;
    @Basic(optional = false)
    @Column(name = "ppaEndDate")

    private String ppaEndDate;
    @Basic(optional = false)
    @Column(name = "buyerportfolio")
    private String buyerportfolio;
    @Basic(optional = false)
    @Column(name = "powerPurchased")
    private String powerPurchased;
    @Basic(optional = false)
    @Column(name = "psaStartDate")

    private String psaStartDate;
    @Basic(optional = false)
    @Column(name = "psaEndDate")

    private String psaEndDate;
    @Basic(optional = false)
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updatedby")
    private String updatedby;
    @Column(name = "updatedon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedon;
    @Column(name = "status")
    private String status;
    @Column(name = "contractno")
    private Integer contractno;
    @Column(name = "enclosure")
    private String enclosure;
    @Column(name = "ppadiscomname")
    private String ppadiscomname;
    @Column(name = "ppasourcedest")
    private String ppasourcedest;
    @Column(name = "pparequisition")
    private String pparequisition;
    @Column(name = "psadiscomname")
    private String psadiscomname;
    @Column(name = "psasourcedest")
    private String psasourcedest;
    @Column(name = "psarequisition")
    private String psarequisition;
    @Column(name = "revision")
    private Integer revision;
    @Column(name = "revise")
    private Boolean revise;
    @Column(name = "agreementorder")
    private String agreementorder;
    @Column(name = "setting")
    private String setting;
    @Column(name = "total")
    private Boolean total;
    @Column(name = "proportion")
    private String proportion;
    @Column(name = "rate")
    private String rate;


    /*
     * @JoinColumn(name = "routeId", referencedColumnName = "routeId")
     *
     * @ManyToOne(optional = false) private Powerroute routeId;
     */
    public Agreementmastersnapshot() {
    }

    public Agreementmastersnapshot(Long agreementSnapshotMasterId) {
        this.agreementSnapshotMasterId = agreementSnapshotMasterId;
    }

    public Agreementmastersnapshot(Long agreementSnapshotMasterId, long agreementMasterId, String startDate, String endDate, String minenergy, String maxenergy, String sellerportfolio, String powerSold, String ppaStartDate, String ppaEndDate, String buyerportfolio, String powerPurchased, String psaStartDate, String psaEndDate, Date createdOn) {
        this.agreementSnapshotMasterId = agreementSnapshotMasterId;
        this.agreementMasterId = agreementMasterId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.minenergy = minenergy;
        this.maxenergy = maxenergy;
        this.sellerportfolio = sellerportfolio;
        this.powerSold = powerSold;
        this.ppaStartDate = ppaStartDate;
        this.ppaEndDate = ppaEndDate;
        this.buyerportfolio = buyerportfolio;
        this.powerPurchased = powerPurchased;
        this.psaStartDate = psaStartDate;
        this.psaEndDate = psaEndDate;
        this.createdOn = createdOn;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Long getAgreementSnapshotMasterId() {
        return agreementSnapshotMasterId;
    }

    public void setAgreementSnapshotMasterId(Long agreementSnapshotMasterId) {
        this.agreementSnapshotMasterId = agreementSnapshotMasterId;
    }

    public long getAgreementMasterId() {
        return agreementMasterId;
    }

    public void setAgreementMasterId(long agreementMasterId) {
        this.agreementMasterId = agreementMasterId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getLtoano() {
        return ltoano;
    }

    public void setLtoano(String ltoano) {
        this.ltoano = ltoano;
    }

    public String getMinenergy() {
        return minenergy;
    }

    public void setMinenergy(String minenergy) {
        this.minenergy = minenergy;
    }

    public String getMaxenergy() {
        return maxenergy;
    }

    public void setMaxenergy(String maxenergy) {
        this.maxenergy = maxenergy;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSellerportfolio() {
        return sellerportfolio;
    }

    public void setSellerportfolio(String sellerportfolio) {
        this.sellerportfolio = sellerportfolio;
    }

    public String getPowerSold() {
        return powerSold;
    }

    public void setPowerSold(String powerSold) {
        this.powerSold = powerSold;
    }

    public String getPpaStartDate() {
        return ppaStartDate;
    }

    public void setPpaStartDate(String ppaStartDate) {
        this.ppaStartDate = ppaStartDate;
    }

    public String getPpaEndDate() {
        return ppaEndDate;
    }

    public void setPpaEndDate(String ppaEndDate) {
        this.ppaEndDate = ppaEndDate;
    }

    public String getBuyerportfolio() {
        return buyerportfolio;
    }

    public void setBuyerportfolio(String buyerportfolio) {
        this.buyerportfolio = buyerportfolio;
    }

    public String getPowerPurchased() {
        return powerPurchased;
    }

    public void setPowerPurchased(String powerPurchased) {
        this.powerPurchased = powerPurchased;
    }

    public String getPsaStartDate() {
        return psaStartDate;
    }

    public void setPsaStartDate(String psaStartDate) {
        this.psaStartDate = psaStartDate;
    }

    public String getPsaEndDate() {
        return psaEndDate;
    }

    public void setPsaEndDate(String psaEndDate) {
        this.psaEndDate = psaEndDate;
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

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public Date getUpdatedon() {
        return updatedon;
    }

    public void setUpdatedon(Date updatedon) {
        this.updatedon = updatedon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getContractno() {
        return contractno;
    }

    public void setContractno(Integer contractno) {
        this.contractno = contractno;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public String getPpadiscomname() {
        return ppadiscomname;
    }

    public void setPpadiscomname(String ppadiscomname) {
        this.ppadiscomname = ppadiscomname;
    }

    public String getPpasourcedest() {
        return ppasourcedest;
    }

    public void setPpasourcedest(String ppasourcedest) {
        this.ppasourcedest = ppasourcedest;
    }

    public String getPparequisition() {
        return pparequisition;
    }

    public void setPparequisition(String pparequisition) {
        this.pparequisition = pparequisition;
    }

    public String getPsadiscomname() {
        return psadiscomname;
    }

    public void setPsadiscomname(String psadiscomname) {
        this.psadiscomname = psadiscomname;
    }

    public String getPsasourcedest() {
        return psasourcedest;
    }

    public void setPsasourcedest(String psasourcedest) {
        this.psasourcedest = psasourcedest;
    }

    public String getPsarequisition() {
        return psarequisition;
    }

    public void setPsarequisition(String psarequisition) {
        this.psarequisition = psarequisition;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public Boolean getRevise() {
        return revise;
    }

    public void setRevise(Boolean revise) {
        this.revise = revise;
    }

    /*
     * public Powerroute getRouteId() { return routeId; }
     *
     * public void setRouteId(Powerroute routeId) { this.routeId = routeId; }
     */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agreementSnapshotMasterId != null ? agreementSnapshotMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agreementmastersnapshot)) {
            return false;
        }
        Agreementmastersnapshot other = (Agreementmastersnapshot) object;
        if ((this.agreementSnapshotMasterId == null && other.agreementSnapshotMasterId != null) || (this.agreementSnapshotMasterId != null && !this.agreementSnapshotMasterId.equals(other.agreementSnapshotMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Agreementmastersnapshot[ agreementSnapshotMasterId=" + agreementSnapshotMasterId + " ]";
    }

    public String getAgreementorder() {
        return agreementorder;
    }

    public void setAgreementorder(String agreementorder) {
        this.agreementorder = agreementorder;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public Boolean getTotal() {
        return total;
    }

    public void setTotal(Boolean total) {
        this.total = total;
    }

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

}
