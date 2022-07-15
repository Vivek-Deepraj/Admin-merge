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
@Table(name = "studenttestentity")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Studenttestentity.findAll", query = "SELECT s FROM Studenttestentity s"),
        @NamedQuery(name = "Studenttestentity.findById", query = "SELECT s FROM Studenttestentity s WHERE s.id = :id"),
        @NamedQuery(name = "Studenttestentity.findByName", query = "SELECT s FROM Studenttestentity s WHERE s.name = :name"),
        @NamedQuery(name = "Studenttestentity.findByAge", query = "SELECT s FROM Studenttestentity s WHERE s.age = :age"),
        @NamedQuery(name = "Studenttestentity.findByCity", query = "SELECT s FROM Studenttestentity s WHERE s.city = :city"),
        @NamedQuery(name = "Studenttestentity.findByPincode", query = "SELECT s FROM Studenttestentity s WHERE s.pincode = :pincode"),
        @NamedQuery(name = "Studenttestentity.findByCreatedon", query = "SELECT s FROM Studenttestentity s WHERE s.createdon = :createdon"),
        @NamedQuery(name = "Studenttestentity.findByCreatedby", query = "SELECT s FROM Studenttestentity s WHERE s.createdby = :createdby"),
        @NamedQuery(name = "Studenttestentity.findByUpdatedon", query = "SELECT s FROM Studenttestentity s WHERE s.updatedon = :updatedon"),
        @NamedQuery(name = "Studenttestentity.findByUpdatedby", query = "SELECT s FROM Studenttestentity s WHERE s.updatedby = :updatedby")})
public class Studenttestentity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private String age;
    @Column(name = "city")
    private String city;
    @Column(name = "pincode")
    private String pincode;
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

    public Studenttestentity() {
    }

    public Studenttestentity(Integer id) {
        this.id = id;
    }

    public Studenttestentity(Integer id, Date createdon, Date updatedon) {
        this.id = id;
        this.createdon = createdon;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
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
        if (!(object instanceof Studenttestentity)) {
            return false;
        }
        Studenttestentity other = (Studenttestentity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Studenttestentity[ id=" + id + " ]";
    }

}
