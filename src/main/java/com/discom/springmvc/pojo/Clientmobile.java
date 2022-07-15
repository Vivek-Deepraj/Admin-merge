package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.validation.constraints.Null;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Entity
@Table(name = "clientmobile")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Clientmobile.findAll", query = "SELECT c FROM Clientmobile c"),
        @NamedQuery(name = "Clientmobile.findByMobileid", query = "SELECT c FROM Clientmobile c WHERE c.mobileid = :mobileid"),
        @NamedQuery(name = "Clientmobile.findByCompanymasterid", query = "SELECT c FROM Clientmobile c WHERE c.companymasterid = :companymasterid"),
        @NamedQuery(name = "Clientmobile.findByMobileno", query = "SELECT c FROM Clientmobile c WHERE c.mobileno = :mobileno")})
public class Clientmobile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Null
    @Column(name = "mobileid", nullable = false)
    private Integer mobileid;

    @Column(name = "companymasterid", length = 233)
    private String companymasterid;

    @Column(name = "mobileno", length = 20)
    private String mobileno;

    public Clientmobile() {
    }

    public Clientmobile(Integer mobileid) {
        this.mobileid = mobileid;
    }

    public Integer getMobileid() {
        return mobileid;
    }

    public void setMobileid(Integer mobileid) {
        this.mobileid = mobileid;
    }

    public String getCompanymasterid() {
        return companymasterid;
    }

    public void setCompanymasterid(String companymasterid) {
        this.companymasterid = companymasterid;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mobileid != null ? mobileid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientmobile)) {
            return false;
        }
        Clientmobile other = (Clientmobile) object;
        if ((this.mobileid == null && other.mobileid != null) || (this.mobileid != null && !this.mobileid.equals(other.mobileid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ptc.common.pojo.Clientmobile[ mobileid=" + mobileid + " ]";
    }

}

