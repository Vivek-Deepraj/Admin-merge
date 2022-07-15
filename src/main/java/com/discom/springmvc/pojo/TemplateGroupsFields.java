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
@Table(name = "template_groups_fields")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "TemplateGroupsFields.findAll", query = "SELECT t FROM TemplateGroupsFields t"),
        @NamedQuery(name = "TemplateGroupsFields.findById", query = "SELECT t FROM TemplateGroupsFields t WHERE t.id = :id"),
        @NamedQuery(name = "TemplateGroupsFields.findByFieldcode", query = "SELECT t FROM TemplateGroupsFields t WHERE t.fieldcode = :fieldcode"),
        @NamedQuery(name = "TemplateGroupsFields.findByFieldlabel", query = "SELECT t FROM TemplateGroupsFields t WHERE t.fieldlabel = :fieldlabel"),
        @NamedQuery(name = "TemplateGroupsFields.findByFielddisplaytype", query = "SELECT t FROM TemplateGroupsFields t WHERE t.fielddisplaytype = :fielddisplaytype"),
        @NamedQuery(name = "TemplateGroupsFields.findByFieldhtml", query = "SELECT t FROM TemplateGroupsFields t WHERE t.fieldhtml = :fieldhtml"),
        @NamedQuery(name = "TemplateGroupsFields.findByHaschild", query = "SELECT t FROM TemplateGroupsFields t WHERE t.haschild = :haschild"),
        @NamedQuery(name = "TemplateGroupsFields.findByIsactive", query = "SELECT t FROM TemplateGroupsFields t WHERE t.isactive = :isactive")})
public class TemplateGroupsFields implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "fieldcode")
    private String fieldcode;
    @Column(name = "fieldlabel")
    private String fieldlabel;
    @Column(name = "fielddisplaytype")
    private String fielddisplaytype;
    @Column(name = "fieldhtml")
    private String fieldhtml;
    @Column(name = "haschild")
    private Boolean haschild;
    @Column(name = "isactive")
    private Boolean isactive;
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

    @Transient
    private List<TemplateGroupsFieldsChilds> templateGroupsFieldsChilds;
    @Transient
    private List<TemplateGroupsFieldsValidators> templateGroupsFieldsValidators;

    public TemplateGroupsFields() {
    }

    public TemplateGroupsFields(Long id) {
        this.id = id;
    }

    public List<TemplateGroupsFieldsChilds> getTemplateGroupsFieldsChilds() {
        return templateGroupsFieldsChilds;
    }

    public void setTemplateGroupsFieldsChilds(List<TemplateGroupsFieldsChilds> templateGroupsFieldsChilds) {
        this.templateGroupsFieldsChilds = templateGroupsFieldsChilds;
    }

    public List<TemplateGroupsFieldsValidators> getTemplateGroupsFieldsValidators() {
        return templateGroupsFieldsValidators;
    }

    public void setTemplateGroupsFieldsValidators(List<TemplateGroupsFieldsValidators> templateGroupsFieldsValidators) {
        this.templateGroupsFieldsValidators = templateGroupsFieldsValidators;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFieldcode() {
        return fieldcode;
    }

    public void setFieldcode(String fieldcode) {
        this.fieldcode = fieldcode;
    }

    public String getFieldlabel() {
        return fieldlabel;
    }

    public void setFieldlabel(String fieldlabel) {
        this.fieldlabel = fieldlabel;
    }

    public String getFielddisplaytype() {
        return fielddisplaytype;
    }

    public void setFielddisplaytype(String fielddisplaytype) {
        this.fielddisplaytype = fielddisplaytype;
    }

    public String getFieldhtml() {
        return fieldhtml;
    }

    public void setFieldhtml(String fieldhtml) {
        this.fieldhtml = fieldhtml;
    }

    public Boolean getHaschild() {
        return haschild;
    }

    public void setHaschild(Boolean haschild) {
        this.haschild = haschild;
    }

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
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
        if (!(object instanceof TemplateGroupsFields)) {
            return false;
        }
        TemplateGroupsFields other = (TemplateGroupsFields) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.TemplateGroupsFields[ id=" + id + " ]";
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

}
