package com.lambda.bw_airbnb_price_opt.service;

import com.lambda.bw_airbnb_price_opt.exceptions.ResourceNotFoundException;
import com.lambda.bw_airbnb_price_opt.model.BedType;
import com.lambda.bw_airbnb_price_opt.model.PropertyType;
import com.lambda.bw_airbnb_price_opt.repository.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("propertyTypeService")
public class PropertyTypeImpl implements PropertyTypeService {

    @Autowired
    PropertyTypeRepository propertyTypeRepository;

    @Override
    public List<PropertyType> findAll(Pageable pageable) {
        List<PropertyType> list = new ArrayList<>();
        propertyTypeRepository.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public PropertyType findById(Long id) {
        return propertyTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    }
}
