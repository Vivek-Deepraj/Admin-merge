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
 * @author Bijendra
 */
@Entity
@Table(name = "portfoliodiscom")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Portfoliodiscom.findAll", query = "SELECT p FROM Portfoliodiscom p"),
        @NamedQuery(name = "Portfoliodiscom.findByDiscomMasterId", query = "SELECT p FROM Portfoliodiscom p WHERE p.discomMasterId = :discomMasterId"),
        @NamedQuery(name = "Portfoliodiscom.findByPortfoliomasterid", query = "SELECT p FROM Portfoliodiscom p WHERE p.portfoliomasterid = :portfoliomasterid"),
        @NamedQuery(name = "Portfoliodiscom.findByDiscom", query = "SELECT p FROM Portfoliodiscom p WHERE p.discom = :discom"),
        @NamedQuery(name = "Portfoliodiscom.findByDiscompercent", query = "SELECT p FROM Portfoliodiscom p WHERE p.discompercent = :discompercent")})
public class Portfoliodiscom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "discomMasterId")
    private Integer discomMasterId;
    @Column(name = "portfoliomasterid")
    private String portfoliomasterid;
    @Column(name = "discom")
    private String discom;
    @Column(name = "discompercent")
    private String discompercent;

    public Portfoliodiscom() {
    }

    public Portfoliodiscom(Integer discomMasterId) {
        this.discomMasterId = discomMasterId;
    }

    public Integer getDiscomMasterId() {
        return discomMasterId;
    }

    public void setDiscomMasterId(Integer discomMasterId) {
        this.discomMasterId = discomMasterId;
    }

    public String getPortfoliomasterid() {
        return portfoliomasterid;
    }

    public void setPortfoliomasterid(String portfoliomasterid) {
        this.portfoliomasterid = portfoliomasterid;
    }

    public String getDiscom() {
        return discom;
    }

    public void setDiscom(String discom) {
        this.discom = discom;
    }

    public String getDiscompercent() {
        return discompercent;
    }

    public void setDiscompercent(String discompercent) {
        this.discompercent = discompercent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (discomMasterId != null ? discomMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Portfoliodiscom)) {
            return false;
        }
        Portfoliodiscom other = (Portfoliodiscom) object;
        if ((this.discomMasterId == null && other.discomMasterId != null) || (this.discomMasterId != null && !this.discomMasterId.equals(other.discomMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ptc.Portfoliodiscom[ discomMasterId=" + discomMasterId + " ]";
    }

}
