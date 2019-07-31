package com.lambda.bw_airbnb_price_opt.controllers;

import com.lambda.bw_airbnb_price_opt.model.CancellationPolicy;
import com.lambda.bw_airbnb_price_opt.model.ErrorDetail;
import com.lambda.bw_airbnb_price_opt.model.RoomType;
import com.lambda.bw_airbnb_price_opt.service.CancellationPolicyService;
import com.lambda.bw_airbnb_price_opt.service.RoomTypeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cancellations")
public class CancellationPolicyController {

    @Autowired
    CancellationPolicyService cancellationPolicyService;

    @ApiOperation(value = "Returns all Property Types with paging ability", responseContainer = "List")
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
        List<CancellationPolicy> allCancellationPolicies = cancellationPolicyService.findAll(pageable);
        return new ResponseEntity<>(allCancellationPolicies, HttpStatus.OK);
    }

    @GetMapping(value = "cancellation/{cancellation_id}", produces = {"application/json"})
    public ResponseEntity<?> listGroupById(@PathVariable Long cancellation_id)
    {
        CancellationPolicy cancellationPolicy = cancellationPolicyService.findById(cancellation_id);
        return new ResponseEntity<>(cancellationPolicy, HttpStatus.OK);
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
