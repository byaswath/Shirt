package com.ShirtLog;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShirtLogDao {
	@Autowired
	ShirtLogRepository sr;
	
	public String postAllShirt(List<ShirtLogEntity> s) {
		sr.saveAll(s);
		return "Posted All Successfully";
	}
	
	public Optional<ShirtLogEntity> getOneShirt(int a) {
		return sr.findById(a);
	}
	
	public List<ShirtLogEntity> getAllShirt() {
		return sr.findAll();
	}
	
	

}
