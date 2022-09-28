package com.rentCar.userservice.Repositories;

import com.rentCar.userservice.Entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Long>{
}
