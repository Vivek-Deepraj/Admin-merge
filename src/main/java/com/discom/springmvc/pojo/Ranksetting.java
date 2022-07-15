package com.discom.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "ranksetting")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Ranksetting.findAll", query = "SELECT d FROM Ranksetting d"),
        @NamedQuery(name = "Ranksetting.findById", query = "SELECT d FROM Ranksetting d WHERE d.id = :id"),
        @NamedQuery(name = "Ranksetting.findByRank", query = "SELECT d FROM Ranksetting d WHERE d.rank = :rank")
})
public class Ranksetting
        implements Serializable {

    final static Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "rank")
    private String rank;

    public Ranksetting() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

}
