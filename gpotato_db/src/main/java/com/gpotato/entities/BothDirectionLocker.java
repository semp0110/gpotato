package com.gpotato.entities;

import javax.persistence.*;

/**
 * Created by hirang on 2017-08-28.
 */
@Entity
@Table(name = "tbl_both_locker")
public class BothDirectionLocker
{
    @Id
    @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private BothDirectionMember member;

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

    public BothDirectionMember getMember()
    {
        return member;
    }

    public void setMember(BothDirectionMember member)
    {
        this.member = member;
    }
}
