package com.lambda.bw_airbnb_price_opt.service;

import com.lambda.bw_airbnb_price_opt.exceptions.ResourceNotFoundException;
import com.lambda.bw_airbnb_price_opt.model.BedType;
import com.lambda.bw_airbnb_price_opt.model.RoomType;
import com.lambda.bw_airbnb_price_opt.repository.BedTypeRepository;
import com.lambda.bw_airbnb_price_opt.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("roomTypeService")
public class RoomTypeImpl implements RoomTypeService {
    @Autowired
    RoomTypeRepository roomTypeRepository;

    @Override
    public List<RoomType> findAll(Pageable pageable) {
        List<RoomType> list = new ArrayList<>();
        roomTypeRepository.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    //    @Transactional
    //    @Override
    //    public BedType save(BedType neighbourHoodGroup) {
    //        return bedTypeRepository.save(neighbourHoodGroup);
    //    }

    @Override
    public RoomType findById(Long id) {
        return roomTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    }

    //    @Transactional
    //    @Override
    //    public BedType update(BedType neighbourHoodGroup, long id) {
    //        BedType currentBedType = bedTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    //
    //        if( neighbourHoodGroup.getName() != null)
    //        {
    //            BedType.setName(neighbourHoodGroup.getName());
    //        }
    //
    //        if(neighbourHoodGroup.g().size() > 0)
    //        {
    //
    //            for (NeighbourHood n : neighbourHoodGroup.getNeighbourHoods())
    //            {
    //                BedType.getNeighbourHoods().add( new NeighbourHood(n.getName(), BedType));
    //            }
    //
    //        }
    //
    //        return bedTypeRepository.save(BedType);
    //    }
    //
    //    @Override
    //    public void delete(long id) {
    //        if(bedTypeRepository.findById(id).isPresent())
    //        {
    //            bedTypeRepository.deleteById(id);
    //        }
    //        else {
    //            throw new ResourceNotFoundException(Long.toString(id));
    //        }
    //    }
}
