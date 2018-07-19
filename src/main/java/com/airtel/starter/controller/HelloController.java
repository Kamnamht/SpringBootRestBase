package com.airtel.starter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.airtel.starter.model.Starter;
import com.airtel.starter.service.StarterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//@Api
@RestController
@RequestMapping("/starter")
public class HelloController {

	@Autowired
	private StarterService starterService;

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String sayHi() {
		return starterService.hello();
	}

	@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE ,method=RequestMethod.GET)
	public List<Starter> getAllStarter() {

		return starterService.getAllStarter();
	}

	@RequestMapping(value="/{id}" , produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.GET)
	public Starter getStarter(@PathVariable("id") String id) {
		return starterService.getStarter(id);
	}
	
	@ApiOperation(value = "Add Starter ", notes = "Use following values:<br><br>"
			+ "id : Starter Id - Mandatory <br> name : name - Mandatory <br>" + "desc : desc  -  Mandatory <br>")
	@RequestMapping(method=RequestMethod.POST)
	public void addStarter(@RequestBody Starter starter) {
		starterService.addStarter(starter);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public void updateStarter(@RequestBody Starter starter , @PathVariable String id) {
		starterService.updateStarter(id,starter);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void deleteStarter(@PathVariable("id") String id) {
		 starterService.deleteStarter(id);
	}
}
