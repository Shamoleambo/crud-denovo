package com.tidcode.crud;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tidcode.crud.dao.GuestDAO;
import com.tidcode.crud.entity.Guest;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(GuestDAO guestDAO) {
		return args -> {
//			findAllGuests(guestDAO);
//			addGuest(guestDAO);
//			addMultipleGuests(guestDAO);
//			findById(guestDAO);
//			findAllOrderByFirstName(guestDAO);
//			updateGuest(guestDAO);
//			listAllByLastName(guestDAO);
			deleteGuest(guestDAO);
		};
	}

	private void findAllGuests(GuestDAO guestDAO) {
		List<Guest> guests = guestDAO.findAll();

		for (Guest guest : guests) {
			System.out.println(guest);
		}
	}

	private void addGuest(GuestDAO guestDAO) {
		Guest newGuest = new Guest("Mano", "Silva", true, "mano@mail.com");
		Guest mano = guestDAO.save(newGuest);
		System.out.println(mano);
	}

	private void addMultipleGuests(GuestDAO guestDAO) {
		Guest fulano = new Guest("Fulano", "Dahora", true, "fulano@mail.com");
		Guest beltrano = new Guest("Beltrano", "Maneiro", true, "beltrano@mail.com");
		Guest sicrano = new Guest("Sicrano", "Legal", true, "sicrano@mail.com");

		Guest ful = guestDAO.save(fulano);
		Guest bel = guestDAO.save(beltrano);
		Guest sic = guestDAO.save(sicrano);

		System.out.println(ful);
		System.out.println(bel);
		System.out.println(sic);
	}

	private void findById(GuestDAO guestDAO) {
		Guest foundGuest = guestDAO.findById(3);
		System.out.println(foundGuest);
	}

	private void findAllOrderByFirstName(GuestDAO guestDAO) {
		List<Guest> guests = guestDAO.findAllOrderBy("firstName");

		for (Guest guest : guests) {
			System.out.println(guest);
		}
	}

	private void updateGuest(GuestDAO guestDAO) {
		Guest guest = new Guest("Truta", "Fimeza", true, "truta@mail.com");
		guest.setId(3L);
		Guest updtGuest = guestDAO.update(guest);
		System.out.println(updtGuest);
	}

	private void listAllByLastName(GuestDAO guestDAO) {
		List<Guest> guests = guestDAO.findByLastName("Dahora");
		for (Guest guest : guests) {
			System.out.println(guest);
		}
	}
	
	private void deleteGuest(GuestDAO guestDAO) {
		guestDAO.delete(1);
	}
}
