package com.bmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bmdb.business.JsonResponse;
import com.bmdb.db.SummaryRepository;

@CrossOrigin
@RestController
@RequestMapping("/summarys")
public class SummaryController {
	@Autowired
	private SummaryRepository sumRepo;
	
	@GetMapping("/")
	public JsonResponse listSummary() {
		JsonResponse jr = null;
		try  {
			jr = JsonResponse.getInstance(sumRepo.findAll());			
		}
		catch (Exception e) {
			jr = JsonResponse.getInstance(e.getMessage());
		}
		return jr;
	}
	
	@GetMapping("/{id}")
	public JsonResponse getSummary(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(sumRepo.findById(id));
		}
		catch (Exception e) {
			jr = JsonResponse.getInstance(e.getMessage());
		}
		return jr;
	}
}
