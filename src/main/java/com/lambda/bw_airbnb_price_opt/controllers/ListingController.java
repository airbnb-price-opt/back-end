package com.lambda.bw_airbnb_price_opt.controllers;

import com.lambda.bw_airbnb_price_opt.model.ErrorDetail;
import com.lambda.bw_airbnb_price_opt.service.ListingService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listings")
public class ListingController {
    @Autowired
    ListingService listingService;

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

}
