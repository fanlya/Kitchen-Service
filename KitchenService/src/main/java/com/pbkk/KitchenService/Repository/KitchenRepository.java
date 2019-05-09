package com.pbkk.KitchenService.Repository;
import org.springframework.data.repository.CrudRepository;

import com.pbkk.KitchenService.model.*;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


public interface KitchenRepository extends CrudRepository<KitchenModel, Integer>{
}
