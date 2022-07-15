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
@Table(name = "company_sms_templates")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "CompanySmsTemplates.findAll", query = "SELECT c FROM CompanySmsTemplates c"),
        @NamedQuery(name = "CompanySmsTemplates.findById", query = "SELECT c FROM CompanySmsTemplates c WHERE c.id = :id"),
        @NamedQuery(name = "CompanySmsTemplates.findByTitle", query = "SELECT c FROM CompanySmsTemplates c WHERE c.title = :title"),
        @NamedQuery(name = "CompanySmsTemplates.findByMessage", query = "SELECT c FROM CompanySmsTemplates c WHERE c.message = :message"),
        @NamedQuery(name = "CompanySmsTemplates.findByIsactive", query = "SELECT c FROM CompanySmsTemplates c WHERE c.isactive = :isactive"),
        @NamedQuery(name = "CompanySmsTemplates.findByCreatedon", query = "SELECT c FROM CompanySmsTemplates c WHERE c.createdon = :createdon"),
        @NamedQuery(name = "CompanySmsTemplates.findByCreatedby", query = "SELECT c FROM CompanySmsTemplates c WHERE c.createdby = :createdby"),
        @NamedQuery(name = "CompanySmsTemplates.findByUpdatedon", query = "SELECT c FROM CompanySmsTemplates c WHERE c.updatedon = :updatedon"),
        @NamedQuery(name = "CompanySmsTemplates.findByUpdatedby", query = "SELECT c FROM CompanySmsTemplates c WHERE c.updatedby = :updatedby")})
public class CompanySmsTemplates implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "message")
    private String message;
    @Column(name = "isactive")
    private boolean isactive;
    @Basic(optional = false)
    @Column(name = "createdon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;
    @Column(name = "createdby")
    private String createdby;
    @Basic(optional = false)
    @Column(name = "updatedon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedon;
    @Column(name = "updatedby")
    private String updatedby;

    public CompanySmsTemplates() {
    }

    public CompanySmsTemplates(Integer id) {
        this.id = id;
    }

    public CompanySmsTemplates(Integer id, Date createdon, Date updatedon) {
        this.id = id;
        this.createdon = createdon;
        this.updatedon = updatedon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanySmsTemplates)) {
            return false;
        }
        CompanySmsTemplates other = (CompanySmsTemplates) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.CompanySmsTemplates[ id=" + id + " ]";
    }

}
