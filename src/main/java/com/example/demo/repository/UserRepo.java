package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;


public interface UserRepo extends JpaRepository<User, Integer>{
    @Query(value="Select * from user_table Where user_id=:s",nativeQuery=true)
    public User getInfo1(@Param("s") int User);
     
    @Query(value="Select * from user_table Where date_of_birth=:s",nativeQuery=true)
    public List<User> getInfoDate(@Param("s") Date User);
    
    @Query(value="Select * from user_table where email=:s",nativeQuery=true)
    public User getuserdata(@Param("s") String User);
    
    @Query(value="Select count(*) from user_table where email=:s",nativeQuery=true)
    public int getSignUp(@Param("s") String User);
    
}
