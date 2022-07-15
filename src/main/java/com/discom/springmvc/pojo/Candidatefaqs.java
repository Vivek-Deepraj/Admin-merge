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
@Table(name = "candidatefaqs")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Candidatefaqs.findAll", query = "SELECT c FROM Candidatefaqs c"),
        @NamedQuery(name = "Candidatefaqs.findById", query = "SELECT c FROM Candidatefaqs c WHERE c.id = :id"),
        @NamedQuery(name = "Candidatefaqs.findByQuestion", query = "SELECT c FROM Candidatefaqs c WHERE c.question = :question"),
        @NamedQuery(name = "Candidatefaqs.findByAnswer", query = "SELECT c FROM Candidatefaqs c WHERE c.answer = :answer"),
        @NamedQuery(name = "Candidatefaqs.findByCreatedby", query = "SELECT c FROM Candidatefaqs c WHERE c.createdby = :createdby"),
        @NamedQuery(name = "Candidatefaqs.findByCreatedon", query = "SELECT c FROM Candidatefaqs c WHERE c.createdon = :createdon"),
        @NamedQuery(name = "Candidatefaqs.findByUpdatedby", query = "SELECT c FROM Candidatefaqs c WHERE c.updatedby = :updatedby"),
        @NamedQuery(name = "Candidatefaqs.findByUpdatedon", query = "SELECT c FROM Candidatefaqs c WHERE c.updatedon = :updatedon")})
public class Candidatefaqs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "question")
    private String question;
    @Column(name = "answer")
    private String answer;
    @Basic(optional = false)
    @Column(name = "createdby")
    private String createdby;
    @Basic(optional = false)
    @Column(name = "createdon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;
    @Basic(optional = false)
    @Column(name = "updatedby")
    private String updatedby;
    @Basic(optional = false)
    @Column(name = "updatedon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedon;

    public Candidatefaqs() {
    }

    public Candidatefaqs(Long id) {
        this.id = id;
    }

    public Candidatefaqs(Long id, String createdby, Date createdon, String updatedby, Date updatedon) {
        this.id = id;
        this.createdby = createdby;
        this.createdon = createdon;
        this.updatedby = updatedby;
        this.updatedon = updatedon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
        if (!(object instanceof Candidatefaqs)) {
            return false;
        }
        Candidatefaqs other = (Candidatefaqs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.Candidatefaqs[ id=" + id + " ]";
    }

}
