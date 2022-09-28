package com.rentCar.userservice.Mapping;

import com.rentCar.userservice.Entities.Plan;
import com.rentCar.userservice.Resource.CreatePlanResource;
import com.rentCar.userservice.Resource.PlanResource;
import com.rentCar.userservice.Shared.Mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class PlanMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public PlanResource toResource (Plan model){return mapper.map(model,PlanResource.class);}
    public Page<PlanResource> modelListToPage(List<Plan> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,PlanResource.class),pageable,modelList.size());
    }
    public Plan toModel(CreatePlanResource resource){return mapper.map(resource,Plan.class);}
    public List<PlanResource> listToResource(List<Plan> modelList){
        return mapper.mapList(modelList,PlanResource.class);
    }
}
