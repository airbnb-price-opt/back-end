package com.lambda.bw_airbnb_price_opt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cancellation_policies")
public class CancellationPolicy extends Auditable {
    @ApiModelProperty(name = "id", value = "primary key for Cancellation Policies")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cancellation_policy_id;

    private String name;

    @OneToMany(mappedBy = "cancellationPolicy",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("cancellationPolicy")
    private List<Listing> listings = new ArrayList<>();

    public CancellationPolicy() {
    }

    public CancellationPolicy(String name) {
        this.name = name;
    }

    public long getCancellation_policy_id() {
        return cancellation_policy_id;
    }

    public void setCancellation_policy_id(long cancellation_policy_id) {
        this.cancellation_policy_id = cancellation_policy_id;
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
