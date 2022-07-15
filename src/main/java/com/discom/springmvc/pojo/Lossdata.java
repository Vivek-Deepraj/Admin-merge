package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "lossdata")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Lossdata.findAll", query = "SELECT d FROM Lossdata d"),
        @NamedQuery(name = "Lossdata.findById", query = "SELECT d FROM Lossdata d WHERE d.id = :id"),
        @NamedQuery(name = "Lossdata.findByIssue_date", query = "SELECT d FROM Lossdata d WHERE d.issue_date = :issue_date"),
        @NamedQuery(name = "Lossdata.findByStart_date", query = "SELECT d FROM Lossdata d WHERE d.start_date = :start_date"),
        @NamedQuery(name = "Lossdata.findByEnd_date", query = "SELECT d FROM Lossdata d WHERE d.end_date = :end_date"),
        @NamedQuery(name = "Lossdata.findByLoss_type", query = "SELECT d FROM Lossdata d WHERE d.loss_type = :loss_type"),
        @NamedQuery(name = "Lossdata.findByFile_name", query = "SELECT d FROM Lossdata d WHERE d.file_name = :file_name"),
        @NamedQuery(name = "Lossdata.findByStatus", query = "SELECT d FROM Lossdata d WHERE d.status = :status")
})
public class Lossdata
        implements Serializable {

    final static Long serialVersionUID = 1L;
    @Transient
    Integer remainingExpiryDay;
    @Transient
    String issue_date1, start_date1, end_date1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "issue_date")
    @Temporal(TemporalType.DATE)
    private Date issue_date;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date start_date;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date end_date;
    @Column(name = "loss_type")
    private String loss_type;
    @Column(name = "file_name")
    private String file_name;
    @Column(name = "status")
    private String status;

    public Lossdata() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getLoss_type() {
        return loss_type;
    }

    public void setLoss_type(String loss_type) {
        this.loss_type = loss_type;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRemainingExpiryDay() {
        return remainingExpiryDay;
    }

    public void setRemainingExpiryDay(Integer remainingExpiryDay) {
        this.remainingExpiryDay = remainingExpiryDay;
    }

    public String getIssue_date1() {
        return issue_date1;
    }

    public void setIssue_date1(String issue_date1) {
        this.issue_date1 = issue_date1;
    }

    public String getStart_date1() {
        return start_date1;
    }

    public void setStart_date1(String start_date1) {
        this.start_date1 = start_date1;
    }

    public String getEnd_date1() {
        return end_date1;
    }

    public void setEnd_date1(String end_date1) {
        this.end_date1 = end_date1;
    }

}
