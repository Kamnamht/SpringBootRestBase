package com.airtel.starter.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airtel.starter.model.Starter;
import com.airtel.starter.repository.StarterRepository;
import com.airtel.starter.service.StarterService;

@Service
public class StarterServiceImpl implements StarterService{

	@Autowired
	private StarterRepository starterRepository;

	List<Starter> starterList = new ArrayList<>(
			Arrays.asList(new Starter("1", "hello", "Come In!!"), new Starter("2", "Bye", "Get Lost!!")));;

	public List<Starter> getAllStarter() {
//		return starterList;
		
		List<Starter> starters=new ArrayList<>();
		starterRepository.findAll().forEach(starters::add);
		return starters;
	}

	public Starter getStarter(String id) {
 
//		return starterList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	return	starterRepository.findById(id).orElse(null);
	}

	public void addStarter(Starter starter) {
//		starterList.add(starter);
		starterRepository.save(starter);
	}

	public void updateStarter(String id, Starter starter) {

//		for (int i = 0; i < starterList.size(); i++) {
//			Starter s = starterList.get(i);
//			if (s.getId().equals(id)) {
//				starterList.set(i, starter);
//			}
//		}
		starterRepository.save(starter);
	}

	public void deleteStarter(String id) {
//		starterList.removeIf(t -> t.getId().equals(id));
		starterRepository.deleteById(id);
	}

	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return "Hi";
	}

}
