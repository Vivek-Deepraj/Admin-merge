package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author admin
 */
@Entity
@Table(name = "template_groups_fields_childs")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "TemplateGroupsFieldsChilds.findAll", query = "SELECT t FROM TemplateGroupsFieldsChilds t"),
        @NamedQuery(name = "TemplateGroupsFieldsChilds.findById", query = "SELECT t FROM TemplateGroupsFieldsChilds t WHERE t.id = :id"),
        @NamedQuery(name = "TemplateGroupsFieldsChilds.findByFieldcode", query = "SELECT t FROM TemplateGroupsFieldsChilds t WHERE t.fieldcode = :fieldcode"),
        @NamedQuery(name = "TemplateGroupsFieldsChilds.findByCode", query = "SELECT t FROM TemplateGroupsFieldsChilds t WHERE t.code = :code"),
        @NamedQuery(name = "TemplateGroupsFieldsChilds.findByLabel", query = "SELECT t FROM TemplateGroupsFieldsChilds t WHERE t.label = :label"),
        @NamedQuery(name = "TemplateGroupsFieldsChilds.findByCreatedby", query = "SELECT t FROM TemplateGroupsFieldsChilds t WHERE t.createdby = :createdby"),
        @NamedQuery(name = "TemplateGroupsFieldsChilds.findByCreatedon", query = "SELECT t FROM TemplateGroupsFieldsChilds t WHERE t.createdon = :createdon"),
        @NamedQuery(name = "TemplateGroupsFieldsChilds.findByUpdatedby", query = "SELECT t FROM TemplateGroupsFieldsChilds t WHERE t.updatedby = :updatedby"),
        @NamedQuery(name = "TemplateGroupsFieldsChilds.findByUpdatedon", query = "SELECT t FROM TemplateGroupsFieldsChilds t WHERE t.updatedon = :updatedon")})
public class TemplateGroupsFieldsChilds implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "fieldcode")
    private String fieldcode;
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

    public TemplateGroupsFieldsChilds() {
    }

    public TemplateGroupsFieldsChilds(Long id) {
        this.id = id;
    }

    public TemplateGroupsFieldsChilds(Long id, String createdby, Date createdon, String updatedby, Date updatedon) {
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

    public String getFieldcode() {
        return fieldcode;
    }

    public void setFieldcode(String fieldcode) {
        this.fieldcode = fieldcode;
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
        if (!(object instanceof TemplateGroupsFieldsChilds)) {
            return false;
        }
        TemplateGroupsFieldsChilds other = (TemplateGroupsFieldsChilds) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.TemplateGroupsFieldsChilds[ id=" + id + " ]";
    }

}
