package com.airtel.starter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.airtel.starter.model.Starter;

//@Repository
public interface StarterRepository extends CrudRepository<Starter, String> {


}
