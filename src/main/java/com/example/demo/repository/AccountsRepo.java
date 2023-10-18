package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Accounts;

import jakarta.transaction.Transactional;

public interface AccountsRepo extends JpaRepository<Accounts, Integer>{
	 @Query(value="Select * from account_table Where user_id=:s",nativeQuery=true)
	    public List<Accounts> getAccounts(@Param("s") int User);
	 @Modifying
	 @Transactional
	 @Query(value="delete from account_table Where account_id=:s",nativeQuery=true)
	    public void deleteaccount(@Param("s") int Accounts);
	 
	 @Modifying
	 @Transactional
	 @Query(value="update account_table set balance = balance+(select amount from transaction_table where account_id=:s order by transaction_id desc limit 1) where account_id=:s",nativeQuery=true)
	 public void updatebalance(@Param("s") int Accounts);
	 @Modifying
	 @Transactional
	 @Query(value="update account_table set balance = balance-(select amount from transaction_table where account_id=:s order by transaction_id desc limit 1) where account_id=:s",nativeQuery=true)
	 public void updatebalance1(@Param("s") int Accounts);
}
