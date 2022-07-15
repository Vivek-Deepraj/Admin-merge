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
import java.util.List;

/**
 * @author admin
 */
@Entity
@Table(name = "template_groups")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "TemplateGroups.findAll", query = "SELECT t FROM TemplateGroups t"),
        @NamedQuery(name = "TemplateGroups.findById", query = "SELECT t FROM TemplateGroups t WHERE t.id = :id"),
        @NamedQuery(name = "TemplateGroups.findByTemplatecode", query = "SELECT t FROM TemplateGroups t WHERE t.templatecode = :templatecode"),
        @NamedQuery(name = "TemplateGroups.findByTemplatetype", query = "SELECT t FROM TemplateGroups t WHERE t.templatetype = :templatetype"),
        @NamedQuery(name = "TemplateGroups.findByGroupname", query = "SELECT t FROM TemplateGroups t WHERE t.groupname = :groupname"),
        @NamedQuery(name = "TemplateGroups.findByIsActive", query = "SELECT t FROM TemplateGroups t WHERE t.isActive = :isActive"),
        @NamedQuery(name = "TemplateGroups.findByCreatedby", query = "SELECT t FROM TemplateGroups t WHERE t.createdby = :createdby"),
        @NamedQuery(name = "TemplateGroups.findByCreatedon", query = "SELECT t FROM TemplateGroups t WHERE t.createdon = :createdon"),
        @NamedQuery(name = "TemplateGroups.findByUpdatedby", query = "SELECT t FROM TemplateGroups t WHERE t.updatedby = :updatedby"),
        @NamedQuery(name = "TemplateGroups.findByUpdatedon", query = "SELECT t FROM TemplateGroups t WHERE t.updatedon = :updatedon")})
public class TemplateGroups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "templatecode")
    private String templatecode;
    @Column(name = "templatetype")
    private String templatetype;
    @Column(name = "groupname")
    private String groupname;
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

    @Transient
    private List<TemplateGroupsFields> templateGroupsFields;
    @Column(name = "fields")
    private String fields;

    public TemplateGroups() {
    }

    public TemplateGroups(Long id) {
        this.id = id;
    }

    public List<TemplateGroupsFields> getTemplateGroupsFields() {
        return templateGroupsFields;
    }

    public void setTemplateGroupsFields(List<TemplateGroupsFields> templateGroupsFields) {
        this.templateGroupsFields = templateGroupsFields;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
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
        if (!(object instanceof TemplateGroups)) {
            return false;
        }
        TemplateGroups other = (TemplateGroups) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.TemplateGroups[ id=" + id + " ]";
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

}
