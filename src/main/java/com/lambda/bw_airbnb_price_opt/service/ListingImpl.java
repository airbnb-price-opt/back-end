package com.lambda.bw_airbnb_price_opt.service;

import com.lambda.bw_airbnb_price_opt.exceptions.ResourceNotFoundException;
import com.lambda.bw_airbnb_price_opt.model.*;
import com.lambda.bw_airbnb_price_opt.repository.*;
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
    NeighbourHoodRepository neighbourHoodRepository;
    PropertyTypeRepository propertyTypeRepository;
    RoomTypeRepository roomTypeRepository;
    CancellationPolicyRepository cancellationPolicyRepository;
    BedTypeRepository bedTypeRepository;

    @Override
    public List<Listing> findAll(Pageable pageable) {
        List<Listing> listings = new ArrayList<>();
        listingRepository.findAll().iterator().forEachRemaining(listings::add);
        return listings;
    }

    @Transactional
    @Override
    public Listing save(Listing listing) {
        return listingRepository.save(listing);
    }

    @Transactional
    @Override
    public Listing update(Listing listing, Long id) {
        Listing currentListing = listingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
        if(listing.getName() != null)
        {
            currentListing.setName(listing.getName());
        }

        if(listing.getLatitude() != null)
        {
            currentListing.setLatitude(listing.getLatitude());
        }
        if(listing.getLongitude() != null)
        {
            currentListing.setLongitude(listing.getLongitude());
        }
        if(listing.getMinimum_nights() != null)
        {
            currentListing.setMinimum_nights(listing.getMinimum_nights());
        }
        if(listing.getMaximum_nights() != null)
        {
            currentListing.setMaximum_nights(listing.getMaximum_nights());
        }
        if(listing.getAccommodates() != null)
        {
            currentListing.setAccommodates(listing.getAccommodates());
        }
        if(listing.getBathrooms() != null)
        {
            currentListing.setBathrooms(listing.getBathrooms());
        }
        if(listing.getBedrooms() != null)
        {
            currentListing.setBedrooms(listing.getBedrooms());
        }
//        System.out.println("H E R E");
//        System.out.println(listing.getPrice());
        if(listing.getPrice() != null)
        {
            currentListing.setPrice(listing.getPrice());
        }
        if(listing.getSecurity_deposit() != null)
        {
            currentListing.setSecurity_deposit(listing.getSecurity_deposit());
        }
        if(listing.getCleaning_fee() != null)
        {
            currentListing.setCleaning_fee(listing.getCleaning_fee());
        }
        if(listing.getGuests_included() != null)
        {
            currentListing.setGuests_included(listing.getGuests_included());
        }
        if(listing.getExtra_people() != null)
        {
            currentListing.setExtra_people(listing.getExtra_people());
        }
        if(listing.getHas_availability() != null)
        {
            currentListing.setHas_availability(listing.getHas_availability());
        }
        if(listing.getNeighbourHood() != null)
        {
//            NeighbourHood newNeighbourHood = neighbourHoodRepository.findById(listing.getNeighbourHood().getNeighbourhood_id()).orElseThrow(() -> new ResourceNotFoundException(Long.toString(listing.getNeighbourHood().getNeighbourhood_id())));
            if(listing.getNeighbourHood().getNeighbourhood_id() != currentListing.getNeighbourHood().getNeighbourhood_id())
            {
                currentListing.setNeighbourHood(listing.getNeighbourHood());
            }
        }

        if(listing.getPropertyType() != null)
        {
//            PropertyType newPropertyType = propertyTypeRepository.findById(listing.getPropertyType().getProperty_type_id()).orElseThrow(() -> new ResourceNotFoundException(Long.toString(listing.getPropertyType().getProperty_type_id())));
            if(listing.getPropertyType().getProperty_type_id() != currentListing.getPropertyType().getProperty_type_id())
            {
                currentListing.setPropertyType(listing.getPropertyType());
            }
        }
        if(listing.getRoomType() != null)
        {
//            RoomType newRoomType = roomTypeRepository.findById(listing.getRoomType().getRoom_type_id()).orElseThrow(() -> new ResourceNotFoundException(Long.toString(listing.getRoomType().getRoom_type_id())));
            if(listing.getRoomType().getRoom_type_id() != currentListing.getRoomType().getRoom_type_id())
            {
                currentListing.setRoomType(listing.getRoomType());
            }
        }

        if(listing.getCancellationPolicy() != null)
        {
//            CancellationPolicy newCancellation = cancellationPolicyRepository.findById(listing.getCancellationPolicy().getCancellation_policy_id()).orElseThrow(() -> new ResourceNotFoundException(Long.toString(listing.getCancellationPolicy().getCancellation_policy_id())));
            if(listing.getCancellationPolicy().getCancellation_policy_id() != currentListing.getCancellationPolicy().getCancellation_policy_id())
            {
                currentListing.setCancellationPolicy(listing.getCancellationPolicy());
            }
        }
        if(listing.getBedType() != null)
        {
//            BedType newBedType = bedTypeRepository.findById(listing.getBedType().getBed_type_id()).orElseThrow(() -> new ResourceNotFoundException(Long.toString(listing.getBedType().getBed_type_id())));
            if(listing.getBedType().getBed_type_id() != currentListing.getBedType().getBed_type_id())
            {
                currentListing.setBedType(listing.getBedType());
            }

        }
        return listingRepository.save(currentListing);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        if (listingRepository.findById(id).isPresent())
        {
            listingRepository.deleteById(id);
        } else
        {
            throw new ResourceNotFoundException(Long.toString(id));
        }
    }
}
