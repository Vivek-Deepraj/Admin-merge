/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author admin
 */
@Entity
@Table(name = "discomschedulesourcestotal")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Discomschedulesourcestotal.findAll", query = "SELECT d FROM Discomschedulesourcestotal d"),
        @NamedQuery(name = "Discomschedulesourcestotal.findById", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.id = :id"),
        @NamedQuery(name = "Discomschedulesourcestotal.findByScheduleMasterid", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.scheduleMasterid = :scheduleMasterid"),
        @NamedQuery(name = "Discomschedulesourcestotal.findBySource", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.source = :source"),
        @NamedQuery(name = "Discomschedulesourcestotal.findByPower", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.power = :power"),
        @NamedQuery(name = "Discomschedulesourcestotal.findByScheduledate", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.scheduledate = :scheduledate"),
        @NamedQuery(name = "Discomschedulesourcestotal.findByPpadiscomname", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.ppadiscomname = :ppadiscomname"),
        @NamedQuery(name = "Discomschedulesourcestotal.findByPpasourcedest", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.ppasourcedest = :ppasourcedest"),
        @NamedQuery(name = "Discomschedulesourcestotal.findByPparequisition", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.pparequisition = :pparequisition"),
        @NamedQuery(name = "Discomschedulesourcestotal.findByWpdname", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.wpdname = :wpdname"),
        @NamedQuery(name = "Discomschedulesourcestotal.findBySellerportfolio", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.sellerportfolio = :sellerportfolio"),
        @NamedQuery(name = "Discomschedulesourcestotal.findByBuyerportfolio", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.buyerportfolio = :buyerportfolio"),
        @NamedQuery(name = "Discomschedulesourcestotal.findByAgreementSnapshotMasterId", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.agreementSnapshotMasterId = :agreementSnapshotMasterId"),
        @NamedQuery(name = "Discomschedulesourcestotal.findByPsadiscomname", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.psadiscomname = :psadiscomname"),
        @NamedQuery(name = "Discomschedulesourcestotal.findByPsasourcedest", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.psasourcedest = :psasourcedest"),
        @NamedQuery(name = "Discomschedulesourcestotal.findByPsarequisition", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.psarequisition = :psarequisition"),
        @NamedQuery(name = "Discomschedulesourcestotal.findBySellerregion", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.sellerregion = :sellerregion"),
        @NamedQuery(name = "Discomschedulesourcestotal.findByBuyerregion", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.buyerregion = :buyerregion"),
        @NamedQuery(name = "Discomschedulesourcestotal.findByRoute", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.route = :route"),
        @NamedQuery(name = "Discomschedulesourcestotal.findBySendmail", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.sendmail = :sendmail"),
        @NamedQuery(name = "Discomschedulesourcestotal.findByTotal", query = "SELECT d FROM Discomschedulesourcestotal d WHERE d.total = :total")})
public class Discomschedulesourcestotal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "schedule_masterid")
    private long scheduleMasterid;
    @Column(name = "source")
    private String source;
    @Column(name = "power")
    private String power;
    @Column(name = "scheduledate")

    private String scheduledate;
    @Column(name = "ppadiscomname")
    private String ppadiscomname;
    @Column(name = "ppasourcedest")
    private String ppasourcedest;
    @Column(name = "pparequisition")
    private String pparequisition;
    @Column(name = "wpdname")
    private String wpdname;
    @Column(name = "sellerportfolio")
    private String sellerportfolio;
    @Column(name = "buyerportfolio")
    private String buyerportfolio;
    @Column(name = "agreementSnapshotMasterId")
    private String agreementSnapshotMasterId;
    @Column(name = "psadiscomname")
    private String psadiscomname;
    @Column(name = "psasourcedest")
    private String psasourcedest;
    @Column(name = "psarequisition")
    private String psarequisition;
    @Column(name = "sellerregion")
    private String sellerregion;
    @Column(name = "buyerregion")
    private String buyerregion;
    @Column(name = "route")
    private String route;
    @Column(name = "sendmail")
    private Boolean sendmail;
    @Column(name = "total")
    private String total;

    public Discomschedulesourcestotal() {
    }

    public Discomschedulesourcestotal(Long id) {
        this.id = id;
    }

    public Discomschedulesourcestotal(Long id, long scheduleMasterid) {
        this.id = id;
        this.scheduleMasterid = scheduleMasterid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getScheduleMasterid() {
        return scheduleMasterid;
    }

    public void setScheduleMasterid(long scheduleMasterid) {
        this.scheduleMasterid = scheduleMasterid;
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

    public String getWpdname() {
        return wpdname;
    }

    public void setWpdname(String wpdname) {
        this.wpdname = wpdname;
    }

    public String getSellerportfolio() {
        return sellerportfolio;
    }

    public void setSellerportfolio(String sellerportfolio) {
        this.sellerportfolio = sellerportfolio;
    }

    public String getBuyerportfolio() {
        return buyerportfolio;
    }

    public void setBuyerportfolio(String buyerportfolio) {
        this.buyerportfolio = buyerportfolio;
    }

    public String getAgreementSnapshotMasterId() {
        return agreementSnapshotMasterId;
    }

    public void setAgreementSnapshotMasterId(String agreementSnapshotMasterId) {
        this.agreementSnapshotMasterId = agreementSnapshotMasterId;
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

    public String getSellerregion() {
        return sellerregion;
    }

    public void setSellerregion(String sellerregion) {
        this.sellerregion = sellerregion;
    }

    public String getBuyerregion() {
        return buyerregion;
    }

    public void setBuyerregion(String buyerregion) {
        this.buyerregion = buyerregion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discomschedulesourcestotal)) {
            return false;
        }
        Discomschedulesourcestotal other = (Discomschedulesourcestotal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Discomschedulesourcestotal[ id=" + id + " ]";
    }


}
