/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Bijendra
 */
@Entity
@Table(name = "discomscheduledetail")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Discomscheduledetail.findAll", query = "SELECT d FROM Discomscheduledetail d"),
        @NamedQuery(name = "Discomscheduledetail.findByDiscomScheduleId", query = "SELECT d FROM Discomscheduledetail d WHERE d.discomScheduleId = :discomScheduleId"),
        @NamedQuery(name = "Discomscheduledetail.findByTimeslot", query = "SELECT d FROM Discomscheduledetail d WHERE d.timeslot = :timeslot"),
        @NamedQuery(name = "Discomscheduledetail.findByPower", query = "SELECT d FROM Discomscheduledetail d WHERE d.power = :power"),
})
public class Discomscheduledetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "discom_schedule_id")
    private Long discomScheduleId;
    @Column(name = "timeslot")
    private String timeslot;
    @Column(name = "power")
    private String power;
    @Column(name = "scheduledate")

    private String scheduleDate;
    @Column(name = "discompower")
    private String discompower;
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Discomschedulesources id;

    @Column(name = "powerwithoutloss")
    private String powerwithoutloss;
    @Column(name = "isupdated")
    private Boolean isupdated;

    public Discomscheduledetail() {
    }

    public Discomscheduledetail(Long discomScheduleId) {
        this.discomScheduleId = discomScheduleId;
    }

    public Long getDiscomScheduleId() {
        return discomScheduleId;
    }

    public void setDiscomScheduleId(Long discomScheduleId) {
        this.discomScheduleId = discomScheduleId;
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

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduledate) {
        this.scheduleDate = scheduledate;
    }

    public Discomschedulesources getId() {
        return id;
    }

    public void setId(Discomschedulesources id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (discomScheduleId != null ? discomScheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discomscheduledetail)) {
            return false;
        }
        Discomscheduledetail other = (Discomscheduledetail) object;
        if ((this.discomScheduleId == null && other.discomScheduleId != null) || (this.discomScheduleId != null && !this.discomScheduleId.equals(other.discomScheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ptc.Discomscheduledetail[ discomScheduleId=" + discomScheduleId + " ]";
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

}
