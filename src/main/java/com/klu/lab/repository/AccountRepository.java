package com.klu.lab.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.lab.entity.Account;

@Repository 
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
}
