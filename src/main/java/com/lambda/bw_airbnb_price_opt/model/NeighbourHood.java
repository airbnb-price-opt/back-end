package com.lambda.bw_airbnb_price_opt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "neighbourhoods")
public class NeighbourHood extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long neighbourhood_id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "neighbourhood_group_id",
            nullable = false)
    @JsonIgnoreProperties({"neighbourHoods", "hibernateLazyInitializer"})
    private NeighbourHoodGroup neighbourHoodGroup;

    @OneToMany(mappedBy = "neighbourHood",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("neighbourHood")
    private List<Listing> listings = new ArrayList<>();

    public NeighbourHood() {
    }

    public NeighbourHood(String name, NeighbourHoodGroup neighbourHoodGroup) {
        this.name = name;
        this.neighbourHoodGroup = neighbourHoodGroup;
    }

    public NeighbourHoodGroup getNeighbourHoodGroup() {
        return neighbourHoodGroup;
    }

    public void setNeighbourHoodGroup(NeighbourHoodGroup neighbourHoodGroup) {
        this.neighbourHoodGroup = neighbourHoodGroup;
    }

    public long getNeighbourhood_id() {
        return neighbourhood_id;
    }

    public void setNeighbourhood_id(long neighbourhood_id) {
        this.neighbourhood_id = neighbourhood_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Listing> getListings() {
        return listings;
    }

    public void setListings(List<Listing> listings) {
        this.listings = listings;
    }

    //
//    public List<NeighbourHoodGroup> getNeighbourHoodGroupList() {
//        return neighbourHoodGroupList;
//    }
//
//    public void setNeighbourHoodGroupList(List<NeighbourHoodGroup> neighbourHoodGroupList) {
//        this.neighbourHoodGroupList = neighbourHoodGroupList;
//    }
}
