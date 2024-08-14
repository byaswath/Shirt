package com.ShirtLog;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShirtLogService {
	@Autowired
	ShirtLogDao sd;
	
	public String postAllShirt(List<ShirtLogEntity> s) {
		return sd.postAllShirt(s);
	}
	
	public Optional<ShirtLogEntity> getOneShirt(int a) {
		return sd.getOneShirt(a);
	}
	
	public List<ShirtLogEntity> getAllShirt() {
		return sd.getAllShirt();
	}
	
	public List<ShirtLogEntity> getNoSuchColorException(String b) throws NoSuchColorException {
		List<ShirtLogEntity> x = sd.getAllShirt();
		List<ShirtLogEntity> noSuchColor = x.stream().filter(y -> y.getColor().equals(b)).collect(Collectors.toList());
		if(noSuchColor.isEmpty()) {
			throw new NoSuchColorException("The Given Color Not Found");
		}
		else {
			return noSuchColor;
		}
	}

}
