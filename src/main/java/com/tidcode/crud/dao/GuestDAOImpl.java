package com.tidcode.crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryAccessor;
import org.springframework.stereotype.Repository;

import com.tidcode.crud.entity.Guest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class GuestDAOImpl implements GuestDAO {

	private EntityManager entityManager;

	@Autowired
	public GuestDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Guest> findAll() {
		return this.entityManager.createQuery("FROM Guest", Guest.class).getResultList();
	}

	@Override
	@Transactional
	public Guest save(Guest guest) {
		return this.entityManager.merge(guest);
	}

	@Override
	public Guest findById(int id) {
		return this.entityManager.find(Guest.class, id);
	}

	@Override
	public List<Guest> findAllOrderBy(String orderCriteria) {
		return this.entityManager.createQuery("FROM Guest ORDER BY " + orderCriteria, Guest.class).getResultList();
	}

	@Override
	@Transactional
	public Guest update(Guest guest) {
		return this.entityManager.merge(guest);
	}

	@Override
	public List<Guest> findByLastName(String lastName) {
		TypedQuery<Guest> query = this.entityManager.createQuery("FROM Guest WHERE lastName=:lastName", Guest.class);
		query.setParameter("lastName", lastName);
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void delete(int id) {
		Guest guest = this.findById(id);
		this.entityManager.remove(guest);
	}

}
