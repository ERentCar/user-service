package com.rentCar.userservice.Services;


import com.rentCar.userservice.Entities.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAll();
    Client getById(Long clientId);
    Client create(Client client);
    Client AuthClient(String email, String password);
}
