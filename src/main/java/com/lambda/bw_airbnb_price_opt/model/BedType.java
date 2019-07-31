package com.lambda.bw_airbnb_price_opt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bed_types")
public class BedType extends Auditable {
    @ApiModelProperty(name = "id", value = "primary key for Bed Types")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bed_type_id;

    private String name;

    @OneToMany(mappedBy = "bedType",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("bedType")
    private List<Listing> listings = new ArrayList<>();

    public BedType() {
    }

    public BedType(String name) {
        this.name = name;
    }

    public long getBed_type_id() {
        return bed_type_id;
    }

    public void setBed_type_id(long bed_type_id) {
        this.bed_type_id = bed_type_id;
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
