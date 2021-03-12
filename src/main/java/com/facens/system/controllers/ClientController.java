package com.facens.system.controllers;

import java.util.List;

import com.facens.system.dtos.ClientDTO;
import com.facens.system.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {
    
    @Autowired
    private ClientService service;

    @GetMapping()
    public ResponseEntity<List<ClientDTO>> getClient() {
        
        List<ClientDTO> list = this.service.getClients();

        return ResponseEntity.ok(list);
    }

}
