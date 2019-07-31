package com.lambda.bw_airbnb_price_opt.repository;

import com.lambda.bw_airbnb_price_opt.model.NeighbourHoodGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NeighbourHoodGroupRepository extends PagingAndSortingRepository<NeighbourHoodGroup, Long> {
}
