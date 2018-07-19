package com.airtel.starter.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.airtel.starter.model.Starter;

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//  entityManagerFactoryRef = "entityManagerFactory",
//  basePackages = { "com.foobar.foo.repo" }
//)
public interface OracleRepository extends CrudRepository<Starter, String> {


}
