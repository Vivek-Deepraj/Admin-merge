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
@Table(name = "rldcsetting")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Rldcsetting.findAll", query = "SELECT r FROM Rldcsetting r"),
        @NamedQuery(name = "Rldcsetting.findById", query = "SELECT r FROM Rldcsetting r WHERE r.id = :id"),
        @NamedQuery(name = "Rldcsetting.findByRldc", query = "SELECT r FROM Rldcsetting r WHERE r.rldc = :rldc"),
        @NamedQuery(name = "Rldcsetting.findByUrl", query = "SELECT r FROM Rldcsetting r WHERE r.url = :url")})
public class Rldcsetting implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "rldc")
    private String rldc;
    @Column(name = "url")
    private String url;

    public Rldcsetting() {
    }

    public Rldcsetting(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRldc() {
        return rldc;
    }

    public void setRldc(String rldc) {
        this.rldc = rldc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        if (!(object instanceof Rldcsetting)) {
            return false;
        }
        Rldcsetting other = (Rldcsetting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Rldcsetting[ id=" + id + " ]";
    }

}
