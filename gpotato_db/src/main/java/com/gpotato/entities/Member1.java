package com.gpotato.entities;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.lang.annotation.Inherited;

/**
 * Created by hirang on 2017-08-14.
 */
@Entity
@Table(name="tbl_members1")
public class Member1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String username;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "IsMarried")
    private Boolean married;

    @Column(name = "Con")
    private Integer con;

    @Column(name = "IntegerToString")
    private Integer  its;

    @Column(name = "StringToInteger")
    private Integer sti;

    @Column(name = "RoleType")
    @Enumerated(EnumType.STRING)
    private RoleType roletype;

    public RoleType getRoletype()
    {
        return roletype;
    }

    public void setRoletype(RoleType roletype)
    {
        this.roletype = roletype;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getSti()
    {
        return sti;
    }

    public void setSti(Integer sti)
    {
        this.sti = sti;
    }

    public Integer getIts()
    {
        return its;
    }

    public void setIts(Integer its)
    {
        this.its = its;
    }

    public Boolean getMarried()
    {
        return married;
    }

    public void setMarried(Boolean married)
    {
        this.married = married;
    }

    public Integer getCon()
    {
        return con;
    }

    public void setCon(Integer con)
    {
        this.con = con;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public enum RoleType{
        ADMIN,
        USER,
        GUEST
    }
}

