package com.lambda.bw_airbnb_price_opt.service;

import com.lambda.bw_airbnb_price_opt.model.Listing;
import com.lambda.bw_airbnb_price_opt.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    @Override
    public Listing save(Listing listing) {
//        listing = new Listing(
//                "First listing",
//                12.02310231,
//                -123.21321,
//                3, 4,
//                3,
//                1,1,
//                60.00,200.00,30.00,
//                1,28.00,true,
//                neighbourHoodService.findById(newListing.getNeighbourHood().getNeighbourhood_id()),
//                propertyTypeService.findById(newListing.getPropertyType().getProperty_type_id()),
//                roomTypeService.findById(newListing.getRoomType().getRoom_type_id()),
//                cancellationPolicyService.findById(newListing.getCancellationPolicy().getCancellation_policy_id()),
//                bedTypeService.findById(newListing.getBedType().getBed_type_id()));
        return listingRepository.save(listing);
    }
}
