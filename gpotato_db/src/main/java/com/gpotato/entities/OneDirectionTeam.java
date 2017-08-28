package com.gpotato.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hirang on 2017-08-28.
 */

@Entity
@Table(name = "tbl_one_team")
public class OneDirectionTeam
{
    @Id
    @Column(name = "TEAM_ID")
    private String id;

    private String name;

    public OneDirectionTeam()
    {
    }

    public OneDirectionTeam(String id, String name)
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
}
