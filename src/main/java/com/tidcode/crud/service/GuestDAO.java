package com.tidcode.crud.service;

import java.util.List;

import com.tidcode.crud.entity.Guest;

public interface GuestDAO {

	List<Guest> findAll();
}
