package com.gpotato.entities;

import javax.persistence.*;

/**
 * Created by hirang on 2017. 8. 27..
 */
@Entity
@Table(name = "tbl_jpa_member")
public class Members {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String username;

    @ManyToOne
    //@Column(name = "team_id")
    @JoinColumn(name = "team_id")
    private Teams team;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Teams getTeam() {
        return team;
    }

    public void setTeam(Teams team) {
        if(this.team != null)
            this.team.getMembers().remove(this);
        this.team = team;
        team.getMembers().add(this);
    }
}
