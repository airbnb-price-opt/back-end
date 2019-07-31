package com.lambda.bw_airbnb_price_opt.service;

import com.lambda.bw_airbnb_price_opt.model.Listing;
import com.lambda.bw_airbnb_price_opt.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "listingService")
public class ListingImpl implements ListingService {
    @Autowired
    ListingRepository listingRepository;

    @Override
    public List<Listing> findAll(Pageable pageable) {
        List<Listing> listings = new ArrayList<>();
        listingRepository.findAll().iterator().forEachRemaining(listings::add);
        return listings;
    }
}
