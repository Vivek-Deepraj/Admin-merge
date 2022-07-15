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
@Table(name = "powerroute")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Powerroute.findAll", query = "SELECT p FROM Powerroute p"),
        @NamedQuery(name = "Powerroute.findByRouteId", query = "SELECT p FROM Powerroute p WHERE p.routeId = :routeId"),
        @NamedQuery(name = "Powerroute.findByRoute", query = "SELECT p FROM Powerroute p WHERE p.route = :route"),
        @NamedQuery(name = "Powerroute.findByCreatedon", query = "SELECT p FROM Powerroute p WHERE p.createdon = :createdon"),
        @NamedQuery(name = "Powerroute.findByCreatedby", query = "SELECT p FROM Powerroute p WHERE p.createdby = :createdby"),
        @NamedQuery(name = "Powerroute.findByUpdatedby", query = "SELECT p FROM Powerroute p WHERE p.updatedby = :updatedby"),
        @NamedQuery(name = "Powerroute.findByUpdatedon", query = "SELECT p FROM Powerroute p WHERE p.updatedon = :updatedon")})
public class Powerroute implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "routeId")
    private Integer routeId;
    @Column(name = "route")
    private String route;
    @Basic(optional = false)
    @Column(name = "createdon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "updatedby")
    private String updatedby;
    @Column(name = "updatedon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedon;

    public Powerroute() {
    }

    public Powerroute(Integer routeId) {
        this.routeId = routeId;
    }

    public Powerroute(Integer routeId, Date createdon) {
        this.routeId = routeId;
        this.createdon = createdon;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
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
        hash += (routeId != null ? routeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Powerroute)) {
            return false;
        }
        Powerroute other = (Powerroute) object;
        if ((this.routeId == null && other.routeId != null) || (this.routeId != null && !this.routeId.equals(other.routeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Powerroute[ routeId=" + routeId + " ]";
    }

}
