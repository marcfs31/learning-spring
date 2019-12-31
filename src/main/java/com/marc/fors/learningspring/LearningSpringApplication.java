package com.marc.fors.learningspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marc.fors.learningspring.data.entity.Guest;
import com.marc.fors.learningspring.data.entity.Reservation;
import com.marc.fors.learningspring.data.entity.Room;
import com.marc.fors.learningspring.data.repository.GuestRepository;
import com.marc.fors.learningspring.data.repository.ReservationRepository;
import com.marc.fors.learningspring.data.repository.RoomRepository;

@SpringBootApplication
public class LearningSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringApplication.class, args);
	}
	
	@RestController
	public class MainController {
		@Autowired
		private ReservationRepository reservationRepository;
		
		@Autowired 
		private RoomRepository roomRepository;
		
		@Autowired 
		private GuestRepository guestRepository;
		
		@GetMapping
		@RequestMapping("/rooms")
		public Iterable<Room> getRooms() {
			return this.roomRepository.findAll();
		}
		
		@GetMapping
		@RequestMapping("/reservations")
		public Iterable<Reservation> getReservations() {
			return this.reservationRepository.findAll();
		}
		
		@GetMapping
		@RequestMapping("/guests")
		public Iterable<Guest> getGuests() {
			return this.guestRepository.findAll();
		}
	}

}
