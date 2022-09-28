package com.rentCar.userservice.Services;

import com.rentCar.userservice.Entities.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PlanService {
    List<Plan> getAll();
    Plan getById(Long planId);
    Plan create(Plan plan);
    ResponseEntity<?> delete(Long planId);
}
