package com.gpotato.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hirang on 2017-08-28.
 */
@Entity
@Table(name = "tbl_both_member")
public class BothDirectionMember
{
    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private BothDirectionTeam team;

    @OneToOne
    @JoinColumn(name ="LOCKER_ID")
    private OneDirectionLocker locker;

    @ManyToMany
    @JoinTable(name = "tbl_both_member_product",
            joinColumns = @JoinColumn(name = "MEMBER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private List<BothDirectionProduct> products = new ArrayList<BothDirectionProduct>();

    public BothDirectionMember()
    {
    }

    public BothDirectionMember(String id, String username)
    {
        this.id = id;
        this.username = username;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public BothDirectionTeam getTeam()
    {
        return team;
    }

    public void setTeam(BothDirectionTeam team)
    {
        //기존 team과 관계를 제거
        if(this.team != null)
            this.team.getMembers().remove(this);

        this.team = team;
        team.getMembers().add(this);
    }

    public OneDirectionLocker getLocker()
    {
        return locker;
    }

    public void setLocker(OneDirectionLocker locker)
    {
        this.locker = locker;
    }

    public List<BothDirectionProduct> getProducts()
    {
        return products;
    }

    public void setProducts(List<BothDirectionProduct> products)
    {
        this.products = products;
    }

    public void addProduct(BothDirectionProduct product)
    {
        products.add(product);
        product.getMembers().add(this);
    }

}

