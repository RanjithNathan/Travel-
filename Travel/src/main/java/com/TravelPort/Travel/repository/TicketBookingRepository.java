package com.TravelPort.Travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TravelPort.Travel.model.TicketBooking;
@Repository
public interface TicketBookingRepository extends JpaRepository<TicketBooking,Integer>{


}
