package com.rentCar.userservice.Services.impls;

import com.rentCar.userservice.Entities.Plan;
import com.rentCar.userservice.Repositories.PlanRepository;
import com.rentCar.userservice.Services.PlanService;
import com.rentCar.userservice.Shared.Exception.ResourceNotFoundException;
import com.rentCar.userservice.Shared.Exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;


@Service
public class PlanServiceImpl implements PlanService {
    private PlanRepository planRepository;
    private final Validator validator;

    public PlanServiceImpl(PlanRepository planRepository, Validator validator) {
        this.planRepository = planRepository;
        this.validator = validator;
    }

    @Override
    public List<Plan> getAll() {
        return planRepository.findAll();
    }

    @Override
    public Plan getById(Long planId) {
        return planRepository.findById(planId)
                .orElseThrow(()->new ResourceNotFoundException("PLAN",planId));
    }

    @Override
    public Plan create(Plan plan) {
        Set<ConstraintViolation<Plan>> violations=validator.validate(plan);
        if(!violations.isEmpty()){
            throw new ResourceValidationException("PLAN",violations);
        }
        return planRepository.save(plan);
    }

    @Override
    public ResponseEntity<?> delete(Long planId) {
        return planRepository.findById(planId).map(plan -> {
            planRepository.delete(plan);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PLAN", planId));
    }
}
