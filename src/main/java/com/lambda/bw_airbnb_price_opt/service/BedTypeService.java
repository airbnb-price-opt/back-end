package com.lambda.bw_airbnb_price_opt.service;

import com.lambda.bw_airbnb_price_opt.model.BedType;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BedTypeService {
    List<BedType> findAll(Pageable pageable);

    BedType findById(Long id);
}
