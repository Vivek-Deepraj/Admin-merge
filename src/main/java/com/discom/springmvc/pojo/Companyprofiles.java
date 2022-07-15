/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discom.springmvc.pojo;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author admin
 */
@Entity
@Table(name = "companyprofiles")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Companyprofiles.findAll", query = "SELECT c FROM Companyprofiles c"),
        @NamedQuery(name = "Companyprofiles.findById", query = "SELECT c FROM Companyprofiles c WHERE c.id = :id"),
        @NamedQuery(name = "Companyprofiles.findByUserid", query = "SELECT c FROM Companyprofiles c WHERE c.userid = :userid"),
        @NamedQuery(name = "Companyprofiles.findByTemplatecode", query = "SELECT c FROM Companyprofiles c WHERE c.templatecode = :templatecode"),
        @NamedQuery(name = "Companyprofiles.findByTemplatetype", query = "SELECT c FROM Companyprofiles c WHERE c.templatetype = :templatetype"),
        @NamedQuery(name = "Companyprofiles.findByCreatedby", query = "SELECT c FROM Companyprofiles c WHERE c.createdby = :createdby"),
        @NamedQuery(name = "Companyprofiles.findByCreatedon", query = "SELECT c FROM Companyprofiles c WHERE c.createdon = :createdon"),
        @NamedQuery(name = "Companyprofiles.findByUpdatedby", query = "SELECT c FROM Companyprofiles c WHERE c.updatedby = :updatedby"),
        @NamedQuery(name = "Companyprofiles.findByUpdatedon", query = "SELECT c FROM Companyprofiles c WHERE c.updatedon = :updatedon")})
public class Companyprofiles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "userid")
    private String userid;
    @Column(name = "templatecode")
    private String templatecode;
    @Column(name = "templatetype")
    private String templatetype;
    @Lob
    @Type(type = "com.discom.springmvc.pojo.JsonType",
            parameters = {
                    @Parameter(
                            name = "classType",
                            value = "java.util.LinkedHashMap"
                    )
            })
    @Column(name = "data")
    private Object data;
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

    public Companyprofiles() {
    }

    public Companyprofiles(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getTemplatetype() {
        return templatetype;
    }

    public void setTemplatetype(String templatetype) {
        this.templatetype = templatetype;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
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
        if (!(object instanceof Companyprofiles)) {
            return false;
        }
        Companyprofiles other = (Companyprofiles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Companyprofiles[ id=" + id + " ]";
    }

}
