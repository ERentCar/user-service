package com.rentCar.userservice.Shared.Mapping;

import com.rentCar.userservice.Mapping.ClientMapper;
import com.rentCar.userservice.Mapping.OwnerMapper;
import com.rentCar.userservice.Mapping.PlanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("userServiceMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }
    @Bean
    public OwnerMapper ownerMapper(){return new OwnerMapper();}
    @Bean
    public ClientMapper clientMapper(){return new ClientMapper();}
    @Bean
    public PlanMapper planMapper(){return new PlanMapper();}
}
