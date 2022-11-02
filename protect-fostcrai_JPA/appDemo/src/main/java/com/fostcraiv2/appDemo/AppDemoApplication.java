package com.fostcraiv2.appDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fostcraiv2.appDemo.entidad.Cliente;
import com.fostcraiv2.appDemo.respository.ClienteRepository;

@SpringBootApplication
public class AppDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AppDemoApplication.class, args);
	}

	@Autowired
	private ClienteRepository repositorio;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		Cliente cliente1 = new Cliente("simon", "monsalve", "3153786789", "simon@gmail.com", "barrio chico norte", "2022/12/15");
		repositorio.save(cliente1);
		
		Cliente cliente2 = new Cliente("ingrid", "lopez", "3128909878", "ingrid@gmail.com", "carrera98 a bis 39 50 norte", "2023/02/10");
		repositorio.save(cliente2);
		*/
		}

}
