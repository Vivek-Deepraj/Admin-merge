package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


/**
 * @author bijendra.chauhan
 */
@Entity
@Table(name = "clientfax")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Clientfax.findAll", query = "SELECT c FROM Clientfax c"),
        @NamedQuery(name = "Clientfax.findByFaxid", query = "SELECT c FROM Clientfax c WHERE c.faxid = :faxid"),
        @NamedQuery(name = "Clientfax.findByCompanymasterid", query = "SELECT c FROM Clientfax c WHERE c.companymasterid = :companymasterid"),
        @NamedQuery(name = "Clientfax.findByFaxno", query = "SELECT c FROM Clientfax c WHERE c.faxno = :faxno")})
public class Clientfax implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "faxid", nullable = false)
    private Integer faxid;

    @Column(name = "companymasterid", length = 233)
    private String companymasterid;

    @Column(name = "faxno", length = 20)
    private String faxno;

    public Clientfax() {
    }

    public Clientfax(Integer faxid) {
        this.faxid = faxid;
    }

    public Integer getFaxid() {
        return faxid;
    }

    public void setFaxid(Integer faxid) {
        this.faxid = faxid;
    }

    public String getCompanymasterid() {
        return companymasterid;
    }

    public void setCompanymasterid(String companymasterid) {
        this.companymasterid = companymasterid;
    }

    public String getFaxno() {
        return faxno;
    }

    public void setFaxno(String faxno) {
        this.faxno = faxno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (faxid != null ? faxid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientfax)) {
            return false;
        }
        Clientfax other = (Clientfax) object;
        if ((this.faxid == null && other.faxid != null) || (this.faxid != null && !this.faxid.equals(other.faxid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ptc.common.pojo.Clientfax[ faxid=" + faxid + " ]";
    }

}

