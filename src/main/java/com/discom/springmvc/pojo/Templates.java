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
@Table(name = "templates")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Templates.findAll", query = "SELECT t FROM Templates t"),
        @NamedQuery(name = "Templates.findById", query = "SELECT t FROM Templates t WHERE t.id = :id"),
        @NamedQuery(name = "Templates.findByTemplatename", query = "SELECT t FROM Templates t WHERE t.templatename = :templatename"),
        @NamedQuery(name = "Templates.findByTemplatecode", query = "SELECT t FROM Templates t WHERE t.templatecode = :templatecode"),
        @NamedQuery(name = "Templates.findByTemplatetype", query = "SELECT t FROM Templates t WHERE t.templatetype = :templatetype"),
        @NamedQuery(name = "Templates.findByIsActive", query = "SELECT t FROM Templates t WHERE t.isActive = :isActive"),
        @NamedQuery(name = "Templates.findByCreatedby", query = "SELECT t FROM Templates t WHERE t.createdby = :createdby"),
        @NamedQuery(name = "Templates.findByCreatedon", query = "SELECT t FROM Templates t WHERE t.createdon = :createdon"),
        @NamedQuery(name = "Templates.findByUpdatedby", query = "SELECT t FROM Templates t WHERE t.updatedby = :updatedby"),
        @NamedQuery(name = "Templates.findByUpdatedon", query = "SELECT t FROM Templates t WHERE t.updatedon = :updatedon")})
public class Templates implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "templatename")
    private String templatename;
    @Column(name = "templatecode")
    private String templatecode;
    @Column(name = "templatetype")
    private String templatetype;
    @Column(name = "isActive")
    private Boolean isActive;
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "createdon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;
    @Column(name = "updatedby")
    private String updatedby;
    @Column(name = "updatedon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedon;

    public Templates() {
    }

    public Templates(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemplatename() {
        return templatename;
    }

    public void setTemplatename(String templatename) {
        this.templatename = templatename;
    }

    public String getTemplatecode() {
        return templatecode;
    }

    public void setTemplatecode(String templatecode) {
        this.templatecode = templatecode;
    }

    public String getTemplatetype() {
        return templatetype;
    }

    public void setTemplatetype(String templatetype) {
        this.templatetype = templatetype;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Templates)) {
            return false;
        }
        Templates other = (Templates) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Templates[ id=" + id + " ]";
    }

}
