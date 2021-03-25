package com.facens.system.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.facens.system.repositories.ClientRepository;
import com.facens.system.dtos.ClientDTO;
import com.facens.system.dtos.ClientInsertDTO;
import com.facens.system.dtos.ClientUpdateDTO;
import com.facens.system.entitites.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;

    public Page<ClientDTO> getClients(PageRequest pageRequest, String name, String address) {
        Page<Client> list = this.repo.find(pageRequest, name, address);

        return list.map(c -> new ClientDTO(c));
    }

    public ClientDTO getClientByIdDto(Long id) {
        Optional<Client> opClient = repo.findById(id);

        Client client = opClient
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));

        return new ClientDTO(client);
    }

    public ClientDTO insertClient(ClientInsertDTO dto) {
        Client entity = new Client(dto);
        entity = this.repo.save(entity);

        return new ClientDTO(entity);
    }

    public void deleteClient(Long id) {
        try {
            this.repo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
    }

    public ClientDTO updateClient(Long id, ClientUpdateDTO dto) {
        try {
            Client entity = this.repo.getOne(id);
            entity.setName(dto.getName());
            entity = this.repo.save(entity);
            return new ClientDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
    }

    public List<ClientDTO> toDTOList(List<Client> list) {
        List<ClientDTO> listDTO = new ArrayList<>();

        for (Client c : list) {
            ClientDTO dto = new ClientDTO(c.getId(), c.getName());
            listDTO.add(dto);
        }

        return listDTO;
    }

}
