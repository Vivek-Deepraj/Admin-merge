package com.discom.springmvc.model;

public class JobPostUniqueDetails {

    private Integer id;
    private Integer flagValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlagValue() {
        return flagValue;
    }

    public void setFlagValue(Integer flagValue) {
        this.flagValue = flagValue;
    }

    @Override
    public int hashCode() {
        int h = (id + " " + flagValue).hashCode();
        return h;
    }

    @Override
    public boolean equals(Object obj) {
        JobPostUniqueDetails post2 = (JobPostUniqueDetails) obj;
        if (this.hashCode() == post2.hashCode())
            return true;
        else
            return false;
    }

}
