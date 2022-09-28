package com.rentCar.userservice.Repositories;

import com.rentCar.userservice.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
