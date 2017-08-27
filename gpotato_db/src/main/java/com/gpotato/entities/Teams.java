package com.gpotato.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hirang on 2017. 8. 27..
 */
@Entity
@Table(name = "tbl_jpa_team")
public class Teams {

    public Teams() {
    }

    public Teams(String teamname) {
        this.teamname = teamname;
    }

    @Id
    @Column(name = "team_id")
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String teamname;

    @OneToMany(mappedBy = "team")
    private List<Members> members = new ArrayList<Members>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public List<Members> getMembers() {
        return members;
    }

    public void setMembers(List<Members> members) {
        this.members = members;
    }
}
