package com.discom.springmvc.model;

public class CompanyJobPostResponse {

    private Integer id;
    private String com_name;
    private String job_post_start_date;
    private String job_post_end_date;
    private String createdby;
    private String createdon;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getJob_post_start_date() {
        return job_post_start_date;
    }

    public void setJob_post_start_date(String job_post_start_date) {
        this.job_post_start_date = job_post_start_date;
    }

    public String getJob_post_end_date() {
        return job_post_end_date;
    }

    public void setJob_post_end_date(String job_post_end_date) {
        this.job_post_end_date = job_post_end_date;
    }

    public String getCreatedon() {
        return createdon;
    }

    public void setCreatedon(String createdon) {
        this.createdon = createdon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
