package com.facens.system.dtos;

public class ClientDTO {
    
    private Long id; // Long is a object, long is a primative type
    private String name;
    
    public ClientDTO() {

    }
    public ClientDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
