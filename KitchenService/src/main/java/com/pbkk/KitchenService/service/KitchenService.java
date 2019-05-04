package com.pbkk.KitchenService.service;

import java.util.List;

import com.pbkk.KitchenService.model.*;

public interface KitchenService {
	void createStatus (Integer id_order);
	KitchenModel getStatus(Integer id_status);
	void updateStatus (Integer id_status, String status);
	void deleteStatus (Integer id_status);
	List<KitchenModel > getAll();
}
