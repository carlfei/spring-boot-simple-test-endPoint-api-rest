package com.simple.controller;

import java.util.List;
import com.simple.service.restService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.simple.model.Coche;


@RestController
public class ControllerRest {

	@Autowired
	restService hDosService;

	@RequestMapping(value = "/coches/{id}", method = RequestMethod.GET)
	String getCoches(@PathVariable Integer id) {

		return hDosService.methodGet(id);
	}

	@RequestMapping(value = "/coches/all", method = RequestMethod.GET)
	List<Coche> getAllCoches() {

		return hDosService.methodGetAll();
	}

}
