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
@Table(name = "careerguidlines")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Careerguidlines.findAll", query = "SELECT c FROM Careerguidlines c"),
        @NamedQuery(name = "Careerguidlines.findById", query = "SELECT c FROM Careerguidlines c WHERE c.id = :id"),
        @NamedQuery(name = "Careerguidlines.findByName", query = "SELECT c FROM Careerguidlines c WHERE c.name = :name"),
        @NamedQuery(name = "Careerguidlines.findByParentId", query = "SELECT c FROM Careerguidlines c WHERE c.parentId = :parentId"),
        @NamedQuery(name = "Careerguidlines.findByLft", query = "SELECT c FROM Careerguidlines c WHERE c.lft = :lft"),
        @NamedQuery(name = "Careerguidlines.findByRgt", query = "SELECT c FROM Careerguidlines c WHERE c.rgt = :rgt"),
        @NamedQuery(name = "Careerguidlines.findByDepth", query = "SELECT c FROM Careerguidlines c WHERE c.depth = :depth"),
        @NamedQuery(name = "Careerguidlines.findByDescription", query = "SELECT c FROM Careerguidlines c WHERE c.description = :description"),
        @NamedQuery(name = "Careerguidlines.findByCreatedby", query = "SELECT c FROM Careerguidlines c WHERE c.createdby = :createdby"),
        @NamedQuery(name = "Careerguidlines.findByCreatedon", query = "SELECT c FROM Careerguidlines c WHERE c.createdon = :createdon"),
        @NamedQuery(name = "Careerguidlines.findByUpdatedby", query = "SELECT c FROM Careerguidlines c WHERE c.updatedby = :updatedby"),
        @NamedQuery(name = "Careerguidlines.findByUpdatedon", query = "SELECT c FROM Careerguidlines c WHERE c.updatedon = :updatedon")})
public class Careerguidlines implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "parent_id")
    private int parentId;
    @Basic(optional = false)
    @Column(name = "lft")
    private int lft;
    @Basic(optional = false)
    @Column(name = "rgt")
    private int rgt;
    @Basic(optional = false)
    @Column(name = "depth")
    private int depth;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
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

    public Careerguidlines() {
    }

    public Careerguidlines(Integer id) {
        this.id = id;
    }

    public Careerguidlines(Integer id, String name, int parentId, int lft, int rgt, int depth, String description, String createdby, Date createdon, String updatedby, Date updatedon) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.lft = lft;
        this.rgt = rgt;
        this.depth = depth;
        this.description = description;
        this.createdby = createdby;
        this.createdon = createdon;
        this.updatedby = updatedby;
        this.updatedon = updatedon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getLft() {
        return lft;
    }

    public void setLft(int lft) {
        this.lft = lft;
    }

    public int getRgt() {
        return rgt;
    }

    public void setRgt(int rgt) {
        this.rgt = rgt;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof Careerguidlines)) {
            return false;
        }
        Careerguidlines other = (Careerguidlines) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Careerguidlines[ id=" + id + " ]";
    }

}
