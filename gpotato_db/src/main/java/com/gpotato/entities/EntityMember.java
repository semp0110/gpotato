package com.gpotato.entities;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.lang.annotation.Inherited;
import java.util.Date;

/**
 * Created by hirang on 2017-08-14.
 */
@Entity
@Table(name="tbl_entity_member", uniqueConstraints = {@UniqueConstraint( //추가 //**
        name = "NAME_AGE_UNIQUE",
        columnNames = {"name", "age"} )})
public class EntityMember {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", nullable = false, length = 10)
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Column(name = "TimeStampDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tsDate;

    @Column(name = "DateDate")
    @Temporal(TemporalType.DATE)
    private Date dDate;

    @Column(name = "TimeDate")
    @Temporal(TemporalType.TIME)
    private Date tDate;

    @Lob
    @Column(name = "LobString")
    private String lobString;

    @Lob
    @Column(name = "LobByte")
    private Byte[]  lobByte;

    @Transient
    private String firstName;

    @Transient
    private String lastName;

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
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

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }


    public Date getTsDate()
    {
        return tsDate;
    }

    public void setTsDate(Date tsDate)
    {
        this.tsDate = tsDate;
    }

    public Date getdDate()
    {
        return dDate;
    }

    public void setdDate(Date dDate)
    {
        this.dDate = dDate;
    }

    public Date gettDate()
    {
        return tDate;
    }

    public void settDate(Date tDate)
    {
        this.tDate = tDate;
    }

    public String getLobString()
    {
        return lobString;
    }

    public void setLobString(String lobString)
    {
        this.lobString = lobString;
    }

    public Byte[] getLobByte()
    {
        return lobByte;
    }

    public void setLobByte(Byte[] lobByte)
    {
        this.lobByte = lobByte;
    }
}

