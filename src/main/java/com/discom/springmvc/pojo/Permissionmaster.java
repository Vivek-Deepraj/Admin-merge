/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author admin
 */
@Entity
@Table(name = "permissionmaster")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Permissionmaster.findAll", query = "SELECT p FROM Permissionmaster p"),
        @NamedQuery(name = "Permissionmaster.findById", query = "SELECT p FROM Permissionmaster p WHERE p.id = :id"),
        @NamedQuery(name = "Permissionmaster.findByUserMasterId", query = "SELECT p FROM Permissionmaster p WHERE p.userMasterId = :userMasterId"),
        @NamedQuery(name = "Permissionmaster.findByUrl", query = "SELECT p FROM Permissionmaster p WHERE p.url = :url"),
        @NamedQuery(name = "Permissionmaster.findByPermission", query = "SELECT p FROM Permissionmaster p WHERE p.permission = :permission")})
public class Permissionmaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "userMasterId")
    private String userMasterId;
    @Column(name = "url")
    private String url;
    @Column(name = "permission")
    private Boolean permission;

    public Permissionmaster() {
    }

    public Permissionmaster(Long id) {
        this.id = id;
    }

    public Permissionmaster(Long id, String userMasterId) {
        this.id = id;
        this.userMasterId = userMasterId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserMasterId() {
        return userMasterId;
    }

    public void setUserMasterId(String userMasterId) {
        this.userMasterId = userMasterId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getPermission() {
        return permission;
    }

    public void setPermission(Boolean permission) {
        this.permission = permission;
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
        if (!(object instanceof Permissionmaster)) {
            return false;
        }
        Permissionmaster other = (Permissionmaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Permissionmaster[ id=" + id + " ]";
    }

}
