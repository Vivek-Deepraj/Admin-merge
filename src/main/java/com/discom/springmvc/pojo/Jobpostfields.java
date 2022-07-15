package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "jobpostfields")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Jobpostfields.findAll", query = "SELECT d FROM Jobpostfields d"),
        @NamedQuery(name = "Jobpostfields.findById", query = "SELECT d FROM Jobpostfields d WHERE d.id = :id"),
        @NamedQuery(name = "Jobpostfields.findByLabelName", query = "SELECT d FROM Jobpostfields d WHERE d.labelName = :labelName"),
        @NamedQuery(name = "Jobpostfields.findByFieldName", query = "SELECT d FROM Jobpostfields d WHERE d.fieldName = :fieldName"),
        @NamedQuery(name = "Jobpostfields.findByFieldType", query = "SELECT d FROM Jobpostfields d WHERE d.fieldType = :fieldType"),
        @NamedQuery(name = "Jobpostfields.findByFieldReq", query = "SELECT d FROM Jobpostfields d WHERE d.fieldReq = :fieldReq"),
        @NamedQuery(name = "Jobpostfields.findByCsValues", query = "SELECT d FROM Jobpostfields d WHERE d.csValues = :csValues")
})
public class Jobpostfields
        implements Serializable {

    final static Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "labelName")
    private String labelName;
    @Column(name = "fieldName")
    private String fieldName;
    @Column(name = "fieldType")
    private String fieldType;
    @Column(name = "fieldReq")
    private String fieldReq;
    @Column(name = "csValues")
    private String csValues;

    public Jobpostfields() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldReq() {
        return fieldReq;
    }

    public void setFieldReq(String fieldReq) {
        this.fieldReq = fieldReq;
    }

    public String getCsValues() {
        return csValues;
    }

    public void setCsValues(String csValues) {
        this.csValues = csValues;
    }

}
