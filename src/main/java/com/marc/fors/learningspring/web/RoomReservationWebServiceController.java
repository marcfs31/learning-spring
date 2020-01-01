package com.marc.fors.learningspring.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marc.fors.learningspring.business.domain.RoomReservation;
import com.marc.fors.learningspring.business.service.ReservationService;
import com.marc.fors.learningspring.utils.DateUtils;

@RestController
@RequestMapping("api/reservations")
public class RoomReservationWebServiceController {
	public final ReservationService reservationService;

	@Autowired
	public RoomReservationWebServiceController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}
	
	@GetMapping
	public List<RoomReservation> getRoomReservations(@RequestParam(name="date", required = false) String dateString) {
		Date date = DateUtils.createDateFromDateString(dateString);
		return this.reservationService.getRoomReservationsForDate(date);
	}
}
