package com.lambda.bw_airbnb_price_opt.repository;

import com.lambda.bw_airbnb_price_opt.model.BedType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BedTypeRepository extends PagingAndSortingRepository<BedType, Long> {
}
