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
			findAllGuests(guestDAO);
		};
	}

	private void findAllGuests(GuestDAO guestDAO) {
		List<Guest> guests = guestDAO.findAll();

		for (Guest guest : guests) {
			System.out.println(guest);
		}
	}
}
