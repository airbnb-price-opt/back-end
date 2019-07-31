package com.lambda.bw_airbnb_price_opt.controllers;

import com.lambda.bw_airbnb_price_opt.model.NeighbourHood;
import com.lambda.bw_airbnb_price_opt.service.NeighbourHoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/neighbourhood")
public class NeighbourHoodController {
    @Autowired
    NeighbourHoodService neighbourHoodService;

    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> listAllNeighbourhoods()
    {
        List<NeighbourHood> list = neighbourHoodService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}
