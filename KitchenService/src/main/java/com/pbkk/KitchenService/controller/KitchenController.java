package com.pbkk.KitchenService.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pbkk.KitchenService.Repository.KitchenRepository;
import com.pbkk.KitchenService.model.*;
import com.pbkk.KitchenServiceUtil.*;

@RestController
@RequestMapping("/Kitchen/Order")
public class KitchenController {
	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
	private KitchenRepository kitchenRepository;

	@ResponseBody
	@RequestMapping("")
	public Iterable<KitchenModel> test() {
		return kitchenRepository.findAll();
		//return kitchenService.getAll();
//		return Util.getSuccessResult(kitchenService.getAll());
	}
	
	@ResponseBody
	@RequestMapping("/{id}")
	public Optional<KitchenModel> getKitchen(@PathVariable("id") Integer id) {
		return kitchenRepository.findById(id);
		//return kitchenService.getStatus(id);
	}	
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Map<String, Object> deleteStatus(
			@PathVariable("id") Integer id) {
		kitchenRepository.deleteById(id);
	    //kitchenService.deleteStatus(id_status); 
	    return Util.getSuccessResult();
	}
	
	@ResponseBody
	@RequestMapping(value = "/createStatus", method = RequestMethod.POST)
	public Map<String, Object> createStatus(			
			@RequestParam(value = "id_order") Integer id_order) {
		KitchenModel u = new KitchenModel();
		u.setId_order(id_order);
		u.setStatus(false);
		kitchenRepository.save(u);
		//kitchenService.createStatus(id_order);
		return Util.getSuccessResult();
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Map<String, Object> updateUser(
			@RequestParam(value = "id_ostatus") Integer id,
			@RequestParam(value = "status") Boolean status) {
		KitchenModel k = kitchenRepository.findById(id).get();
		k.setStatus(status);
		kitchenRepository.save(k);
		//kitchenService.updateStatus (id, status);		
		return Util.getSuccessResult();
	}
	
}
