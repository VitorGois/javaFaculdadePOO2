package com.facens.system.controllers;

import java.net.URI;
import java.util.List;

import com.facens.system.dtos.ClientDTO;
import com.facens.system.dtos.ClientInsertDTO;
import com.facens.system.dtos.ClientUpdateDTO;
import com.facens.system.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/clients")
public class ClientController {
    
    @Autowired
    private ClientService service;

    @GetMapping()
    public ResponseEntity<List<ClientDTO>> getClients() {
        
        List<ClientDTO> list = this.service.getClients();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        ClientDTO dto = this.service.getClientByIdDto(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping()
    public ResponseEntity<ClientDTO> insertClient(@RequestBody ClientInsertDTO insertDto) {
        ClientDTO dto = this.service.insertClient(insertDto);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        this.service.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientUpdateDTO updateDto, @PathVariable Long id) {
        ClientDTO dto = this.service.updateClient(id, updateDto);
        
        return ResponseEntity.ok().body(dto); 
    }

}
