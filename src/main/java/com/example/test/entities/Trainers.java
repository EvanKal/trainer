/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.test.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Los_e
 */
@Entity
@Table(name = "trainers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trainers.findAll", query = "SELECT t FROM Trainers t")
    , @NamedQuery(name = "Trainers.findByTrainerid", query = "SELECT t FROM Trainers t WHERE t.trainerid = :trainerid")
    , @NamedQuery(name = "Trainers.findByFirstname", query = "SELECT t FROM Trainers t WHERE t.firstname = :firstname")
    , @NamedQuery(name = "Trainers.findByLastname", query = "SELECT t FROM Trainers t WHERE t.lastname = :lastname")
    , @NamedQuery(name = "Trainers.findBySubject", query = "SELECT t FROM Trainers t WHERE t.subject = :subject")})
public class Trainers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "trainerid")
    private Integer trainerid;
    @Basic(optional = false)
    @NotNull
//    @Size(min = 1, max = 100)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @NotNull
//    @Size(min = 1, max = 100)
    @Column(name = "lastname")
    private String lastname;
//    @Size(max = 100)
    @Column(name = "subject")
    private String subject;
    @JoinColumn(name = "trainerid", referencedColumnName = "userid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Users users;

    public Trainers() {
    }

    public Trainers(Integer trainerid) {
        this.trainerid = trainerid;
    }

    public Trainers(Integer trainerid, String firstname, String lastname) {
        this.trainerid = trainerid;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getTrainerid() {
        return trainerid;
    }

    public void setTrainerid(Integer trainerid) {
        this.trainerid = trainerid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trainerid != null ? trainerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trainers)) {
            return false;
        }
        Trainers other = (Trainers) object;
        if ((this.trainerid == null && other.trainerid != null) || (this.trainerid != null && !this.trainerid.equals(other.trainerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.test.entities.Trainers[ trainerid=" + trainerid + " ]";
    }
    
}
