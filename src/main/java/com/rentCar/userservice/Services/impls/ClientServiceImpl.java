package com.rentCar.userservice.Services.impls;


import com.rentCar.userservice.Entities.Client;
import com.rentCar.userservice.Shared.Exception.ResourceNotFoundException;
import com.rentCar.userservice.Shared.Exception.ResourceValidationException;
import com.rentCar.userservice.Repositories.ClientRepository;
import com.rentCar.userservice.Services.ClientService;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final Validator validator;

    public ClientServiceImpl(ClientRepository clientRepository, Validator validator) {
        this.clientRepository = clientRepository;
        this.validator = validator;
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(()->new ResourceNotFoundException("CLIENT",clientId));
    }

    @Override
    public Client create(Client client) {
        Set<ConstraintViolation<Client>> violations=validator.validate(client);
        if(!violations.isEmpty()){
            throw new ResourceValidationException("CLIENT",violations);
        }
        return clientRepository.save(client);
    }

    @Override
    public Client AuthClient(String email, String password) {
        return clientRepository.AuthClient(email,password);
    }

    @Override
    public Client setRating(Long clientId, Double rating) {
        Client client=clientRepository.findById(clientId).map(aux->clientRepository.save(aux.withRating(rating)))
                .orElseThrow(()->new ResourceNotFoundException("CLIENT",clientId));
        return client;
    }
}
