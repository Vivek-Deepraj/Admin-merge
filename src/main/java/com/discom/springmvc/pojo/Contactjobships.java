package com.discom.springmvc.pojo;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author admin
 */
@Entity
@Table(name = "contactjobships")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Contactjobships.findAll", query = "SELECT c FROM Contactjobships c"),
        @NamedQuery(name = "Contactjobships.findById", query = "SELECT c FROM Contactjobships c WHERE c.id = :id"),
        @NamedQuery(name = "Contactjobships.findByUserid", query = "SELECT c FROM Contactjobships c WHERE c.userid = :userid"),
        @NamedQuery(name = "Contactjobships.findByTemplatecode", query = "SELECT c FROM Contactjobships c WHERE c.templatecode = :templatecode"),
        @NamedQuery(name = "Contactjobships.findByTemplatetype", query = "SELECT c FROM Contactjobships c WHERE c.templatetype = :templatetype"),
        @NamedQuery(name = "Contactjobships.findByCreatedby", query = "SELECT c FROM Contactjobships c WHERE c.createdby = :createdby"),
        @NamedQuery(name = "Contactjobships.findByCreatedon", query = "SELECT c FROM Contactjobships c WHERE c.createdon = :createdon"),
        @NamedQuery(name = "Contactjobships.findByUpdatedby", query = "SELECT c FROM Contactjobships c WHERE c.updatedby = :updatedby"),
        @NamedQuery(name = "Contactjobships.findByUpdatedon", query = "SELECT c FROM Contactjobships c WHERE c.updatedon = :updatedon")})
public class Contactjobships implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "userid")
    private String userid;
    @Column(name = "templatecode")
    private String templatecode;
    @Column(name = "templatetype")
    private String templatetype;
    @Lob
    @Type(type = "com.discom.springmvc.pojo.JsonType",
            parameters = {
                    @Parameter(
                            name = "classType",
                            value = "java.util.LinkedHashMap"
                    )
            })
    @Column(name = "data")
    private Object data;
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "createdon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;
    @Column(name = "updatedby")
    private String updatedby;
    @Column(name = "updatedon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedon;

    public Contactjobships() {
    }

    public Contactjobships(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTemplatecode() {
        return templatecode;
    }

    public void setTemplatecode(String templatecode) {
        this.templatecode = templatecode;
    }

    public String getTemplatetype() {
        return templatetype;
    }

    public void setTemplatetype(String templatetype) {
        this.templatetype = templatetype;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contactjobships)) {
            return false;
        }
        Contactjobships other = (Contactjobships) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Contactjobships[ id=" + id + " ]";
    }

}
