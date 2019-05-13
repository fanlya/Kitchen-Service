//package com.pbkk.KitchenService.service;
//
//import java.util.LinkedList;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//import com.pbkk.KitchenService.model.*;
//
//@Service
//public class KitchenServiceImpl implements KitchenService {
//	@Override
//	public void createStatus (Integer id_order) {
//		this.kitchenmodels.add(new KitchenModel(id_order));
//	}
//	
//	@Override
//	public KitchenModel getStatus(Integer id_status) {
//		// TODO Auto-generated method stub
//		return kitchenmodels.stream()
//				.filter(x -> x.getId_status().intValue()  == id_status.intValue())
//				.findAny()
//				.orElse(null);
//	}
//	@Override
//	public void updateStatus(Integer id_status, String status) {
//		// TODO Auto-generated method stub
//		kitchenmodels.stream()
//		.filter(x -> x.getId_status()  == id_status)
//		.findAny()
//		.orElseThrow(() -> new RuntimeException("Item not found"))
//		.setStatus(status);	
//	}
//	@Override
//	public void deleteStatus(Integer id_status) {
//		// TODO Auto-generated method stub
//		kitchenmodels.removeIf((KitchenModel u) -> u.getId_status() == id_status);
//	}
//		
//	public static List<KitchenModel> kitchenmodels;
//	
//	public KitchenServiceImpl() {
//		kitchenmodels = new LinkedList<>();
//		kitchenmodels.add(new KitchenModel(0));
//		kitchenmodels.add(new KitchenModel(2));
//		kitchenmodels.add(new KitchenModel(1));
//		
//		
//	}
//
//	@Override
//	public List<KitchenModel> getAll() {
//		return this.kitchenmodels;
//	}
//}
