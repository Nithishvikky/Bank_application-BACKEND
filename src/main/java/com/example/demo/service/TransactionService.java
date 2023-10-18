package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Transaction;

import com.example.demo.repository.TransactionRepo;

@Service
public class TransactionService {

	@Autowired
	TransactionRepo u;
	
	public Transaction saveInfo(Transaction e) {
		return u.save(e);
	}
	public List<Transaction> getInfo(int id,int page,int size){
		Pageable pageable = PageRequest.of(page, size);
        Page<Transaction> pageResult = u.getInfo1(id, pageable);
        return pageResult.getContent();
	}
	public int getInfo21(int id){
		return u.getInfo2(id);
	}

	public void deleteInfoid(int id){
		u.deleteInfo(id);
	}
	
}
