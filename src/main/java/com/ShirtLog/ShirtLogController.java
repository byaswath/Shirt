package com.ShirtLog;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShirtLogController {
	@Autowired
	ShirtLogService ss;
	Logger log = Logger.getLogger(ShirtLogController.class);
	
	@PostMapping(value = "/postAllShirt")
	public String postAllShirt(@RequestBody List<ShirtLogEntity> s) {
		return ss.postAllShirt(s);
	}
	
	@GetMapping(value = "/getAllShirt")
	public List<ShirtLogEntity> getAllShirt() {
		PropertyConfigurator.configure("log4j.properties");
		log.info(ss.getAllShirt());
		return ss.getAllShirt();
	}
	
	@GetMapping(value = "/getOneShirt/{a}")
	public Optional<ShirtLogEntity> getOneShirt(@PathVariable int a) {
		PropertyConfigurator.configure("log4j.properties");
		log.info(ss.getOneShirt(a));
		return ss.getOneShirt(a);
	}
	
	@GetMapping(value = "/getShirtByColor/{b}")
	public List<ShirtLogEntity> getNoSuchColorException(@PathVariable String b) throws NoSuchColorException {
		PropertyConfigurator.configure("log4j.properties");
		log.info(ss.getNoSuchColorException(b));
		return ss.getNoSuchColorException(b);
	}

}
