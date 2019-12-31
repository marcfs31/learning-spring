package com.marc.fors.learningspring.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.marc.fors.learningspring.data.entity.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {}
