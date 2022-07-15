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
@Table(name = "setting")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Setting.findAll", query = "SELECT s FROM Setting s"),
        @NamedQuery(name = "Setting.findById", query = "SELECT s FROM Setting s WHERE s.id = :id"),
        @NamedQuery(name = "Setting.findByLabel", query = "SELECT s FROM Setting s WHERE s.label = :label"),
        @NamedQuery(name = "Setting.findByValue", query = "SELECT s FROM Setting s WHERE s.value = :value"),
        @NamedQuery(name = "Setting.findByStartdate", query = "SELECT s FROM Setting s WHERE s.startdate = :startdate"),
        @NamedQuery(name = "Setting.findByEnddate", query = "SELECT s FROM Setting s WHERE s.enddate = :enddate"),
        @NamedQuery(name = "Setting.findByCreatedby", query = "SELECT s FROM Setting s WHERE s.createdby = :createdby"),
        @NamedQuery(name = "Setting.findByUpdatedby", query = "SELECT s FROM Setting s WHERE s.updatedby = :updatedby"),
        @NamedQuery(name = "Setting.findByCreatedon", query = "SELECT s FROM Setting s WHERE s.createdon = :createdon"),
        @NamedQuery(name = "Setting.findByUpdatedon", query = "SELECT s FROM Setting s WHERE s.updatedon = :updatedon")})
public class Setting implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "label")
    private String label;
    @Column(name = "value")
    private String value;
    @Column(name = "startdate")

    private String startdate;
    @Column(name = "enddate")

    private String enddate;
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "updatedby")
    private String updatedby;
    @Column(name = "createdon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;
    @Column(name = "updatedon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedon;

    @Column(name = "isapply")
    private Boolean isapply;


    public Setting() {
    }

    public Setting(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
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
        if (!(object instanceof Setting)) {
            return false;
        }
        Setting other = (Setting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Setting[ id=" + id + " ]";
    }

    public Boolean getIsapply() {
        return isapply;
    }

    public void setIsapply(Boolean isapply) {
        this.isapply = isapply;
    }

}
