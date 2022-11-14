package com.rentCar.userservice.Repositories;

import com.rentCar.userservice.Entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OwnerRepository extends JpaRepository<Owner,Long>{
    @Query(value="select*from owners where email=?1 and password=?2", nativeQuery = true)
    Owner AuthOwner(String email,String password);
}
