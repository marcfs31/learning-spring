package com.marc.fors.learningspring.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.marc.fors.learningspring.data.entity.Guest;

public interface GuestRepository extends CrudRepository<Guest, Long> {}
