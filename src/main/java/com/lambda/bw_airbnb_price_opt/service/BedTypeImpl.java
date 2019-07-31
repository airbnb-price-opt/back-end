package com.lambda.bw_airbnb_price_opt.service;

import com.lambda.bw_airbnb_price_opt.exceptions.ResourceNotFoundException;
import com.lambda.bw_airbnb_price_opt.model.BedType;
import com.lambda.bw_airbnb_price_opt.model.NeighbourHood;
import com.lambda.bw_airbnb_price_opt.model.BedType;
import com.lambda.bw_airbnb_price_opt.repository.BedTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "bedTypeService")
public class BedTypeImpl implements BedTypeService {
    @Autowired
    BedTypeRepository bedTypeRepository;

    @Override
    public List<BedType> findAll(Pageable pageable) {
        List<BedType> list = new ArrayList<>();
        bedTypeRepository.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

//    @Transactional
//    @Override
//    public BedType save(BedType neighbourHoodGroup) {
//        return bedTypeRepository.save(neighbourHoodGroup);
//    }

    @Override
    public BedType findById(Long id) {
        return bedTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
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
