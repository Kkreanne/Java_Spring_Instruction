package com.stuffy.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.stuffy.business.Stuffy;
import com.stuffy.db.StuffyRepository;

@CrossOrigin
@RestController
@RequestMapping("/stuffies")
public class StuffyController {

	@Autowired
	private StuffyRepository stuffyRepo;
	
	@GetMapping("/")
	public Iterable<Stuffy> listStuffies() {
		return stuffyRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Stuffy> getStuffy(@PathVariable int id) { //optional is used for null
		return stuffyRepo.findById(id);
	}
	
	@PostMapping("/")
	public Stuffy addStuffy(@RequestBody Stuffy s) { //optional is used for null
		return stuffyRepo.save(s);
	}
	
}
