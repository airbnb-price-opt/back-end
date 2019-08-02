package com.lambda.bw_airbnb_price_opt.repository;

import com.lambda.bw_airbnb_price_opt.model.Listing;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ListingRepository extends PagingAndSortingRepository<Listing, Long> {
}
