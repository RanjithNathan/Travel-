package com.TravelPort.Travel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ticket_Booking")
public class TicketBooking 
{	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	private Long ticketId;

    @Column(name="ticket_price")
	private Double ticketPrice;
    
    @Column(name="total_tickets")
    private final Integer totalTickets=6;
    
    @Column (name="tickets_count")
    private Integer ticketsCount=0;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "agent_id")
	private Agents agent;
	//@Column(name="seat_no")
	//private Integer seatNo;
//	private  Map<Integer, Integer> seatNo = new HashMap<>();
	

	
	
	public Long getTicketId() {
		return ticketId;
	}
	public Double getTicketPrice() {
		return ticketPrice;
	}
	public Agents getAgent() {
		return agent;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public void setAgent(Agents agent) {
		this.agent = agent;
	}
	@Override
	public String toString() {
		//return "TicketBooking [ticketId=" + ticketId + ", ticketPrice=" + ticketPrice + ", agent=" + agent + "]";
		return String.format("TicketBooking [ticketId=%s, ticketPrice=%s]", ticketId, ticketPrice);
	}
	public Integer getTotalTickets() {
		return totalTickets;
	}
	public Integer getTicketsCount() {
		return ticketsCount;
	}
	public void setTicketsCount(Integer ticketsCount) {
		this.ticketsCount = ticketsCount;
	}
//	public Map<Integer, Integer> getSeatNo() {
//		return seatNo;
//	}
//	public void setSeatNo(Map<Integer, Integer> seatNo) {
//		this.seatNo = seatNo;
//	}
//	public Integer getSeatNo() {
//		return seatNo;
//	}
//	public void setSeatNo(Integer seatNo) {
//		this.seatNo = seatNo;
//	}
	
	

	
	

}
