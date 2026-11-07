package com.klu.lab.controller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.klu.lab.entity.Account;
import com.klu.lab.service.AccountService;

@Controller
@RequestMapping("account")
public class AccountController {

	@Autowired
	private AccountService service;
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Account a) {   
												
		String output= service.addAccount(a);
		return ResponseEntity.status(201).body(output);  
	}
	@GetMapping("/displayall")
	public ResponseEntity<List<Account>> displayAll(){
		List<Account> acclist = service.displayAccounts();
		return ResponseEntity.ok().body(acclist);   
	}
	
	@GetMapping("/displaybyid/")
	public ResponseEntity<?> displayuserbyId(@RequestParam int id) {   
		Account u = service.displayAccountById(id);
		if(u!=null) {
			return ResponseEntity.ok().body(u);
		}else {
			return ResponseEntity.ok().body("User ID Not Found");  
		}
	}
}
