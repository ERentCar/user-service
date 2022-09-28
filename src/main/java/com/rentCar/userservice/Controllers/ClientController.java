package com.rentCar.userservice.Controllers;


import com.rentCar.userservice.Entities.Client;
import com.rentCar.userservice.Mapping.ClientMapper;
import com.rentCar.userservice.Resource.ClientResource;
import com.rentCar.userservice.Resource.CreateClientResource;
import com.rentCar.userservice.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private ClientService clientService;
    private final ClientMapper mapper;

    public ClientController(ClientService clientService, ClientMapper mapper) {
        this.clientService = clientService;
        this.mapper = mapper;
    }

    @GetMapping("{clientId}")
    public ClientResource fetchById(@PathVariable("clientId") Long clientId){

        return  mapper.toResource(clientService.getById(clientId));
    }
    @PostMapping
    public ClientResource createClient(@Valid @RequestBody CreateClientResource request){

        return mapper.toResource(clientService.create(mapper.toModel(request)));
    }
}
