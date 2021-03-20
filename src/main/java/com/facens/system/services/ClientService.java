package com.facens.system.services;

import java.util.ArrayList;
import java.util.List;

import com.facens.system.repositories.ClientRepository;
import com.facens.system.dtos.ClientDTO;
import com.facens.system.entitites.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;
    
    public List<ClientDTO> getClients() {
        List<Client> list = repo.findAll();
        List<ClientDTO> listDTO = new ArrayList<>();

        for(Client c: list) {
            ClientDTO dto = new ClientDTO(c.getId(), c.getName());
            listDTO.add(dto);
        }
        
        return listDTO;
    }

}
