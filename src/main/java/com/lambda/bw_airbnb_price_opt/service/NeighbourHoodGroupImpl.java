package com.lambda.bw_airbnb_price_opt.service;

import com.lambda.bw_airbnb_price_opt.exceptions.ResourceNotFoundException;
import com.lambda.bw_airbnb_price_opt.model.NeighbourHood;
import com.lambda.bw_airbnb_price_opt.model.NeighbourHoodGroup;
import com.lambda.bw_airbnb_price_opt.repository.NeighbourHoodGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "neighbourHoodGroupService")
public class NeighbourHoodGroupImpl implements NeighbourHoodGroupService {
    @Autowired
    NeighbourHoodGroupRepository neighbourHoodGroupRepository;

    @Override
    public List<NeighbourHoodGroup> findAll(Pageable pageable) {
        List<NeighbourHoodGroup> list = new ArrayList<>();
        neighbourHoodGroupRepository.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public NeighbourHoodGroup save(NeighbourHoodGroup neighbourHoodGroup) {
        return neighbourHoodGroupRepository.save(neighbourHoodGroup);
    }

    @Override
    public NeighbourHoodGroup findGroupById(Long id) {
        return neighbourHoodGroupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    }

    @Transactional
    @Override
    public NeighbourHoodGroup update(NeighbourHoodGroup neighbourHoodGroup, long id) {
        NeighbourHoodGroup currentNeighbourHoodGroup = neighbourHoodGroupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));

        if( neighbourHoodGroup.getName() != null)
        {
            currentNeighbourHoodGroup.setName(neighbourHoodGroup.getName());
        }

        if(neighbourHoodGroup.getNeighbourHoods().size() > 0)
        {

            for (NeighbourHood n : neighbourHoodGroup.getNeighbourHoods())
            {
                currentNeighbourHoodGroup.getNeighbourHoods().add( new NeighbourHood(n.getName(), currentNeighbourHoodGroup));
            }

        }

        return neighbourHoodGroupRepository.save(currentNeighbourHoodGroup);
    }

    @Override
    public void delete(long id) {
        if(neighbourHoodGroupRepository.findById(id).isPresent())
        {
            neighbourHoodGroupRepository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException(Long.toString(id));
        }
    }
}
