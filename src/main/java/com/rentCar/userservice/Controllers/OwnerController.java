package com.rentCar.userservice.Controllers;

import com.rentCar.userservice.Entities.Owner;
import com.rentCar.userservice.Mapping.OwnerMapper;
import com.rentCar.userservice.Resource.CreateOwnerResource;
import com.rentCar.userservice.Resource.OwnerResource;
import com.rentCar.userservice.Services.OwnerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {
    private final OwnerService ownerService;
    private final OwnerMapper mapper;

    public OwnerController(OwnerService ownerService, OwnerMapper mapper) {
        this.ownerService = ownerService;
        this.mapper = mapper;
    }

    @GetMapping("{ownerId}")
    public OwnerResource fetchById(@PathVariable("ownerId") Long ownerId){
        return  mapper.toResource(ownerService.getById(ownerId));
    }
    @PostMapping
    public OwnerResource createOwner(@Valid @RequestBody CreateOwnerResource request){
        return mapper.toResource(ownerService.create(mapper.toModel(request)));
    }
    @PutMapping("{ownerId}/plan/{planId}")
    public OwnerResource updateOwnerPlan(@PathVariable("ownerId")Long ownerId,
                                         @PathVariable("planId")Long planId){
        return mapper.toResource(ownerService.updatePlan(planId,ownerId));
    }
}
