package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author admin
 */
@Entity
@Table(name = "template_groups_fields_validators")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "TemplateGroupsFieldsValidators.findAll", query = "SELECT t FROM TemplateGroupsFieldsValidators t"),
        @NamedQuery(name = "TemplateGroupsFieldsValidators.findById", query = "SELECT t FROM TemplateGroupsFieldsValidators t WHERE t.id = :id"),
        @NamedQuery(name = "TemplateGroupsFieldsValidators.findByFieldcode", query = "SELECT t FROM TemplateGroupsFieldsValidators t WHERE t.fieldcode = :fieldcode"),
        @NamedQuery(name = "TemplateGroupsFieldsValidators.findByName", query = "SELECT t FROM TemplateGroupsFieldsValidators t WHERE t.name = :name"),
        @NamedQuery(name = "TemplateGroupsFieldsValidators.findByValidator", query = "SELECT t FROM TemplateGroupsFieldsValidators t WHERE t.validator = :validator"),
        @NamedQuery(name = "TemplateGroupsFieldsValidators.findByMessage", query = "SELECT t FROM TemplateGroupsFieldsValidators t WHERE t.message = :message"),
        @NamedQuery(name = "TemplateGroupsFieldsValidators.findByCreatedby", query = "SELECT t FROM TemplateGroupsFieldsValidators t WHERE t.createdby = :createdby"),
        @NamedQuery(name = "TemplateGroupsFieldsValidators.findByCreatedon", query = "SELECT t FROM TemplateGroupsFieldsValidators t WHERE t.createdon = :createdon"),
        @NamedQuery(name = "TemplateGroupsFieldsValidators.findByUpdatedby", query = "SELECT t FROM TemplateGroupsFieldsValidators t WHERE t.updatedby = :updatedby"),
        @NamedQuery(name = "TemplateGroupsFieldsValidators.findByUpdatedon", query = "SELECT t FROM TemplateGroupsFieldsValidators t WHERE t.updatedon = :updatedon")})
public class TemplateGroupsFieldsValidators implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "fieldcode")
    private String fieldcode;
    @Column(name = "name")
    private String name;
    @Column(name = "validator")
    private String validator;
    @Column(name = "message")
    private String message;
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
    private boolean selected;
    @Transient
    private String value;

    public TemplateGroupsFieldsValidators() {
    }

    public TemplateGroupsFieldsValidators(Long id) {
        this.id = id;
    }

    public TemplateGroupsFieldsValidators(Long id, String createdby, Date createdon, String updatedby, Date updatedon) {
        this.id = id;
        this.createdby = createdby;
        this.createdon = createdon;
        this.updatedby = updatedby;
        this.updatedon = updatedon;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValidator() {
        return validator;
    }

    public void setValidator(String validator) {
        this.validator = validator;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        if (!(object instanceof TemplateGroupsFieldsValidators)) {
            return false;
        }
        TemplateGroupsFieldsValidators other = (TemplateGroupsFieldsValidators) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.TemplateGroupsFieldsValidators[ id=" + id + " ]";
    }

}
