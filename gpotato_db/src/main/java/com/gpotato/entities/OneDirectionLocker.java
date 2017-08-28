package com.gpotato.entities;

import javax.persistence.*;

/**
 * Created by hirang on 2017-08-28.
 */
@Entity
@Table(name = "tbl_one_locker")
public class OneDirectionLocker
{
    @Id @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
