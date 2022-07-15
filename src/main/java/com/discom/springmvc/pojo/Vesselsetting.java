package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "vesselsetting")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Vesselsetting.findAll", query = "SELECT d FROM Vesselsetting d"),
        @NamedQuery(name = "Vesselsetting.findById", query = "SELECT d FROM Vesselsetting d WHERE d.id = :id"),
        @NamedQuery(name = "Vesselsetting.findByVesselShipType", query = "SELECT d FROM Vesselsetting d WHERE d.vesselShipType = :vesselShipType")
})
public class Vesselsetting
        implements Serializable {

    final static Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "vesselShipType")
    private String vesselShipType;

    public Vesselsetting() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVesselShipType() {
        return vesselShipType;
    }

    public void setVesselShipType(String vesselShipType) {
        this.vesselShipType = vesselShipType;
    }

}
