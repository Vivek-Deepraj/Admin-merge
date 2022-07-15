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
@Table(name = "candidate_email_templates")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "CandidateEmailTemplates.findAll", query = "SELECT c FROM CandidateEmailTemplates c"),
        @NamedQuery(name = "CandidateEmailTemplates.findById", query = "SELECT c FROM CandidateEmailTemplates c WHERE c.id = :id"),
        @NamedQuery(name = "CandidateEmailTemplates.findByTitle", query = "SELECT c FROM CandidateEmailTemplates c WHERE c.title = :title"),
        @NamedQuery(name = "CandidateEmailTemplates.findBySubject", query = "SELECT c FROM CandidateEmailTemplates c WHERE c.subject = :subject"),
        @NamedQuery(name = "CandidateEmailTemplates.findByBody", query = "SELECT c FROM CandidateEmailTemplates c WHERE c.body = :body"),
        @NamedQuery(name = "CandidateEmailTemplates.findByIsactive", query = "SELECT c FROM CandidateEmailTemplates c WHERE c.isactive = :isactive"),
        @NamedQuery(name = "CandidateEmailTemplates.findByCreatedon", query = "SELECT c FROM CandidateEmailTemplates c WHERE c.createdon = :createdon"),
        @NamedQuery(name = "CandidateEmailTemplates.findByCreatedby", query = "SELECT c FROM CandidateEmailTemplates c WHERE c.createdby = :createdby"),
        @NamedQuery(name = "CandidateEmailTemplates.findByUpdatedon", query = "SELECT c FROM CandidateEmailTemplates c WHERE c.updatedon = :updatedon"),
        @NamedQuery(name = "CandidateEmailTemplates.findByUpdatedby", query = "SELECT c FROM CandidateEmailTemplates c WHERE c.updatedby = :updatedby")})
public class CandidateEmailTemplates implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "subject")
    private String subject;
    @Column(name = "body")
    private String body;
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

    public CandidateEmailTemplates() {
    }

    public CandidateEmailTemplates(Integer id) {
        this.id = id;
    }

    public CandidateEmailTemplates(Integer id, Date createdon, Date updatedon) {
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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
        if (!(object instanceof CandidateEmailTemplates)) {
            return false;
        }
        CandidateEmailTemplates other = (CandidateEmailTemplates) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.CandidateEmailTemplates[ id=" + id + " ]";
    }

}
