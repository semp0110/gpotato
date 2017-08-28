package com.gpotato.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hirang on 2017-08-28.
 */
@Entity
@Table(name = "tbl_both_team")
public class BothDirectionTeam
{
    @Id
    @Column(name = "TEAM_ID")
    private String id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<BothDirectionMember> members = new ArrayList<BothDirectionMember>();

    public BothDirectionTeam()
    {
    }

    public BothDirectionTeam(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
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

    public List<BothDirectionMember> getMembers()
    {
        return members;
    }

    public void setMembers(List<BothDirectionMember> members)
    {
        this.members = members;
    }
}

