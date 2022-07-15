/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.discom.springmvc.pojo;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @author admin
 */
public class Wpdregionnames implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "masterid")
    private Long masterid;
    @Column(name = "regionid")
    private String regionid;
    @Column(name = "regionshortname")
    private String regionshortname;
    @Column(name = "wpdregionname")
    private String wpdregionname;
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Portfoliomaster id;

    public Wpdregionnames() {
    }

    public Wpdregionnames(Long masterid) {
        this.masterid = masterid;
    }

    public Long getMasterid() {
        return masterid;
    }

    public void setMasterid(Long masterid) {
        this.masterid = masterid;
    }

    public String getRegionid() {
        return regionid;
    }

    public void setRegionid(String regionid) {
        this.regionid = regionid;
    }

    public String getRegionshortname() {
        return regionshortname;
    }

    public void setRegionshortname(String regionshortname) {
        this.regionshortname = regionshortname;
    }

    public String getWpdregionname() {
        return wpdregionname;
    }

    public void setWpdregionname(String wpdregionname) {
        this.wpdregionname = wpdregionname;
    }

    public Portfoliomaster getId() {
        return id;
    }

    public void setId(Portfoliomaster id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (masterid != null ? masterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wpdregionnames)) {
            return false;
        }
        Wpdregionnames other = (Wpdregionnames) object;
        if ((this.masterid == null && other.masterid != null) || (this.masterid != null && !this.masterid.equals(other.masterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Wpdregionnames[ masterid=" + masterid + " ]";
    }


}
