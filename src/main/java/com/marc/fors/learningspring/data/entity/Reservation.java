package com.marc.fors.learningspring.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
	@Id
	@Column(name = "reservation_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long reservationId;

	@Column(name = "room_id")
	private long roomId;

	@Column(name = "guest_id")
	private long guestId;

	@Column(name = "res_date")
	private String resDate;

	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public long getGuestId() {
		return guestId;
	}

	public void setGuestId(long guestId) {
		this.guestId = guestId;
	}

	public String getResDate() {
		return resDate;
	}

	public void setResDate(String resDate) {
		this.resDate = resDate;
	}

}