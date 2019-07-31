package com.lambda.bw_airbnb_price_opt.service;

import com.lambda.bw_airbnb_price_opt.model.NeighbourHood;
import com.lambda.bw_airbnb_price_opt.model.NeighbourHoodGroup;
import com.lambda.bw_airbnb_price_opt.repository.NeighbourHoodGroupRepository;
import com.lambda.bw_airbnb_price_opt.repository.NeighbourHoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service(value = "neighbourHoodService")
public class NeighbourHoodImpl implements NeighbourHoodService {
    @Autowired
    NeighbourHoodRepository neighbourHoodRepository;

    @Override
    public List<NeighbourHood> findAll() {
        List<NeighbourHood> list = new ArrayList<>();
        neighbourHoodRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}