package com.lambda.bw_airbnb_price_opt.repository;

import com.lambda.bw_airbnb_price_opt.model.CancellationPolicy;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CancellationPolicyRepository extends PagingAndSortingRepository<CancellationPolicy, Long> {
}
