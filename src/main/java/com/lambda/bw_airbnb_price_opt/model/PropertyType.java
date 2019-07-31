package com.lambda.bw_airbnb_price_opt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "property_types")
public class PropertyType extends Auditable {

    @ApiModelProperty(name = "id", value = "primary key for Property Types")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long property_type_id;

    private String name;

    @OneToMany(mappedBy = "propertyType",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("propertyType")
    private List<Listing> listings = new ArrayList<>();

    public PropertyType() {
    }

    public PropertyType(String name) {
        this.name = name;
    }

    public long getProperty_type_id() {
        return property_type_id;
    }

    public void setProperty_type_id(long property_type_id) {
        this.property_type_id = property_type_id;
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
