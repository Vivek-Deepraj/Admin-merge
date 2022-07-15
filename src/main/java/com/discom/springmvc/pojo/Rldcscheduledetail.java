/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.discom.springmvc.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author bijendra
 */
@Entity
@Table(name = "rldcscheduledetail")
@NamedQueries({
        @NamedQuery(name = "Rldcscheduledetail.findAll", query = "SELECT r FROM Rldcscheduledetail r"),
        @NamedQuery(name = "Rldcscheduledetail.findByRldcScheduleId", query = "SELECT r FROM Rldcscheduledetail r WHERE r.rldcScheduleId = :rldcScheduleId"),
        @NamedQuery(name = "Rldcscheduledetail.findByTimeslot", query = "SELECT r FROM Rldcscheduledetail r WHERE r.timeslot = :timeslot"),
        @NamedQuery(name = "Rldcscheduledetail.findByPower", query = "SELECT r FROM Rldcscheduledetail r WHERE r.power = :power"),
        @NamedQuery(name = "Rldcscheduledetail.findByScheduledate", query = "SELECT r FROM Rldcscheduledetail r WHERE r.scheduledate = :scheduledate"),
        @NamedQuery(name = "Rldcscheduledetail.findByDiscompower", query = "SELECT r FROM Rldcscheduledetail r WHERE r.discompower = :discompower"),
        @NamedQuery(name = "Rldcscheduledetail.findByPowerwithoutloss", query = "SELECT r FROM Rldcscheduledetail r WHERE r.powerwithoutloss = :powerwithoutloss"),
        @NamedQuery(name = "Rldcscheduledetail.findByIsupdated", query = "SELECT r FROM Rldcscheduledetail r WHERE r.isupdated = :isupdated")})
public class Rldcscheduledetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rldc_schedule_id")
    private Long rldcScheduleId;
    @Column(name = "timeslot")
    private String timeslot;
    @Column(name = "power")
    private String power;
    @Column(name = "scheduledate")

    private String scheduledate;
    @Column(name = "discompower")
    private String discompower;
    @Column(name = "powerwithoutloss")
    private String powerwithoutloss;
    @Column(name = "isupdated")
    private Boolean isupdated;
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Rldcschedulesources id;

    public Rldcscheduledetail() {
    }

    public Rldcscheduledetail(Long rldcScheduleId) {
        this.rldcScheduleId = rldcScheduleId;
    }

    public Long getRldcScheduleId() {
        return rldcScheduleId;
    }

    public void setRldcScheduleId(Long rldcScheduleId) {
        this.rldcScheduleId = rldcScheduleId;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
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

    public String getDiscompower() {
        return discompower;
    }

    public void setDiscompower(String discompower) {
        this.discompower = discompower;
    }

    public String getPowerwithoutloss() {
        return powerwithoutloss;
    }

    public void setPowerwithoutloss(String powerwithoutloss) {
        this.powerwithoutloss = powerwithoutloss;
    }

    public Boolean getIsupdated() {
        return isupdated;
    }

    public void setIsupdated(Boolean isupdated) {
        this.isupdated = isupdated;
    }

    public Rldcschedulesources getId() {
        return id;
    }

    public void setId(Rldcschedulesources id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rldcScheduleId != null ? rldcScheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rldcscheduledetail)) {
            return false;
        }
        Rldcscheduledetail other = (Rldcscheduledetail) object;
        if ((this.rldcScheduleId == null && other.rldcScheduleId != null) || (this.rldcScheduleId != null && !this.rldcScheduleId.equals(other.rldcScheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Rldcscheduledetail[ rldcScheduleId=" + rldcScheduleId + " ]";
    }

}
