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
    public Owner getByIdForCar(Long ownerId) {
        return null;
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
    public Owner updatePlan(Long planId, Long ownerId) {
        Plan plan=planRepository.findById(planId)
                .orElseThrow(()->new ResourceNotFoundException("PLAN", planId));
        Owner owner=ownerRepository.findById(ownerId).map(planAux->
                        ownerRepository.save(planAux.withPlan(plan)))
                .orElseThrow(()->new ResourceNotFoundException("OWNER",ownerId));
        /*owner.setPlan(plan);*/
        return owner;
    }

    @Override
    public Owner AuthOwner(String email, String password) {
        return ownerRepository.AuthOwner(email,password);
    }

    @Override
    public Owner setRating(Long ownerId, Double rating) {
        Owner owner=ownerRepository.findById(ownerId).map(aux->ownerRepository.save(aux.withRating(rating)))
                .orElseThrow(()->new ResourceNotFoundException("OWNER",ownerId));
        return owner;
    }
}
