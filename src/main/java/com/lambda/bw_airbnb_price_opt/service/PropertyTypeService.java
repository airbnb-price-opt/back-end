package com.lambda.bw_airbnb_price_opt.service;

import com.lambda.bw_airbnb_price_opt.model.BedType;
import com.lambda.bw_airbnb_price_opt.model.PropertyType;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PropertyTypeService {
    List<PropertyType> findAll(Pageable pageable);


    PropertyType findById(Long id);
}
