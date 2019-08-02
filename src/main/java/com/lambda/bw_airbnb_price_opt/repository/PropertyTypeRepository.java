package com.lambda.bw_airbnb_price_opt.repository;

import com.lambda.bw_airbnb_price_opt.model.PropertyType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PropertyTypeRepository extends PagingAndSortingRepository<PropertyType, Long> {
}
