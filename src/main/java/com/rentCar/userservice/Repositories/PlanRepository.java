package com.rentCar.userservice.Repositories;

import com.rentCar.userservice.Entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan,Long> {
}
