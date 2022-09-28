package com.rentCar.userservice.Services;

import com.rentCar.userservice.Entities.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OwnerService {
    List<Owner> getAll();
    Owner getById(Long ownerId);
    Owner create(Owner owner);
    Owner updatePlan(Long planId,Long ownerId);
    Owner AuthClient(String email, String password);
}

