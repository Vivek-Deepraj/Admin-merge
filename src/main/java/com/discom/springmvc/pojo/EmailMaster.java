
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author admin
 */
@Entity
@Table(name = "email_master")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "EmailMaster.findAll", query = "SELECT e FROM EmailMaster e"),
        @NamedQuery(name = "EmailMaster.findByEmailMasterId", query = "SELECT e FROM EmailMaster e WHERE e.emailMasterId = :emailMasterId"),
        @NamedQuery(name = "EmailMaster.findByTitle", query = "SELECT e FROM EmailMaster e WHERE e.title = :title"),
        @NamedQuery(name = "EmailMaster.findBySubject", query = "SELECT e FROM EmailMaster e WHERE e.subject = :subject"),
        @NamedQuery(name = "EmailMaster.findByMessage", query = "SELECT e FROM EmailMaster e WHERE e.message = :message"),
        @NamedQuery(name = "EmailMaster.findBySignature", query = "SELECT e FROM EmailMaster e WHERE e.signature = :signature"),
        @NamedQuery(name = "EmailMaster.findByFrom", query = "SELECT e FROM EmailMaster e WHERE e.from = :from"),
        @NamedQuery(name = "EmailMaster.findByCc", query = "SELECT e FROM EmailMaster e WHERE e.cc = :cc")})
public class EmailMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "email_master_id")
    private Long emailMasterId;
    @Column(name = "title")
    private String title;
    @Column(name = "subject")
    private String subject;
    @Column(name = "message")
    private String message;
    @Column(name = "signature")
    private String signature;
    @Column(name = "from")
    private String from;
    @Column(name = "cc")
    private String cc;
    @Column(name = "to")
    private String to;
    @Column(name = "setting")
    private String setting;


    public EmailMaster() {
    }

    public EmailMaster(Long emailMasterId) {
        this.emailMasterId = emailMasterId;
    }

    public Long getEmailMasterId() {
        return emailMasterId;
    }

    public void setEmailMasterId(Long emailMasterId) {
        this.emailMasterId = emailMasterId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailMasterId != null ? emailMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailMaster)) {
            return false;
        }
        EmailMaster other = (EmailMaster) object;
        if ((this.emailMasterId == null && other.emailMasterId != null) || (this.emailMasterId != null && !this.emailMasterId.equals(other.emailMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discom.springmvc.pojo.EmailMaster[ emailMasterId=" + emailMasterId + " ]";
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

}
