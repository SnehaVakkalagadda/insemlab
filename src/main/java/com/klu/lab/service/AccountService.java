package com.klu.lab.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.lab.entity.Account;
import com.klu.lab.repository.AccountRepository;

@Service
public class AccountService  {  

	@Autowired
	private AccountRepository repository;
	
	public String addAccount(Account ac) {
		repository.save(ac);   
		return "User Added Successfully";
	}

	public String updateUser(Account ac) {   
		Optional<Account> optionaluser = repository.findById(ac.getAccountNo());  
		if(optionaluser.isPresent()) {
			Account u=optionaluser.get();   
			u.setName(ac.getName());
			u.setMobile(ac.getMobile());
			u.setGender(ac.getGender());
			repository.save(u);  
			return "User Updated Successfully";
		}else {
			return "User Id Is Not Found To Update";
		}
	}

	public List<Account> displayAccounts() {
		return repository.findAll();
	}

	public Account displayAccountById(int id) {
		return repository.findById(id).orElse(null);
	}
	
}
