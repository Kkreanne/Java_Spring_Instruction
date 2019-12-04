package com.customer.service.CS;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.customer.service.util.JsonResponse;

@CrossOrigin
@RestController
@RequestMapping("/customers")
public class CSController {
	
	@Autowired
	private CSRepository CSrepo;
	
	@GetMapping()
	public JsonResponse getAll() {
		return JsonResponse.getInstance(CSrepo.findAll());
	}
	
	@GetMapping("/{id}")
	public JsonResponse get(@PathVariable Integer id) {
		try {
			Optional<CS> ocs = CSrepo.findById(id);
			if(!ocs.isPresent()) {
				return JsonResponse.getInstance("Customer not found");
			}
			return JsonResponse.getInstance(ocs.get());
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResponse.getInstance(e);
		}
	}
	
	private JsonResponse save(CS cs) {
		try {
			CS scs = CSrepo.save(cs);
			return JsonResponse.getInstance(scs);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResponse.getInstance(e);
		}
	}
	
	@PostMapping()
	public JsonResponse insert(CS cs) {
		return save(cs);
	}
	
	@PutMapping("/{id}")
	public JsonResponse update(CS cs, @PathVariable Integer id) {
		return save(cs);
	}
	
	@DeleteMapping("/{id}")
	public JsonResponse delete(@PathVariable Integer id) {
		try {
			Optional<CS> ocs = CSrepo.findById(id);
			if(!ocs.isPresent()) {
				return JsonResponse.getInstance("Customer not found");
			}
			CSrepo.deleteById(id);
			return JsonResponse.getInstance(ocs.get());
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResponse.getInstance(e);
		}
	}
}
