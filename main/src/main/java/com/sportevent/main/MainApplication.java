package com.sportevent.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sportevent.main.domain.Category;
import com.sportevent.main.domain.CategoryRepository;
import com.sportevent.main.domain.Event;
import com.sportevent.main.domain.EventRepository;
import com.sportevent.main.domain.User;
import com.sportevent.main.domain.UserRepository;


@SpringBootApplication
public class MainApplication {

	private static final Logger log = LoggerFactory.getLogger(MainApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(EventRepository erepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("create few events");
			crepository.save(new Category("Football"));
			crepository.save(new Category("Jogging"));
			crepository.save(new Category("Theory"));
			crepository.save(new Category("Gym"));
			
			erepository.save(new Event("Solent Stadium", "1.1.2018", "17.00", crepository.findByName("Football").get(0) ));
			erepository.save(new Event("Pasila Campus", "3.1.2018","18.30", crepository.findByName("Jogging").get(0)));
			erepository.save(new Event("Pasila Campus", "8.1.2018","07.15", crepository.findByName("Jogging").get(0)));
			erepository.save(new Event("Haaga Campus", "11.1.2018","20.00", crepository.findByName("Gym").get(0)));
			
			// Create test users for project: adminadmin useruser
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("events");
			for (Event event : erepository.findAll()) {
				log.info(event.toString());
			}

		};
	}
}

