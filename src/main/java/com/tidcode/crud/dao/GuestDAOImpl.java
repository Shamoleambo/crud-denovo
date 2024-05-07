package com.tidcode.crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryAccessor;
import org.springframework.stereotype.Repository;

import com.tidcode.crud.entity.Guest;

import jakarta.persistence.EntityManager;

@Repository
public class GuestDAOImpl implements GuestDAO {

	private EntityManager entityManager;

	@Autowired
	public GuestDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Guest> findAll() {
		return this.entityManager.createQuery("FROM Guest", Guest.class).getResultList();
	}

}
