package com.rentCar.userservice.Controllers;

import com.rentCar.userservice.Entities.Owner;
import com.rentCar.userservice.Mapping.OwnerMapper;
import com.rentCar.userservice.Resource.Auth;
import com.rentCar.userservice.Resource.CreateOwnerResource;
import com.rentCar.userservice.Resource.OwnerCarResource;
import com.rentCar.userservice.Resource.OwnerResource;
import com.rentCar.userservice.Services.OwnerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
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
    @GetMapping("ownerCar/{ownerId}")
    public OwnerCarResource getByIdForCar(@PathVariable("ownerId") Long ownerId){
        return  mapper.toOwnerCarResource(ownerService.getById(ownerId));
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
    @PutMapping("{ownerId}/rating/{rating}")
    public void updateRating(@PathVariable("ownerId")Long ownerId,
                             @PathVariable("rating")Double rating){
        ownerService.setRating(ownerId,rating);
    }
    @PostMapping("Auth")
    public OwnerCarResource Auth(@Valid @RequestBody Auth request){
        return  mapper.toOwnerCarResource(ownerService.AuthOwner(request.getEmail(),request.getPassword()));
    }
}
