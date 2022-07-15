/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.discom.springmvc.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Bijendra
 */
@Entity
@Table(name = "portfoliodetails")
public class Portfoliodetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "portfoliomasterid", length = 233)
    private String portfoliomasterid;
    @Column(name = "value", length = 200)
    private String value;
    @Column(name = "type", length = 20)
    private String type;
    @Column(name = "dtype", length = 20)
    private String dtype;
    @Column(name = "companyMasterId", nullable = false)
    private String companyMasterId;

    public Portfoliodetails() {
    }


    public Portfoliodetails(Long id) {
        this.id = id;
    }

    public String getCompanyMasterId() {
        return companyMasterId;
    }

    public void setCompanyMasterId(String companyMasterId) {
        this.companyMasterId = companyMasterId;
    }

    public String getPortfoliomasterid() {
        return portfoliomasterid;
    }

    public void setPortfoliomasterid(String portfoliomasterid) {
        this.portfoliomasterid = portfoliomasterid;
    }


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Portfoliodetails)) {
            return false;
        }
        Portfoliodetails other = (Portfoliodetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ptc.Portfoliodetails[ id=" + id + " ]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

}
