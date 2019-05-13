package com.pbkk.KitchenService.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pbkk.KitchenService.Repository.OrderStatusRepository;
import com.pbkk.KitchenService.model.*;
import com.pbkk.KitchenServiceUtil.*;

@RestController
@RequestMapping("/kitchen/order")

public class OrderStatusController {
	
	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
	private OrderStatusRepository orderstatusRepository;

	@ResponseBody
	@RequestMapping("")
	public Iterable<OrderStatusModel> test() {
		return orderstatusRepository.findAll();
	}
	
	@ResponseBody
	@RequestMapping("/{id_ostatus}")
	public Optional<OrderStatusModel> getOrderStatus(@PathVariable("id_ostatus") Integer id) {
		return orderstatusRepository.findById(id);
	}	
	
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Map<String, Object> createStatus(@RequestParam(value = "id_order") Integer id)
	{
		OrderStatusModel o = new OrderStatusModel();
		o.setId_order(id);
		o.setStatus(0);
		orderstatusRepository.save(o);
		return Util.getSuccessResult();
	}
	
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Map<String, Object> updateUser(
		@RequestParam(value = "id_ostatus") Integer id,
		@RequestParam(value = "order_status") Integer status)
	{
		OrderStatusModel o = orderstatusRepository.findById(id).get();
		o.setStatus(status);
		orderstatusRepository.save(o);
		return Util.getSuccessResult();
	}
	
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public Map<String, Object> deleteStatus(@RequestParam(value = "id_ostatus") Integer id)
	{
		orderstatusRepository.deleteById(id);
	    return Util.getSuccessResult();
	}
	
}