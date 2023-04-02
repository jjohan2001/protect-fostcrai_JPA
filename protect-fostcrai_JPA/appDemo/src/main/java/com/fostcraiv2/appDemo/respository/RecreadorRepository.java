package com.fostcraiv2.appDemo.respository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fostcraiv2.appDemo.entidad.Recreador;
import com.fostcraiv2.appDemo.entidad.Usuario;

@Repository
public interface RecreadorRepository extends JpaRepository<Recreador, Long>{

	
	

}
