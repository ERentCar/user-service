package com.rentCar.userservice.Controllers;

import com.rentCar.userservice.Entities.Plan;
import com.rentCar.userservice.Mapping.PlanMapper;
import com.rentCar.userservice.Resource.CreatePlanResource;
import com.rentCar.userservice.Resource.PlanResource;
import com.rentCar.userservice.Services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/plans")
public class PlanController {
    private final PlanService planService;
    private final PlanMapper mapper;

    public PlanController(PlanService planService, PlanMapper mapper) {
        this.planService = planService;
        this.mapper = mapper;
    }
    @GetMapping
    public List<PlanResource> getAllPlans(){
        return mapper.listToResource(planService.getAll());
    }

    @GetMapping("{planId}")
    public PlanResource getPlanById(@PathVariable Long planId){
        return  mapper.toResource(planService.getById(planId));
    }

    @PostMapping
    public PlanResource createPlan(@Valid @RequestBody CreatePlanResource request){
        return mapper.toResource(planService.create(mapper.toModel(request)));
    }
    @DeleteMapping("{planId}")
    public ResponseEntity<?> deletePlan(@PathVariable Long planId) {
        return planService.delete(planId);
    }
}
