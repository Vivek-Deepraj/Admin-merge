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
@Table(name = "resumedata")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Resumedata.findAll", query = "SELECT r FROM Resumedata r"),
        @NamedQuery(name = "Resumedata.findById", query = "SELECT r FROM Resumedata r WHERE r.id = :id"),
        @NamedQuery(name = "Resumedata.findByUserid", query = "SELECT r FROM Resumedata r WHERE r.userid = :userid"),
        @NamedQuery(name = "Resumedata.findByTemplatecode", query = "SELECT r FROM Resumedata r WHERE r.templatecode = :templatecode"),
        @NamedQuery(name = "Resumedata.findByAtrributecode", query = "SELECT r FROM Resumedata r WHERE r.atrributecode = :atrributecode"),
        @NamedQuery(name = "Resumedata.findByAtrributevalue", query = "SELECT r FROM Resumedata r WHERE r.atrributevalue = :atrributevalue")})
public class Resumedata implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "userid")
    private String userid;
    @Column(name = "templatecode")
    private String templatecode;
    @Column(name = "atrributecode")
    private String atrributecode;
    @Column(name = "atrributevalue")
    private String atrributevalue;

    public Resumedata() {
    }

    public Resumedata(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTemplatecode() {
        return templatecode;
    }

    public void setTemplatecode(String templatecode) {
        this.templatecode = templatecode;
    }

    public String getAtrributecode() {
        return atrributecode;
    }

    public void setAtrributecode(String atrributecode) {
        this.atrributecode = atrributecode;
    }

    public String getAtrributevalue() {
        return atrributevalue;
    }

    public void setAtrributevalue(String atrributevalue) {
        this.atrributevalue = atrributevalue;
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
        if (!(object instanceof Resumedata)) {
            return false;
        }
        Resumedata other = (Resumedata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Resumedata[ id=" + id + " ]";
    }

}
