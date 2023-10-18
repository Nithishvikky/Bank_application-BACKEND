package com.example.demo.service;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.Accounts;
import com.example.demo.repository.AccountsRepo;


//import jakarta.persistence.EntityNotFoundException;

@Service
public class AccountsService {
    
	@Autowired
	AccountsRepo a;
	
	public Accounts saveInfo(Accounts e) {
		return a.save(e);
	}
	public List<Accounts> getInfoUserId(int id){
		return a.getAccounts(id);
	}
	public Optional<Accounts> getInfoid(int id){
		return a.findById(id);
	}
	public Accounts updateinfo(Accounts e) {
		return a.saveAndFlush(e);
	}
	public void deleteInfo() {
		a.deleteAll();
	}
	public void deleteInfoid(int id) {
		a.deleteaccount(id); 
	}
	public void updateAccount(int id) {
	     a.updatebalance(id);
	}
	public void updateAccount1(int id) {
	     a.updatebalance1(id);
	}

}
