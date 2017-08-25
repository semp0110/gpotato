package com.gpotato.entities;

import javax.persistence.*;
import java.lang.annotation.Inherited;

/**
 * Created by hirang on 2017-08-14.
 */
@Entity
@Table(name="tbl_members")
public class Member {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String username;

    @Column(name = "age")
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
