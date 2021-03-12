package com.facens.system.Repositories;

import java.util.ArrayList;
import java.util.List;

import com.facens.system.entitites.Client;

import org.springframework.stereotype.Component;

@Component
public class ClientRepository {
    
    public List<Client> getClients() {
        Client c1 = new Client();
        c1.setId(1l);
        c1.setName("Vitor");
        c1.setAddress("Pilar do Sul");
        
        Client c2 = new Client();
        c2.setId(2l);
        c2.setName("João");
        c2.setAddress("Sorocaba");

        List<Client> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        
        return list;
    }
    
}
