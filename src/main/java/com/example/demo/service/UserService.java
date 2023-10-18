package com.example.demo.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
        
	@Autowired
	UserRepo u;
	
	public User saveInfo(User e) {
		return u.save(e);
	}
	public List<User> getInfo(){
		return u.findAll();
	}
	public User get2(int id){
		return u.getInfo1(id);
	}
	public List<User> getInfobyd(Date date){
		return u.getInfoDate(date);
	}
	public void deleteInfo() {
		u.deleteAll();
	}
	
	public Optional<User> getInfoid(int id){
		return u.findById(id);
	}
	public User updateinfo(User e) {
		return u.saveAndFlush(e);
	}
	public void deleteInfoid(int id) {
		u.deleteById(id); 
	}
	public User getdata(String email) {
		return u.getuserdata(email);
	}
	public int Exists(String email) {
		return u.getSignUp(email);
	}
	public User update(int id,User a) {
		User existingEntity = u.findById(id).orElse(null);
		if(existingEntity != null) {
			existingEntity.setUsername(a.getUsername());
			existingEntity.setFirst_name(a.getFirst_name());
			existingEntity.setLast_name(a.getLast_name());
			existingEntity.setDateOfBirth(a.getDateOfBirth());
			existingEntity.setAddress(a.getAddress());
			existingEntity.setGender(a.getGender());
			
			return u.save(existingEntity);
		}
		else {
			throw new EntityNotFoundException("Row not found with id: " + id);
		}
	}
	//Ascending
	public List<User>sortuserinfo (String s){
		return u.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
	}
	//Descending
	public List<User>sortuserinfo1 (String s){
		return u.findAll(Sort.by(Sort.Direction.DESC,s));
	}
	//Paging
	public List<User> getbypage(int pgno,int pgsize){
		Page<User> p=u.findAll(PageRequest.of(pgno, pgsize));
		return p.getContent();		
	}
}
