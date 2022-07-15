package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "countrymaster")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Countrymaster.findAll", query = "SELECT d FROM Countrymaster d"),
        @NamedQuery(name = "Countrymaster.findById", query = "SELECT d FROM Countrymaster d WHERE d.id = :id"),
        @NamedQuery(name = "Countrymaster.findByCountrycode", query = "SELECT d FROM Countrymaster d WHERE d.countrycode = :countrycode"),
        @NamedQuery(name = "Countrymaster.findByCountryname", query = "SELECT d FROM Countrymaster d WHERE d.countryname = :countryname"),
        @NamedQuery(name = "Countrymaster.findByCountryservice", query = "SELECT d FROM Countrymaster d WHERE d.countryservice = :countryservice")
})
public class Countrymaster
        implements Serializable {

    final static Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "countrycode")
    private String countrycode;
    @Basic(optional = false)
    @Column(name = "countryname")
    private String countryname;
    @Basic(optional = false)
    @Column(name = "countryservice")
    private Boolean countryservice;

    public Countrymaster() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public Boolean getCountryservice() {
        return countryservice;
    }

    public void setCountryservice(Boolean countryservice) {
        this.countryservice = countryservice;
    }

}
