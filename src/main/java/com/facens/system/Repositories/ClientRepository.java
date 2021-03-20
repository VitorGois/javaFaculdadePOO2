package com.facens.system.repositories;

import com.facens.system.entitites.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface ClientRepository extends JpaRepository <Client, Long> {

}
