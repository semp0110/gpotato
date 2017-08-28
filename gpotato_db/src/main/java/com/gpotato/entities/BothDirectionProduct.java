package com.gpotato.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by hirang on 2017-08-28.
 */
@Entity
@Table(name = "tbl_both_product")
public class BothDirectionProduct
{
    @Id @Column(name = "PRODUCT_ID")
    private String id;

    @ManyToMany(mappedBy = "products")
    private List<BothDirectionMember> members;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
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
