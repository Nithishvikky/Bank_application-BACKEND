package com.example.demo.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Transaction;

import jakarta.transaction.Transactional;

public interface TransactionRepo extends JpaRepository<Transaction, Integer>{
	 @Query(value="select transaction_id,transaction_date,transaction_type,amount,A.account_id from transaction_table T join account_table A on  A.account_id=T.account_id Join user_table U on A.user_id=U.user_id where U.user_id=:s",nativeQuery=true)
	    public Page<Transaction> getInfo1(@Param("s") int User,Pageable pageable);
	 @Query(value="select count(*) from transaction_table T join account_table A on  A.account_id=T.account_id Join user_table U on A.user_id=U.user_id where U.user_id=:s",nativeQuery=true)
	    public int getInfo2(@Param("s") int User);
	 
	 @Modifying
	 @Transactional
	 @Query(value="delete from transaction_table where account_id=:s",nativeQuery=true)
	    public void deleteInfo(@Param("s") int Transaction);
	 
}

