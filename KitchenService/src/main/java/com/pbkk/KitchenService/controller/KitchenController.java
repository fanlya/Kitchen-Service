package com.pbkk.KitchenService.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pbkk.KitchenService.model.*;
import com.pbkk.KitchenServiceUtil.*;
import com.pbkk.KitchenService.service.*;

@RestController
@RequestMapping("/Kitchen")
public class KitchenController {
	@Autowired
	KitchenService kitchenService;
	
	@ResponseBody
	@RequestMapping("")
	public List<KitchenModel> test() {
		return kitchenService.getAll();
//		return Util.getSuccessResult(kitchenService.getAll());

	}
	
	@ResponseBody
	@RequestMapping("/{id}")
	public KitchenModel getKitchen(@PathVariable("id") Integer id) {
		
		return kitchenService.getStatus(id);
	}	
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Map<String, Object> deleteStatus(
			@PathVariable("id") Integer id_status) {
		   
	    kitchenService.deleteStatus(id_status); 
	    return Util.getSuccessResult();
	}
	
	@ResponseBody
	@RequestMapping(value = "/createStatus", method = RequestMethod.POST)
	public Map<String, Object> createStatus(			
			@RequestParam(value = "id_order") Integer id_order) {
			kitchenService.createStatus(id_order);
			return Util.getSuccessResult();
	}
	
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Map<String, Object> updateUser(@RequestParam(value = "id_status") Integer id,
			@RequestParam(value = "status") String status) {
		
		kitchenService.updateStatus (id, status);		
		return Util.getSuccessResult();
	}
}
