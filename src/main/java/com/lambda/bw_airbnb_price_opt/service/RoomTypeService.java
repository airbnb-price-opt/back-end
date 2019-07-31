package com.lambda.bw_airbnb_price_opt.service;

import com.lambda.bw_airbnb_price_opt.model.PropertyType;
import com.lambda.bw_airbnb_price_opt.model.RoomType;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoomTypeService {
    List<RoomType> findAll(Pageable pageable);
    RoomType findById(Long id);
}
