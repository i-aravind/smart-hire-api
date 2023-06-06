package com.bnp.smarthire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bnp.smarthire.entity.RecruiterEntity;

@Repository
public interface RecruiterRepository extends JpaRepository<RecruiterEntity, Long>{
	
	@Query("SELECT r FROM RecruiterEntity r WHERE r.email = :recruiterId")
	public RecruiterEntity getReferenceByEmailId(String recruiterId);
	
	@Query("SELECT r FROM RecruiterEntity r WHERE r.recruiterDbId = :user AND r.password = :password")
	public RecruiterEntity validateRecruiter(Long user, String password);
	
	@Query("SELECT r FROM RecruiterEntity r WHERE r.email = :user AND r.password = :password")
	public RecruiterEntity validateRecruiter(String user, String password);
	

}
