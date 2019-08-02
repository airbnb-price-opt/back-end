package com.lambda.bw_airbnb_price_opt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room_types")
public class RoomType extends Auditable {
    @ApiModelProperty(name = "id", value = "primary key for Room Types")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long room_type_id;

    private String name;

    @OneToMany(mappedBy = "roomType",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("roomType")
    private List<Listing> listings = new ArrayList<>();

    public RoomType() {
    }

    public RoomType(String name) {
        this.name = name;
    }

    public long getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(long room_type_id) {
        this.room_type_id = room_type_id;
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
}
