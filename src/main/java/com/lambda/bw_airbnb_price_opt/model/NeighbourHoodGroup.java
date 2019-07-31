package com.lambda.bw_airbnb_price_opt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "neighbourhood_groups")
public class NeighbourHoodGroup extends Auditable {

    @ApiModelProperty(name = "id", value = "primary key for Neighbourhood Groups")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long neighbourhood_group_id;

    private String name;

    @OneToMany(mappedBy = "neighbourHoodGroup",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("neighbourHoodGroup")
    private List<NeighbourHood> neighbourHoods = new ArrayList<>();


    public NeighbourHoodGroup() {
    }

    public List<NeighbourHood> getNeighbourHoods() {
        return neighbourHoods;
    }

    public void setNeighbourHoods(List<NeighbourHood> neighbourHoods) {
        this.neighbourHoods = neighbourHoods;
    }

    public NeighbourHoodGroup(String name) {
        this.name = name;
//        this.neighbourHood = neighbourHood;
    }

    public long getNeighbourhood_group_id() {
        return neighbourhood_group_id;
    }

    public void setNeighbourhood_group_id(long neighbourhood_group_id) {
        this.neighbourhood_group_id = neighbourhood_group_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
