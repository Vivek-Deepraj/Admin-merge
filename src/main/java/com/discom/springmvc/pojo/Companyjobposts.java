/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discom.springmvc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author admin
 */
@Entity
@Table(name = "companyjobposts")
@XmlRootElement
public class Companyjobposts implements Serializable {
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

    @Column(name = "isactive")
    private boolean isactive;

    @Column(name = "com_name")
    private Integer com_name;

    @Column(name = "job_post_start_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date job_post_start_date;

    @Column(name = "job_post_end_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date job_post_end_date;

    /*@Lob
    @Type(type = "com.discom.springmvc.pojo.JsonType", parameters = {
            @Parameter(name = "classType", value = "java.util.LinkedHashMap") })

    @Column(name = "data")
    private Object data;*/
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

    public Companyjobposts() {
    }

    public Companyjobposts(Integer id) {
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

	/*public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}*/


    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Integer getCom_name() {
        return com_name;
    }

    public void setCom_name(Integer com_name) {
        this.com_name = com_name;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public Date getJob_post_start_date() {
        return job_post_start_date;
    }

    public void setJob_post_start_date(Date job_post_start_date) {
        this.job_post_start_date = job_post_start_date;
    }

    public Date getJob_post_end_date() {
        return job_post_end_date;
    }

    public void setJob_post_end_date(Date job_post_end_date) {
        this.job_post_end_date = job_post_end_date;
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
        if (!(object instanceof Companyjobposts)) {
            return false;
        }
        Companyjobposts other = (Companyjobposts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Companyjobposts[ id=" + id + " ]";
    }

}
