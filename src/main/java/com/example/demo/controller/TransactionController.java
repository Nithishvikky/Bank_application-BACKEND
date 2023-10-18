package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Transaction;
import com.example.demo.service.TransactionService;

@CrossOrigin
@RestController
public class TransactionController {

	@Autowired
	TransactionService u;
	
	@PostMapping("/post2")
	public Transaction Saveinfo(@RequestBody Transaction a) {
		return u.saveInfo(a);
	}
	
	@GetMapping("/get3/{id}/{page}/{size}")
	public List<Transaction> Getinfo(@PathVariable int id,@PathVariable int page, @PathVariable int size){
		return u.getInfo(id,page,size);
	}
	@GetMapping("/get31/{id}")
	public int Getinfo1(@PathVariable int id){
		return u.getInfo21(id);
	}

	@DeleteMapping("/delete3/{id}")
	public void DeleteInfoId(@PathVariable int id) {
		u.deleteInfoid(id);
	}
}
