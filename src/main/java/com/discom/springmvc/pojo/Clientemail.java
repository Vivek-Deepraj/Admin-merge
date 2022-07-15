package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Entity
@Table(name = "clientemail")
@XmlRootElement

public class Clientemail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "emailid", nullable = false)
    private Integer emailid;

    @Column(name = "companymasterid", length = 233)
    private String companymasterid;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation

    @Column(name = "email", length = 233)
    private String email;

    public Clientemail() {
    }

    public Clientemail(Integer emailid) {
        this.emailid = emailid;
    }

    public Integer getEmailid() {
        return emailid;
    }

    public void setEmailid(Integer emailid) {
        this.emailid = emailid;
    }

    public String getCompanymasterid() {
        return companymasterid;
    }

    public void setCompanymasterid(String companymasterid) {
        this.companymasterid = companymasterid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailid != null ? emailid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientemail)) {
            return false;
        }
        Clientemail other = (Clientemail) object;
        if ((this.emailid == null && other.emailid != null) || (this.emailid != null && !this.emailid.equals(other.emailid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ptc.common.pojo.Clientemail[ emailid=" + emailid + " ]";
    }

}
