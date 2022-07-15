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
@Table(name = "news")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n"),
        @NamedQuery(name = "News.findById", query = "SELECT n FROM News n WHERE n.id = :id"),
        @NamedQuery(name = "News.findByCategoryname", query = "SELECT n FROM News n WHERE n.categoryname = :categoryname"),
        @NamedQuery(name = "News.findByHeadline", query = "SELECT n FROM News n WHERE n.headline = :headline"),
        @NamedQuery(name = "News.findByNewsurl", query = "SELECT n FROM News n WHERE n.newsurl = :newsurl"),
        @NamedQuery(name = "News.findByBody", query = "SELECT n FROM News n WHERE n.body = :body"),
        @NamedQuery(name = "News.findByDescription", query = "SELECT n FROM News n WHERE n.description = :description"),
        @NamedQuery(name = "News.findByIsactive", query = "SELECT n FROM News n WHERE n.isactive = :isactive"),
        @NamedQuery(name = "News.findByCreatedon", query = "SELECT n FROM News n WHERE n.createdon = :createdon"),
        @NamedQuery(name = "News.findByCreatedby", query = "SELECT n FROM News n WHERE n.createdby = :createdby"),
        @NamedQuery(name = "News.findByUpdatedon", query = "SELECT n FROM News n WHERE n.updatedon = :updatedon"),
        @NamedQuery(name = "News.findByUpdatedby", query = "SELECT n FROM News n WHERE n.updatedby = :updatedby")})
public class News implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "categoryname")
    private String categoryname;
    @Column(name = "headline")
    private String headline;
    @Column(name = "newsurl")
    private String newsurl;
    @Column(name = "body")
    private String body;
    @Column(name = "description")
    private String description;
    @Column(name = "isactive")
    private Boolean isactive;
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

    public News() {
    }

    public News(Integer id) {
        this.id = id;
    }

    public News(Integer id, Date createdon, Date updatedon) {
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

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getNewsurl() {
        return newsurl;
    }

    public void setNewsurl(String newsurl) {
        this.newsurl = newsurl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
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
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.News[ id=" + id + " ]";
    }

}
