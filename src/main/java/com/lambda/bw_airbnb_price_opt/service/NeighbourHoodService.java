package com.lambda.bw_airbnb_price_opt.service;

import com.lambda.bw_airbnb_price_opt.model.NeighbourHood;

import java.util.List;

public interface NeighbourHoodService {
    List<NeighbourHood> findAll();

    NeighbourHood findById(Long id);
//    NeighbourHood save(NeighbourHood neighbourHood);
}
