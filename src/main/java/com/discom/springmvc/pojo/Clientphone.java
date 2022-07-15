package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


/**
 * @author bijendra.chauhan
 */
@Entity
@Table(name = "clientphone")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Clientphone.findAll", query = "SELECT c FROM Clientphone c"),
        @NamedQuery(name = "Clientphone.findByPhoneid", query = "SELECT c FROM Clientphone c WHERE c.phoneid = :phoneid"),
        @NamedQuery(name = "Clientphone.findByCompanymasterid", query = "SELECT c FROM Clientphone c WHERE c.companymasterid = :companymasterid"),
        @NamedQuery(name = "Clientphone.findByPhoneno", query = "SELECT c FROM Clientphone c WHERE c.phoneno = :phoneno")})
public class Clientphone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "phoneid", nullable = false)
    private Integer phoneid;

    @Column(name = "companymasterid", length = 233)
    private String companymasterid;

    @Column(name = "phoneno", length = 20)
    private String phoneno;

    public Clientphone() {
    }

    public Clientphone(Integer phoneid) {
        this.phoneid = phoneid;
    }

    public Integer getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(Integer phoneid) {
        this.phoneid = phoneid;
    }

    public String getCompanymasterid() {
        return companymasterid;
    }

    public void setCompanymasterid(String companymasterid) {
        this.companymasterid = companymasterid;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phoneid != null ? phoneid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientphone)) {
            return false;
        }
        Clientphone other = (Clientphone) object;
        if ((this.phoneid == null && other.phoneid != null) || (this.phoneid != null && !this.phoneid.equals(other.phoneid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ptc.common.pojo.Clientphone[ phoneid=" + phoneid + " ]";
    }

}
