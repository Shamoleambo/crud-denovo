package com.tidcode.crud.dao;

import java.util.List;

import com.tidcode.crud.entity.Guest;

public interface GuestDAO {

	List<Guest> findAll();
	Guest save(Guest guest);
	Guest findById(int id);
	List<Guest> findAllOrderBy(String orderCriteria);
	Guest update(Guest guest);
}
