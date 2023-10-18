package com.example.demo.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@CrossOrigin
@RestController
public class UserController {
     
	@Autowired
	UserService u;
	
	@PostMapping("/post1")
	public User Saveinfo(@RequestBody User a) {
		return u.saveInfo(a);
	}
	@GetMapping("/get123/{email}")
	public User Getinfo1(@PathVariable String email){
		return u.getdata(email);
	}
	@GetMapping("/getSignup/{email}")
	public int Getinfo12(@PathVariable String email){
		return u.Exists(email);
	}
	
	@GetMapping("/get11/{id}")
	public User Getinfo1(@PathVariable int id){
		return u.get2(id);
	}
	@GetMapping("/get1/{id}")
	public Optional<User> GetinfoId(@PathVariable int id){
		return u.getInfoid(id);
	}
	@GetMapping("/get12/{date}")
	public List<User> GetinfoId(@PathVariable Date date){
		return u.getInfobyd(date);
	}
	@DeleteMapping("/delete1/{id}")
	public String DeleteInfoId(@PathVariable int id) {
		u.deleteInfoid(id);
		return "Deleted Successfully";
	}

	@PutMapping("putbyid/{id}")
	public String updatebyid(@RequestBody User aa, @PathVariable int id) {
		Optional<User> temp = u.getInfoid(id);
		if(temp.isPresent()) {
			u.update(id,aa);
			return "Object updated successfully!";
		}
		return "Enter a valid id!";
	}
	  //Paging
	  @GetMapping("userpages1/{pageno}/{pagesize}")
	  public List<User> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize){
		  return u.getbypage(pageno,pagesize);
	  }
}
