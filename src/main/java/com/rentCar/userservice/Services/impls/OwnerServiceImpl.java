package com.rentCar.userservice.Services.impls;

import com.rentCar.userservice.Entities.Owner;
import com.rentCar.userservice.Entities.Plan;
import com.rentCar.userservice.Repositories.PlanRepository;
import com.rentCar.userservice.Shared.Exception.ResourceNotFoundException;
import com.rentCar.userservice.Shared.Exception.ResourceValidationException;
import com.rentCar.userservice.Repositories.OwnerRepository;
import com.rentCar.userservice.Services.OwnerService;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PlanRepository planRepository;
    private final Validator validator;

    public OwnerServiceImpl(OwnerRepository ownerRepository, PlanRepository planRepository, Validator validator) {
        this.ownerRepository = ownerRepository;
        this.planRepository = planRepository;
        this.validator = validator;
    }

    @Override
    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner getById(Long ownerId) {
        return ownerRepository.findById(ownerId)
                .orElseThrow(()->new ResourceNotFoundException("OWNER",ownerId));
    }

    @Override
    public Owner create(Owner owner){
        Set<ConstraintViolation<Owner>> violations=validator.validate(owner);
        if(!violations.isEmpty()){
            throw new ResourceValidationException("OWNER",violations);
        }
        Plan plan=planRepository.findById(1L)
                .orElseThrow(()->new ResourceNotFoundException("Plan", 1L));
        owner.setPlan(plan);
        return ownerRepository.save(owner);
    }

    @Override
    public Owner AuthClient(String email, String password) {
        return null;
    }
}