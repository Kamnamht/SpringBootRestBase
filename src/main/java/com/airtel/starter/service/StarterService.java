package com.airtel.starter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airtel.starter.model.Starter;
import com.airtel.starter.repository.StarterRepository;


public interface StarterService {

	public String hello();
	
	public List<Starter> getAllStarter();

	public Starter getStarter(String id);

	public void addStarter(Starter starter);

	public void updateStarter(String id, Starter starter);

	public void deleteStarter(String id);

}
