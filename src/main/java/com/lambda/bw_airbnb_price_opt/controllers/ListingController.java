package com.lambda.bw_airbnb_price_opt.controllers;

import com.lambda.bw_airbnb_price_opt.model.CancellationPolicy;
import com.lambda.bw_airbnb_price_opt.model.ErrorDetail;
import com.lambda.bw_airbnb_price_opt.model.Listing;
import com.lambda.bw_airbnb_price_opt.model.PropertyType;
import com.lambda.bw_airbnb_price_opt.service.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        public ResponseEntity<?> addNewListing(@Valid @RequestBody Listing newListing) throws URISyntaxException
        {
//            Listing test = new Listing(
//                    newListing.getName(),
//                    newListing.getLatitude(),
//                    newListing.getLongitude(),
//                    newListing.getMinimum_nights(), newListing.getMaximum_nights(),
//                    newListing.getAccommodates(),
//                    newListing.getBathrooms(),newListing.getBedrooms(),
//                    newListing.getPrice(),newListing.getSecurity_deposit(),newListing.getCleaning_fee(),
//                    newListing.getGuests_included(),newListing.getExtra_people(),newListing.getHas_availability(),
//                    neighbourHoodService.findById(newListing.getNeighbourHood().getNeighbourhood_id()),
//                    propertyTypeService.findById(newListing.getPropertyType().getProperty_type_id()),
//                    roomTypeService.findById(newListing.getRoomType().getRoom_type_id()),
//                    cancellationPolicyService.findById(newListing.getCancellationPolicy().getCancellation_policy_id()),
//                    bedTypeService.findById(newListing.getBedType().getBed_type_id()));

            newListing = listingService.save(newListing);
            HttpHeaders responseHeaders = new HttpHeaders();
            URI newGroupURI = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{bed_id}").buildAndExpand(newListing.getListing_id()).toUri();
            responseHeaders.setLocation(newGroupURI);

            return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
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
