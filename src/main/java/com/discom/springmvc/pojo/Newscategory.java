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
@Table(name = "newscategory")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Newscategory.findAll", query = "SELECT n FROM Newscategory n"),
        @NamedQuery(name = "Newscategory.findById", query = "SELECT n FROM Newscategory n WHERE n.id = :id"),
        @NamedQuery(name = "Newscategory.findByCategoryname", query = "SELECT n FROM Newscategory n WHERE n.categoryname = :categoryname"),
        @NamedQuery(name = "Newscategory.findByCategoryactive", query = "SELECT n FROM Newscategory n WHERE n.categoryactive = :categoryactive"),
        @NamedQuery(name = "Newscategory.findByCreatedon", query = "SELECT n FROM Newscategory n WHERE n.createdon = :createdon"),
        @NamedQuery(name = "Newscategory.findByCreatedby", query = "SELECT n FROM Newscategory n WHERE n.createdby = :createdby"),
        @NamedQuery(name = "Newscategory.findByUpdatedon", query = "SELECT n FROM Newscategory n WHERE n.updatedon = :updatedon"),
        @NamedQuery(name = "Newscategory.findByUpdatedby", query = "SELECT n FROM Newscategory n WHERE n.updatedby = :updatedby")})
public class Newscategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "categoryname")
    private String categoryname;
    @Basic(optional = false)
    @Column(name = "categoryactive")
    private boolean categoryactive;
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

    public Newscategory() {
    }

    public Newscategory(Long id) {
        this.id = id;
    }

    public Newscategory(Long id, String categoryname, boolean categoryactive, Date createdon, Date updatedon) {
        this.id = id;
        this.categoryname = categoryname;
        this.categoryactive = categoryactive;
        this.createdon = createdon;
        this.updatedon = updatedon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public boolean getCategoryactive() {
        return categoryactive;
    }

    public void setCategoryactive(boolean categoryactive) {
        this.categoryactive = categoryactive;
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
        if (!(object instanceof Newscategory)) {
            return false;
        }
        Newscategory other = (Newscategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Newscategory[ id=" + id + " ]";
    }

}
