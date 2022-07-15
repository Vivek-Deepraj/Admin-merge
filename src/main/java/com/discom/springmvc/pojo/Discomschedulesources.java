/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;


/**
 * @author Bijendra
 */
@Entity
@Table(name = "discomschedulesources")
public class Discomschedulesources implements Serializable {
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


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "id")
    private Collection<Discomscheduledetail> discomscheduledetailCollection;
    @JoinColumn(name = "schedule_masterid", referencedColumnName = "schedule_masterid")
    @ManyToOne(optional = false)
    private Discomschedulemaster scheduleMasterid;

    @Transient
    private String totalpower;

    public Discomschedulesources() {
    }

    public Discomschedulesources(Long id) {
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

    @XmlTransient
    public Collection<Discomscheduledetail> getDiscomscheduledetailCollection() {
        return discomscheduledetailCollection;
    }

    public void setDiscomscheduledetailCollection(Collection<Discomscheduledetail> discomscheduledetailCollection) {
        this.discomscheduledetailCollection = discomscheduledetailCollection;
    }

    public Discomschedulemaster getScheduleMasterid() {
        return scheduleMasterid;
    }

    public void setScheduleMasterid(Discomschedulemaster scheduleMasterid) {
        this.scheduleMasterid = scheduleMasterid;
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
        if (!(object instanceof Discomschedulesources)) {
            return false;
        }
        Discomschedulesources other = (Discomschedulesources) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ptc.Discomschedulesources[ id=" + id + " ]";
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

    public String getTotalpower() {
        return totalpower;
    }

    public void setTotalpower(String totalpower) {
        this.totalpower = totalpower;
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


}
