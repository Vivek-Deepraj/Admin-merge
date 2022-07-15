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
@Table(name = "constantslistsdetails")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Constantslistsdetails.findAll", query = "SELECT c FROM Constantslistsdetails c"),
        @NamedQuery(name = "Constantslistsdetails.findById", query = "SELECT c FROM Constantslistsdetails c WHERE c.id = :id"),
        @NamedQuery(name = "Constantslistsdetails.findByType", query = "SELECT c FROM Constantslistsdetails c WHERE c.type = :type"),
        @NamedQuery(name = "Constantslistsdetails.findByCode", query = "SELECT c FROM Constantslistsdetails c WHERE c.code = :code"),
        @NamedQuery(name = "Constantslistsdetails.findByLabel", query = "SELECT c FROM Constantslistsdetails c WHERE c.label = :label"),
        @NamedQuery(name = "Constantslistsdetails.findByCreatedby", query = "SELECT c FROM Constantslistsdetails c WHERE c.createdby = :createdby"),
        @NamedQuery(name = "Constantslistsdetails.findByCreatedon", query = "SELECT c FROM Constantslistsdetails c WHERE c.createdon = :createdon"),
        @NamedQuery(name = "Constantslistsdetails.findByUpdatedby", query = "SELECT c FROM Constantslistsdetails c WHERE c.updatedby = :updatedby"),
        @NamedQuery(name = "Constantslistsdetails.findByUpdatedon", query = "SELECT c FROM Constantslistsdetails c WHERE c.updatedon = :updatedon")})
public class Constantslistsdetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "code")
    private String code;
    @Column(name = "label")
    private String label;
    @Basic(optional = false)
    @Column(name = "createdby")
    private String createdby;
    @Basic(optional = false)
    @Column(name = "createdon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;
    @Basic(optional = false)
    @Column(name = "updatedby")
    private String updatedby;
    @Basic(optional = false)
    @Column(name = "updatedon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedon;

    public Constantslistsdetails() {
    }

    public Constantslistsdetails(Long id) {
        this.id = id;
    }

    public Constantslistsdetails(Long id, String createdby, Date createdon, String updatedby, Date updatedon) {
        this.id = id;
        this.createdby = createdby;
        this.createdon = createdon;
        this.updatedby = updatedby;
        this.updatedon = updatedon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
        if (!(object instanceof Constantslistsdetails)) {
            return false;
        }
        Constantslistsdetails other = (Constantslistsdetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Constantslistsdetails[ id=" + id + " ]";
    }

}
