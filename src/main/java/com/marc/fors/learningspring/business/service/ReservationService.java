package com.marc.fors.learningspring.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marc.fors.learningspring.business.domain.RoomReservation;
import com.marc.fors.learningspring.data.entity.Guest;
import com.marc.fors.learningspring.data.entity.Reservation;
import com.marc.fors.learningspring.data.entity.Room;
import com.marc.fors.learningspring.data.repository.GuestRepository;
import com.marc.fors.learningspring.data.repository.ReservationRepository;
import com.marc.fors.learningspring.data.repository.RoomRepository;

@Service
public class ReservationService {
	private final RoomRepository roomRepository;
	private final GuestRepository guestRepository;
	private final ReservationRepository reservationRepository;
	
	@Autowired
	public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository,
			ReservationRepository reservationRepository) {
		super();
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
		this.reservationRepository = reservationRepository;
	}

	public List<RoomReservation> getRoomReservationsForDate(Date date) {
		Iterable<Room> rooms = this.roomRepository.findAll();
		Map<Long, RoomReservation> roomReservationMap = new HashMap<Long, RoomReservation>();
		
		rooms.forEach(room -> {
			RoomReservation roomReservation = new RoomReservation();
			roomReservation.setRoomId(room.getRoomId());
			roomReservation.setRoomName(room.getRoomName());
			roomReservation.setRoomNumber(room.getRoomNumber());
			roomReservationMap.put(room.getRoomId(), roomReservation);
		});
		
		Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
		
		reservations.forEach(reservation -> {
			RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
			roomReservation.setDate(date);
			Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
			roomReservation.setFirstName(guest.getFirstName());
			roomReservation.setLastName(guest.getLastName());
			roomReservation.setGuestId(guest.getGuestId());
		});
		
		List<RoomReservation> roomReservations = new ArrayList<RoomReservation>();
		
		for (Long id : roomReservationMap.keySet()) {
			roomReservations.add(roomReservationMap.get(id));
		}
		return roomReservations;
	}
}