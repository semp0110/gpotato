package com.gpotato.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hirang on 2017-08-28.
 */
@Entity
@Table(name = "tbl_one_member")
public class OneDirectionMember
{
    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private OneDirectionTeam team;

    @OneToOne
    @JoinColumn(name ="LOCKER_ID")
    private OneDirectionLocker locker;

    @ManyToMany
    @JoinTable(name = "tbl_one_member_product",
            joinColumns = @JoinColumn(name = "MEMBER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private List<OneDirectionProduct> products = new ArrayList<OneDirectionProduct>();

    public OneDirectionMember()
    {
    }

    public OneDirectionMember(String id, String username)
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

    public OneDirectionTeam getTeam()
    {
        return team;
    }

    public void setTeam(OneDirectionTeam team)
    {
        this.team = team;
    }

    public OneDirectionLocker getLocker()
    {
        return locker;
    }

    public void setLocker(OneDirectionLocker locker)
    {
        this.locker = locker;
    }

    public List<OneDirectionProduct> getProducts()
    {
        return products;
    }

    public void getProducts(List<OneDirectionProduct> products)
    {
        this.products = products;
    }

    public void addProduct(OneDirectionProduct product)
    {
        products.add(product);
    }

}
