package com.lambda.bw_airbnb_price_opt.service;

import com.lambda.bw_airbnb_price_opt.model.Listing;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ListingService {
    List<Listing> findAll(Pageable pageable);

    Listing save(Listing neighbourHoodGroup);
}
