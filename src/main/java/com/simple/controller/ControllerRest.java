package com.simple.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.simple.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.simple.model.Coche;

import static java.util.Arrays.*;


@RestController
public class ControllerRest {

	@Autowired
	RestService restService;

	@RequestMapping(value = "/coches/{id}", method = RequestMethod.GET)
	String getCoches(@PathVariable Integer id) {



		return restService.methodGet(id);
	}

	@RequestMapping(value = "/coches/all", method = RequestMethod.GET)
	List<Coche> getAllCoches() {

		return restService.methodGetAll();
	}

}
