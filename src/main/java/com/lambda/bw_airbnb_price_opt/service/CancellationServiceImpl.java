package com.lambda.bw_airbnb_price_opt.service;

import com.lambda.bw_airbnb_price_opt.exceptions.ResourceNotFoundException;
import com.lambda.bw_airbnb_price_opt.model.BedType;
import com.lambda.bw_airbnb_price_opt.model.CancellationPolicy;
import com.lambda.bw_airbnb_price_opt.repository.BedTypeRepository;
import com.lambda.bw_airbnb_price_opt.repository.CancellationPolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "cancellationPolicyService")
public class CancellationServiceImpl implements CancellationPolicyService {
    @Autowired
    CancellationPolicyRepository cancellationPolicyRepository;

    @Override
    public List<CancellationPolicy> findAll(Pageable pageable) {
        List<CancellationPolicy> list = new ArrayList<>();
        cancellationPolicyRepository.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    //    @Transactional
    //    @Override
    //    public CancellationPolicy save(CancellationPolicy neighbourHoodGroup) {
    //        return cancellationPolicyRepository.save(neighbourHoodGroup);
    //    }

    @Override
    public CancellationPolicy findById(Long id) {
        return cancellationPolicyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    }

    //    @Transactional
    //    @Override
    //    public CancellationPolicy update(BedType neighbourHoodGroup, long id) {
    //        BedType currentBedType = cancellationPolicyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
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
    //        return cancellationPolicyRepository.save(BedType);
    //    }
    //
    //    @Override
    //    public void delete(long id) {
    //        if(cancellationPolicyRepository.findById(id).isPresent())
    //        {
    //            cancellationPolicyRepository.deleteById(id);
    //        }
    //        else {
    //            throw new ResourceNotFoundException(Long.toString(id));
    //        }
    //    }
}
