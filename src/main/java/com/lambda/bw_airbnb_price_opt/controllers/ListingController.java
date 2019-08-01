package com.lambda.bw_airbnb_price_opt.controllers;

import com.lambda.bw_airbnb_price_opt.model.CancellationPolicy;
import com.lambda.bw_airbnb_price_opt.model.ErrorDetail;
import com.lambda.bw_airbnb_price_opt.model.Listing;
import com.lambda.bw_airbnb_price_opt.model.PropertyType;
import com.lambda.bw_airbnb_price_opt.service.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/listings")
public class ListingController {
    @Autowired
    ListingService listingService;
    BedTypeService bedTypeService;
    NeighbourHoodService neighbourHoodService;
    RoomTypeService roomTypeService;
    PropertyTypeService propertyTypeService;
    CancellationPolicyService cancellationPolicyService;


    @ApiOperation(value = "Returns all Listings with paging ability", responseContainer = "List")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrive (0..N)"), @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page."), @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(asc|desc).")})
    @ApiResponses(value = {
            //            @ApiResponse(code = 201, message = "List of all rr", response = NeighbourHoodGroup.class),
            @ApiResponse(code = 500, message = "Error in the server, get in contact with Alejandro ASAP ", response = ErrorDetail.class)})
    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> getAll(@PageableDefault(page = 0, size = 5) Pageable pageable)
    {
        return new ResponseEntity<>(listingService.findAll(pageable), HttpStatus.OK);
    }

        @ApiOperation(value = "Adds a new Listing", response = void.class)
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "Listing Created Successfully", response = void.class),
                @ApiResponse(code = 500, message = "Error creating Listing", response = ErrorDetail.class)
        } )
        @PostMapping(value = "/new")
        public ResponseEntity<?> addNewListing(@RequestBody Listing newListing) throws URISyntaxException
        {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://airbnb-data-science-app.herokuapp.com/api";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            MultiValueMap<String, Object> map= new LinkedMultiValueMap<String, Object>();
            map.add("room_type", newListing.getRoomType().getRoom_type_id());
            map.add("number_of_reviews", newListing.getNumber_of_reviews());
            map.add("calculated_host_listings_count", newListing.getCalculated_host_listings_count());
            map.add("availability_365", 342);
            map.add("distance", 6);
            map.add("cancellation_policy", newListing.getCancellationPolicy().getCancellation_policy_id());
            map.add("size", 25);
            map.add("amenities_num", newListing.getAmenities());
            map.add("host_identity_verified", true);
            map.add("security_deposit", newListing.getSecurity_deposit());
            map.add("cleaning_fee", newListing.getCleaning_fee());
            map.add("guests_included", newListing.getGuests_included());
            map.add("extra_people", newListing.getExtra_people());
            map.add("review_scores_rating", newListing.getReview_scores_rating());
            map.add("bathrooms", newListing.getBathrooms());
            map.add("bedrooms", newListing.getBedrooms());
            map.add("beds", newListing.getBedrooms());
            map.add("bed_type", newListing.getBedType().getBed_type_id());
            map.add("accommodates", newListing.getAccommodates());
            HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);

            ResponseEntity<Double> response = restTemplate.postForEntity( url, request , Double.class );
            System.out.println(response.getBody());

            newListing.setPrice(response.getBody());
            newListing = listingService.save(newListing);
            HttpHeaders responseHeaders = new HttpHeaders();
            URI newGroupURI = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{listing_id}").buildAndExpand(newListing.getListing_id()).toUri();
            responseHeaders.setLocation(newGroupURI);

            return new ResponseEntity<>(newListing, responseHeaders, HttpStatus.CREATED);
        }

    @ApiOperation(value = "Updates an existing Listing with existing relationships", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Listing Updated Successfully", response = void.class),
            @ApiResponse(code = 500, message = "Error updating Listing", response = ErrorDetail.class)
    } )
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateListing(HttpServletRequest request,
            @RequestBody
                    Listing updateListing,
            @PathVariable
                    long id)
    {
//        {
//            "listing_id": 23,
//                "name": "Final Update",
//                "latitude": 121.02310231,
//                "longitude": 23.21321,
//                "minimum_nights": 3,
//                "maximum_nights": 4,
//                "accommodates": 3,
//                "bathrooms": 1,
//                "bedrooms": 1,
//                "price": 160.0,
//                "security_deposit": 500.0,
//                "cleaning_fee": 210.0,
//                "guests_included": 12,
//                "extra_people": 38.0,
//                "has_availability": true,
//                "bedType": {
//            "bed_type_id": 8
//        },
//            "neighbourHood": {
//            "neighbourhood_id": 22
//        },
//            "propertyType": {
//            "property_type_id": 12
//        },
//            "roomType": {
//            "room_type_id": 17
//        },
//            "cancellationPolicy": {
//            "cancellation_policy_id": 20
//        }
//        }
//        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");
        listingService.update(updateListing, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Deletes an existing Listing", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Listing deleted Successfully", response = void.class),
            @ApiResponse(code = 500, message = "Error deleting Listing", response = ErrorDetail.class)
    } )
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteListing(@PathVariable long id)
    {
        //        {
        //            "listing_id": 23,
        //                "name": "Final Update",
        //                "latitude": 121.02310231,
        //                "longitude": 23.21321,
        //                "minimum_nights": 3,
        //                "maximum_nights": 4,
        //                "accommodates": 3,
        //                "bathrooms": 1,
        //                "bedrooms": 1,
        //                "price": 160.0,
        //                "security_deposit": 500.0,
        //                "cleaning_fee": 210.0,
        //                "guests_included": 12,
        //                "extra_people": 38.0,
        //                "has_availability": true,
        //                "bedType": {
        //            "bed_type_id": 8
        //        },
        //            "neighbourHood": {
        //            "neighbourhood_id": 22
        //        },
        //            "propertyType": {
        //            "property_type_id": 12
        //        },
        //            "roomType": {
        //            "room_type_id": 17
        //        },
        //            "cancellationPolicy": {
        //            "cancellation_policy_id": 20
        //        }
        //        }
        //        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");
        listingService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
