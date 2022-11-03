package com.fostcraiv2.appDemo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fostcraiv2.appDemo.entidad.Capacitacion;

@Repository
public interface CapacitacionRepository extends JpaRepository<Capacitacion, Long>{
	
	

}
