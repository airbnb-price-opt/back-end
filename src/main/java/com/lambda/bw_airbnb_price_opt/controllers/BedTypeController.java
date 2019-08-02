package com.lambda.bw_airbnb_price_opt.controllers;

import com.lambda.bw_airbnb_price_opt.model.BedType;
import com.lambda.bw_airbnb_price_opt.model.ErrorDetail;
import com.lambda.bw_airbnb_price_opt.model.NeighbourHoodGroup;
import com.lambda.bw_airbnb_price_opt.service.BedTypeService;
import com.lambda.bw_airbnb_price_opt.service.NeighbourHoodGroupService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/beds")
public class BedTypeController {

    @Autowired
    BedTypeService bedTypeService;

    @ApiOperation(value = "Returns all Bed Types with paging ability", responseContainer = "List")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrieve (0..N)"), @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page."), @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(asc|desc).")})
    @ApiResponses(value = {
            //            @ApiResponse(code = 201, message = "List of all rr", response = NeighbourHoodGroup.class),
            @ApiResponse(code = 500, message = "Error in the server, get in contact with Alejandro ASAP ", response = ErrorDetail.class)})
    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> listAllBedTypes(@PageableDefault(page = 0, size = 5) Pageable pageable)
    {
//        RestTemplate restTemplate = new RestTemplate();
//        String resourceUrl = "https://gturnquist-quoters.cfapps.io/api/random";
//        ResponseEntity<String> reponse = restTemplate.getForEntity(resourceUrl, String.class);
//        System.out.println(reponse);
        List<BedType> allBedTypes = bedTypeService.findAll(pageable);
        return new ResponseEntity<>(allBedTypes, HttpStatus.OK);
    }

    @GetMapping(value = "bed/{bed_id}", produces = {"application/json"})
    public ResponseEntity<?> listGroupById(@PathVariable Long bed_id)
    {
        BedType bedType = bedTypeService.findById(bed_id);
        return new ResponseEntity<>(bedType, HttpStatus.OK);
    }

//    @ApiOperation(value = "Adds a new Neighbour hood Group", response = void.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Neighbour Hood Group Created Successfully", response = void.class),
//            @ApiResponse(code = 500, message = "Error creating Neighbour Hood Group", response = ErrorDetail.class)
//    } )
//    @PostMapping(value = "/new")
//    public ResponseEntity<?> addNewGroup(@Valid @RequestBody NeighbourHoodGroup newGroup) throws URISyntaxException
//    {
//        newGroup = neighbourHoodGroupService.save(newGroup);
//
//        HttpHeaders responseHeaders = new HttpHeaders();
//        URI newGroupURI = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("/{bed_id}").buildAndExpand(newGroup.getNeighbourhood_group_id()).toUri();
//        responseHeaders.setLocation(newGroupURI);
//
//        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
//    }
//
//    @ApiOperation(value = "Edits an existing Neighbor hood Group", response = void.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Neighbor Hood Group Edited Successfully", response = void.class),
//            @ApiResponse(code = 500, message = "Error editing Neighbor Hood Group", response = ErrorDetail.class)
//    } )
//    @PutMapping(value = "group/{bed_id}")
//    public ResponseEntity<?> editNewGroup(@Valid @RequestBody NeighbourHoodGroup newGroup, @PathVariable long bed_id) throws URISyntaxException
//    {
//        neighbourHoodGroupService.update(newGroup, bed_id);
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
//    }
//
//    @ApiOperation(value = "Deletes an existing Neighborhood Group", response = void.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "NeighborHood Group Deleted Successfully", response = void.class),
//            @ApiResponse(code = 404, message = "NeighborHood Group Not Found", response = ErrorDetail.class),
//            @ApiResponse(code = 500, message = "Error deleting NeighborHood Group", response = ErrorDetail.class)
//    } )
//    @DeleteMapping(value = "group/{bed_id}")
//    public ResponseEntity<?> deleteNewGroup(@PathVariable long bed_id) throws URISyntaxException
//    {
//        neighbourHoodGroupService.delete(bed_id);
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
//    }

}
