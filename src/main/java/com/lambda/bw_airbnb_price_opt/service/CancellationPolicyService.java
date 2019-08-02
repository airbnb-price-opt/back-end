package com.lambda.bw_airbnb_price_opt.service;

import com.lambda.bw_airbnb_price_opt.model.BedType;
import com.lambda.bw_airbnb_price_opt.model.CancellationPolicy;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CancellationPolicyService {
    List<CancellationPolicy> findAll(Pageable pageable);

    CancellationPolicy findById(Long id);
}
