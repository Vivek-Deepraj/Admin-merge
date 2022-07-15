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
@Table(name = "activitylog")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Activitylog.findAll", query = "SELECT a FROM Activitylog a"),
        @NamedQuery(name = "Activitylog.findById", query = "SELECT a FROM Activitylog a WHERE a.id = :id"),
        @NamedQuery(name = "Activitylog.findByUserid", query = "SELECT a FROM Activitylog a WHERE a.userid = :userid"),
        @NamedQuery(name = "Activitylog.findByUsername", query = "SELECT a FROM Activitylog a WHERE a.username = :username"),
        @NamedQuery(name = "Activitylog.findByUsertype", query = "SELECT a FROM Activitylog a WHERE a.usertype = :usertype"),
        @NamedQuery(name = "Activitylog.findByDatetime", query = "SELECT a FROM Activitylog a WHERE a.datetime = :datetime"),
        @NamedQuery(name = "Activitylog.findByOperatingsystem", query = "SELECT a FROM Activitylog a WHERE a.operatingsystem = :operatingsystem"),
        @NamedQuery(name = "Activitylog.findByBrowser", query = "SELECT a FROM Activitylog a WHERE a.browser = :browser"),
        @NamedQuery(name = "Activitylog.findByIpaddress", query = "SELECT a FROM Activitylog a WHERE a.ipaddress = :ipaddress"),
        @NamedQuery(name = "Activitylog.findByDetails", query = "SELECT a FROM Activitylog a WHERE a.details = :details")})
public class Activitylog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "userid")
    private String userid;
    @Column(name = "username")
    private String username;
    @Column(name = "usertype")
    private String usertype;
    @Column(name = "datetime")
    private String datetime;
    @Column(name = "operatingsystem")
    private String operatingsystem;
    @Column(name = "browser")
    private String browser;
    @Column(name = "ipaddress")
    private String ipaddress;
    @Column(name = "details")
    private String details;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "entrytime")
    private String entrytime;


    public Activitylog() {
    }

    public Activitylog(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getOperatingsystem() {
        return operatingsystem;
    }

    public void setOperatingsystem(String operatingsystem) {
        this.operatingsystem = operatingsystem;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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
        if (!(object instanceof Activitylog)) {
            return false;
        }
        Activitylog other = (Activitylog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Activitylog[ id=" + id + " ]";
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(String entrytime) {
        this.entrytime = entrytime;
    }

}
