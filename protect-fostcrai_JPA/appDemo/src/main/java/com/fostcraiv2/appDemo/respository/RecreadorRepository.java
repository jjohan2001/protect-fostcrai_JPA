package com.fostcraiv2.appDemo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fostcraiv2.appDemo.entidad.Recreador;

@Repository
public interface RecreadorRepository extends JpaRepository<Recreador, Long>{
	
	

}
