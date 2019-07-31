package com.lambda.bw_airbnb_price_opt.repository;

import com.lambda.bw_airbnb_price_opt.model.RoomType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoomTypeRepository extends PagingAndSortingRepository<RoomType, Long> {
}
