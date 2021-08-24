package com.Market.demo.Repository;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Market.demo.Model.Savestock;


@Repository
@Transactional
public interface StockRepository extends JpaRepository<Savestock, Integer> {

	List<Savestock> findAllByUsername(String username);
	
	@Modifying
	@Transactional
	@Query("Delete from Savestock u where u.username =:username AND u.stockname=:stockname")
	public int deleteStock(@Param("username") String username, @Param("stockname") String stockname);

}
