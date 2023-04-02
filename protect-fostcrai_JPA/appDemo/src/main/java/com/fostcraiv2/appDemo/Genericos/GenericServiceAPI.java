package com.fostcraiv2.appDemo.Genericos;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;


public interface GenericServiceAPI<T, ID extends Serializable> {

	T save(JsonNode json);
	
	void delete(ID id);
	
	T get(ID id);
	
	List<T> getAll();

	T save(T entity);
}
