package com.rentCar.userservice.Mapping;

import com.rentCar.userservice.Entities.Owner;
import com.rentCar.userservice.Resource.CreateOwnerResource;
import com.rentCar.userservice.Resource.OwnerCarResource;
import com.rentCar.userservice.Resource.OwnerResource;
import com.rentCar.userservice.Shared.Mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class OwnerMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public OwnerResource toResource (Owner model){return mapper.map(model,OwnerResource.class);}
    public OwnerCarResource toOwnerCarResource (Owner model){return mapper.map(model,OwnerCarResource.class);}
    public Page<OwnerResource> modelListToPage(List<Owner> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,OwnerResource.class),pageable,modelList.size());
    }
    public Owner toModel(CreateOwnerResource resource){return mapper.map(resource,Owner.class);}
}
