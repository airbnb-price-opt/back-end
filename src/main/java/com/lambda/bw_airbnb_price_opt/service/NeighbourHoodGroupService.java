package com.lambda.bw_airbnb_price_opt.service;

import com.lambda.bw_airbnb_price_opt.model.NeighbourHoodGroup;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface NeighbourHoodGroupService {
    List<NeighbourHoodGroup> findAll(Pageable pageable);

    NeighbourHoodGroup save(NeighbourHoodGroup neighbourHoodGroup);

    NeighbourHoodGroup findGroupById(Long id);

    NeighbourHoodGroup update(NeighbourHoodGroup neighbourHoodGroup, long id);

    void delete(long id);
}
