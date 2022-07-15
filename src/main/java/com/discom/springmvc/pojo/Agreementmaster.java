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
 * @author Bijendra
 */
@Entity
@Table(name = "agreementmaster")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Agreementmaster.findAll", query = "SELECT a FROM Agreementmaster a"),
        @NamedQuery(name = "Agreementmaster.findByAgreementMasterId", query = "SELECT a FROM Agreementmaster a WHERE a.agreementMasterId = :agreementMasterId"),
        @NamedQuery(name = "Agreementmaster.findByStratDate", query = "SELECT a FROM Agreementmaster a WHERE a.stratDate = :stratDate"),
        @NamedQuery(name = "Agreementmaster.findByEndDate", query = "SELECT a FROM Agreementmaster a WHERE a.endDate = :endDate"),
        @NamedQuery(name = "Agreementmaster.findByBuyerportfolio", query = "SELECT a FROM Agreementmaster a WHERE a.buyerportfolio = :buyerportfolio"),
        @NamedQuery(name = "Agreementmaster.findBySellerportfolio", query = "SELECT a FROM Agreementmaster a WHERE a.sellerportfolio = :sellerportfolio"),
        @NamedQuery(name = "Agreementmaster.findByMocSoc", query = "SELECT a FROM Agreementmaster a WHERE a.mocSoc = :mocSoc"),
        @NamedQuery(name = "Agreementmaster.findByStuCharge", query = "SELECT a FROM Agreementmaster a WHERE a.stuCharge = :stuCharge"),
        @NamedQuery(name = "Agreementmaster.findByYtcInvoice", query = "SELECT a FROM Agreementmaster a WHERE a.ytcInvoice = :ytcInvoice"),
        @NamedQuery(name = "Agreementmaster.findByYearlyIncentive", query = "SELECT a FROM Agreementmaster a WHERE a.yearlyIncentive = :yearlyIncentive"),
        @NamedQuery(name = "Agreementmaster.findByFirstRoute", query = "SELECT a FROM Agreementmaster a WHERE a.firstRoute = :firstRoute"),
        @NamedQuery(name = "Agreementmaster.findBySecondRoute", query = "SELECT a FROM Agreementmaster a WHERE a.secondRoute = :secondRoute"),
        @NamedQuery(name = "Agreementmaster.findByThirdRoute", query = "SELECT a FROM Agreementmaster a WHERE a.thirdRoute = :thirdRoute"),
        @NamedQuery(name = "Agreementmaster.findByApplicationNo", query = "SELECT a FROM Agreementmaster a WHERE a.applicationNo = :applicationNo"),
        @NamedQuery(name = "Agreementmaster.findByFileName", query = "SELECT a FROM Agreementmaster a WHERE a.fileName = :fileName"),
        @NamedQuery(name = "Agreementmaster.findByPowerPurchased", query = "SELECT a FROM Agreementmaster a WHERE a.powerPurchased = :powerPurchased"),
        @NamedQuery(name = "Agreementmaster.findByPsaBillingRate", query = "SELECT a FROM Agreementmaster a WHERE a.psaBillingRate = :psaBillingRate"),
        @NamedQuery(name = "Agreementmaster.findByPsaMargin", query = "SELECT a FROM Agreementmaster a WHERE a.psaMargin = :psaMargin"),
        @NamedQuery(name = "Agreementmaster.findByPsaBillingCycle", query = "SELECT a FROM Agreementmaster a WHERE a.psaBillingCycle = :psaBillingCycle"),
        @NamedQuery(name = "Agreementmaster.findBySurchargeRate", query = "SELECT a FROM Agreementmaster a WHERE a.surchargeRate = :surchargeRate"),
        @NamedQuery(name = "Agreementmaster.findByPsaStartDate", query = "SELECT a FROM Agreementmaster a WHERE a.psaStartDate = :psaStartDate"),
        @NamedQuery(name = "Agreementmaster.findByPsaEndDate", query = "SELECT a FROM Agreementmaster a WHERE a.psaEndDate = :psaEndDate"),
        @NamedQuery(name = "Agreementmaster.findByPsaDueDays", query = "SELECT a FROM Agreementmaster a WHERE a.psaDueDays = :psaDueDays"),
        @NamedQuery(name = "Agreementmaster.findByPowerSold", query = "SELECT a FROM Agreementmaster a WHERE a.powerSold = :powerSold"),
        @NamedQuery(name = "Agreementmaster.findByPpaBillingRate", query = "SELECT a FROM Agreementmaster a WHERE a.ppaBillingRate = :ppaBillingRate"),
        @NamedQuery(name = "Agreementmaster.findByPpaMargin", query = "SELECT a FROM Agreementmaster a WHERE a.ppaMargin = :ppaMargin"),
        @NamedQuery(name = "Agreementmaster.findByPpaBillingCycle", query = "SELECT a FROM Agreementmaster a WHERE a.ppaBillingCycle = :ppaBillingCycle"),
        @NamedQuery(name = "Agreementmaster.findByRebateRate", query = "SELECT a FROM Agreementmaster a WHERE a.rebateRate = :rebateRate"),
        @NamedQuery(name = "Agreementmaster.findByPpaStartDate", query = "SELECT a FROM Agreementmaster a WHERE a.ppaStartDate = :ppaStartDate"),
        @NamedQuery(name = "Agreementmaster.findByPpaEndDate", query = "SELECT a FROM Agreementmaster a WHERE a.ppaEndDate = :ppaEndDate"),
        @NamedQuery(name = "Agreementmaster.findByCreatedOn", query = "SELECT a FROM Agreementmaster a WHERE a.createdOn = :createdOn"),
        @NamedQuery(name = "Agreementmaster.findByCreatedBy", query = "SELECT a FROM Agreementmaster a WHERE a.createdBy = :createdBy")})
public class Agreementmaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "agreementMasterId")
    private Long agreementMasterId;
    @Basic(optional = false)
    @Column(name = "stratDate")

    private String stratDate;
    @Basic(optional = false)
    @Column(name = "endDate")

    private String endDate;
    @Basic(optional = false)
    @Column(name = "buyerportfolio")
    private String buyerportfolio;
    @Basic(optional = false)
    @Column(name = "sellerportfolio")
    private String sellerportfolio;
    @Basic(optional = false)
    @Column(name = "mocSoc")
    private String mocSoc;
    @Basic(optional = false)
    @Column(name = "stuCharge")
    private String stuCharge;
    @Basic(optional = false)
    @Column(name = "ytcInvoice")
    private String ytcInvoice;
    @Basic(optional = false)
    @Column(name = "yearlyIncentive")
    private String yearlyIncentive;
    @Basic(optional = false)
    @Column(name = "firstRoute")
    private String firstRoute;
    @Basic(optional = false)
    @Column(name = "secondRoute")
    private String secondRoute;
    @Column(name = "thirdRoute")
    private String thirdRoute;
    @Column(name = "applicationNo")
    private String applicationNo;
    @Column(name = "fileName")
    private String fileName;
    @Basic(optional = false)
    @Column(name = "powerPurchased")
    private String powerPurchased;
    @Basic(optional = false)
    @Column(name = "psaBillingRate")
    private String psaBillingRate;
    @Basic(optional = false)
    @Column(name = "psaMargin")
    private String psaMargin;
    @Basic(optional = false)
    @Column(name = "psaBillingCycle")
    private String psaBillingCycle;
    @Basic(optional = false)
    @Column(name = "surchargeRate")
    private String surchargeRate;
    @Basic(optional = false)
    @Column(name = "psaStartDate")
    private String psaStartDate;
    @Basic(optional = false)
    @Column(name = "psaEndDate")

    private String psaEndDate;
    @Basic(optional = false)
    @Column(name = "psaDueDays")
    private String psaDueDays;
    @Basic(optional = false)
    @Column(name = "powerSold")
    private String powerSold;
    @Basic(optional = false)
    @Column(name = "ppaBillingRate")
    private String ppaBillingRate;
    @Basic(optional = false)
    @Column(name = "ppaMargin")
    private String ppaMargin;
    @Basic(optional = false)
    @Column(name = "ppaBillingCycle")
    private String ppaBillingCycle;
    @Basic(optional = false)
    @Column(name = "rebateRate")
    private String rebateRate;
    @Basic(optional = false)
    @Column(name = "ppaStartDate")

    private String ppaStartDate;
    @Basic(optional = false)
    @Column(name = "ppaEndDate")

    private String ppaEndDate;

    @Basic(optional = false)
    @Column(name = "ppaDueDays")
    private String ppaDueDays;

    @Column(name = "useenclosure")
    private Boolean useenclosure;

    @Column(name = "approvalNo")
    private String approvalNo;
    @Column(name = "contractType")
    private String contractType;
    @Column(name = "transactionType")
    private String transactionType;

    @Column(name = "loiUniqueNo")
    private String loiUniqueNo;

    @Column(name = "iomNumber")
    private int iomNumber;

    @Column(name = "approvedQty")
    private int approvedQty;

    @Column(name = "bullingHead")
    private String bullingHead;

    @Column(name = "deliveryPoint")
    private String deliveryPoint;

    @Column(name = "tarrifAtDeliveryPoint")
    private String tarrifAtDeliveryPoint;

    @Column(name = "provisionalBillingCycle")
    private String provisionalBillingCycle;

    @Column(name = "finalBillingCycle")
    private String finalBillingCycle;

    @Column(name = "margin")
    private String margin;

    @Column(name = "rebate")
    private String rebate;

    @Column(name = "compensationRate")
    private String compensationRate;

    @Column(name = "compensationPercent")
    private String compensationPercent;

    @Column(name = "psappafile")
    private String psappafile;

    @Column(name = "surcharge")
    private String surcharge;
    @Column(name = "enclosure")
    private String enclosure;
    @Column(name = "buyerEnergySource")
    private String buyerEnergySource;
    @Column(name = "ltoano")
    private String ltoano;
    @Column(name = "sellerEnergySource")
    private String sellerEnergySource;
    @Basic(optional = false)
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "created_by")
    private String createdBy;
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
    @Column(name = "parent_agreementmaster_id")
    private Long parentAgreementMasterId;
    @Column(name = "updatedon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedon;
    @Column(name = "updatedby")
    private String updatedby;
    @Transient
    private String expiringdays, iomNo;
    private int contractno;
    private String status;
    public Agreementmaster() {
    }
    public Agreementmaster(Long agreementMasterId) {
        this.agreementMasterId = agreementMasterId;
    }

    public Boolean getUseenclosure() {
        return useenclosure;
    }

    public void setUseenclosure(Boolean useenclosure) {
        this.useenclosure = useenclosure;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public String getPpaDueDays() {
        return ppaDueDays;
    }

    public void setPpaDueDays(String ppaDueDays) {
        this.ppaDueDays = ppaDueDays;
    }

    public String getBuyerEnergySource() {
        return buyerEnergySource;
    }

    public void setBuyerEnergySource(String buyerEnergySource) {
        this.buyerEnergySource = buyerEnergySource;
    }

    public String getSellerEnergySource() {
        return sellerEnergySource;
    }

    public void setSellerEnergySource(String sellerEnergySource) {
        this.sellerEnergySource = sellerEnergySource;
    }

    public String getLtoano() {
        return ltoano;
    }

    public void setLtoano(String ltoano) {
        this.ltoano = ltoano;
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

    public String getExpiringdays() {
        return expiringdays;
    }

    public void setExpiringdays(String expiringdays) {
        this.expiringdays = expiringdays;
    }

    public int getContractno() {
        return contractno;
    }

    public void setContractno(int contractno) {
        this.contractno = contractno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAgreementMasterId() {
        return agreementMasterId;
    }

    public void setAgreementMasterId(Long agreementMasterId) {
        this.agreementMasterId = agreementMasterId;
    }

    public String getStratDate() {
        return stratDate;
    }

    public void setStratDate(String stratDate) {
        this.stratDate = stratDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBuyerportfolio() {
        return buyerportfolio;
    }

    public void setBuyerportfolio(String buyerportfolio) {
        this.buyerportfolio = buyerportfolio;
    }

    public String getSellerportfolio() {
        return sellerportfolio;
    }

    public void setSellerportfolio(String sellerportfolio) {
        this.sellerportfolio = sellerportfolio;
    }

    public String getMocSoc() {
        return mocSoc;
    }

    public void setMocSoc(String mocSoc) {
        this.mocSoc = mocSoc;
    }

    public String getStuCharge() {
        return stuCharge;
    }

    public void setStuCharge(String stuCharge) {
        this.stuCharge = stuCharge;
    }

    public String getYtcInvoice() {
        return ytcInvoice;
    }

    public void setYtcInvoice(String ytcInvoice) {
        this.ytcInvoice = ytcInvoice;
    }

    public String getYearlyIncentive() {
        return yearlyIncentive;
    }

    public void setYearlyIncentive(String yearlyIncentive) {
        this.yearlyIncentive = yearlyIncentive;
    }

    public String getFirstRoute() {
        return firstRoute;
    }

    public void setFirstRoute(String firstRoute) {
        this.firstRoute = firstRoute;
    }

    public String getSecondRoute() {
        return secondRoute;
    }

    public void setSecondRoute(String secondRoute) {
        this.secondRoute = secondRoute;
    }

    public String getThirdRoute() {
        return thirdRoute;
    }

    public void setThirdRoute(String thirdRoute) {
        this.thirdRoute = thirdRoute;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPowerPurchased() {
        return powerPurchased;
    }

    public void setPowerPurchased(String powerPurchased) {
        this.powerPurchased = powerPurchased;
    }

    public String getPsaBillingRate() {
        return psaBillingRate;
    }

    public void setPsaBillingRate(String psaBillingRate) {
        this.psaBillingRate = psaBillingRate;
    }

    public String getPsaMargin() {
        return psaMargin;
    }

    public void setPsaMargin(String psaMargin) {
        this.psaMargin = psaMargin;
    }

    public String getPsaBillingCycle() {
        return psaBillingCycle;
    }

    public void setPsaBillingCycle(String psaBillingCycle) {
        this.psaBillingCycle = psaBillingCycle;
    }

    public String getSurchargeRate() {
        return surchargeRate;
    }

    public void setSurchargeRate(String surchargeRate) {
        this.surchargeRate = surchargeRate;
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

    public String getPsaDueDays() {
        return psaDueDays;
    }

    public void setPsaDueDays(String psaDueDays) {
        this.psaDueDays = psaDueDays;
    }

    public String getPowerSold() {
        return powerSold;
    }

    public void setPowerSold(String powerSold) {
        this.powerSold = powerSold;
    }

    public String getPpaBillingRate() {
        return ppaBillingRate;
    }

    public void setPpaBillingRate(String ppaBillingRate) {
        this.ppaBillingRate = ppaBillingRate;
    }

    public String getPpaMargin() {
        return ppaMargin;
    }

    public void setPpaMargin(String ppaMargin) {
        this.ppaMargin = ppaMargin;
    }

    public String getPpaBillingCycle() {
        return ppaBillingCycle;
    }

    public void setPpaBillingCycle(String ppaBillingCycle) {
        this.ppaBillingCycle = ppaBillingCycle;
    }

    public String getRebateRate() {
        return rebateRate;
    }

    public void setRebateRate(String rebateRate) {
        this.rebateRate = rebateRate;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agreementMasterId != null ? agreementMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agreementmaster)) {
            return false;
        }
        Agreementmaster other = (Agreementmaster) object;
        if ((this.agreementMasterId == null && other.agreementMasterId != null) || (this.agreementMasterId != null && !this.agreementMasterId.equals(other.agreementMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ptc.Agreementmaster[ agreementMasterId=" + agreementMasterId + " ]";
    }

    public String getApprovalNo() {
        return approvalNo;
    }

    public void setApprovalNo(String approvalNo) {
        this.approvalNo = approvalNo;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getLoiUniqueNo() {
        return loiUniqueNo;
    }

    public void setLoiUniqueNo(String loiUniqueNo) {
        this.loiUniqueNo = loiUniqueNo;
    }

    public String getBullingHead() {
        return bullingHead;
    }

    public void setBullingHead(String bullingHead) {
        this.bullingHead = bullingHead;
    }

    public String getDeliveryPoint() {
        return deliveryPoint;
    }

    public void setDeliveryPoint(String deliveryPoint) {
        this.deliveryPoint = deliveryPoint;
    }

    public String getTarrifAtDeliveryPoint() {
        return tarrifAtDeliveryPoint;
    }

    public void setTarrifAtDeliveryPoint(String tarrifAtDeliveryPoint) {
        this.tarrifAtDeliveryPoint = tarrifAtDeliveryPoint;
    }

    public String getProvisionalBillingCycle() {
        return provisionalBillingCycle;
    }

    public void setProvisionalBillingCycle(String provisionalBillingCycle) {
        this.provisionalBillingCycle = provisionalBillingCycle;
    }

    public String getFinalBillingCycle() {
        return finalBillingCycle;
    }

    public void setFinalBillingCycle(String finalBillingCycle) {
        this.finalBillingCycle = finalBillingCycle;
    }

    public String getMargin() {
        return margin;
    }

    public void setMargin(String margin) {
        this.margin = margin;
    }

    public String getRebate() {
        return rebate;
    }

    public void setRebate(String rebate) {
        this.rebate = rebate;
    }

    public String getCompensationRate() {
        return compensationRate;
    }

    public void setCompensationRate(String compensationRate) {
        this.compensationRate = compensationRate;
    }

    public String getCompensationPercent() {
        return compensationPercent;
    }

    public void setCompensationPercent(String compensationPercent) {
        this.compensationPercent = compensationPercent;
    }

    public String getPsappafile() {
        return psappafile;
    }

    public void setPsappafile(String psappafile) {
        this.psappafile = psappafile;
    }

    public String getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(String surcharge) {
        this.surcharge = surcharge;
    }

    public int getApprovedQty() {
        return approvedQty;
    }

    public void setApprovedQty(int approvedQty) {
        this.approvedQty = approvedQty;
    }

    public int getIomNumber() {
        return iomNumber;
    }

    public void setIomNumber(int iomNumber) {
        this.iomNumber = iomNumber;
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

    public String getIomNo() {
        return iomNo;
    }

    public void setIomNo(String iomNo) {
        this.iomNo = iomNo;
    }

    public Long getParentAgreementMasterId() {
        return parentAgreementMasterId;
    }

    public void setParentAgreementMasterId(Long parentAgreementMasterId) {
        this.parentAgreementMasterId = parentAgreementMasterId;
    }

}
