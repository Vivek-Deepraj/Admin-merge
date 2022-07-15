package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "plans")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Plans.findAll", query = "SELECT d FROM Plans d"),
        @NamedQuery(name = "Plans.findById", query = "SELECT d FROM Plans d WHERE d.id = :id"),
        @NamedQuery(name = "Plans.findByPlanName", query = "SELECT d FROM Plans d WHERE d.planName = :planName"),
        @NamedQuery(name = "Plans.findByJobPost", query = "SELECT d FROM Plans d WHERE d.jobPost = :jobPost"),
        @NamedQuery(name = "Plans.findByResumeSearch", query = "SELECT d FROM Plans d WHERE d.resumeSearch = :resumeSearch")
})
public class Plans
        implements Serializable {

    final static Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "planName")
    private String planName;
    @Column(name = "jobPost")
    private Integer jobPost;
    @Column(name = "resumeSearch")
    private Integer resumeSearch;

    public Plans() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Integer getJobPost() {
        return jobPost;
    }

    public void setJobPost(Integer jobPost) {
        this.jobPost = jobPost;
    }

    public Integer getResumeSearch() {
        return resumeSearch;
    }

    public void setResumeSearch(Integer resumeSearch) {
        this.resumeSearch = resumeSearch;
    }

}
