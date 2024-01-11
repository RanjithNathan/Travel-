package com.TravelPort.Travel.service;

import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelPort.Travel.exceptions.AgentAlreadyExitsException;
import com.TravelPort.Travel.exceptions.IdNotValidException;
import com.TravelPort.Travel.exceptions.TicketNotAvailableException;
import com.TravelPort.Travel.exceptions.UserNotFoundException;
import com.TravelPort.Travel.model.Agents;
import com.TravelPort.Travel.model.TicketBooking;
import com.TravelPort.Travel.repository.AgentRepository;
import com.TravelPort.Travel.repository.TicketBookingRepository;

@Service
public class AgentService 
{
	Integer ticketcount=1;
	@Autowired
	private AgentRepository repo;
	
	@Autowired
	private TicketBookingRepository ticketRepo;
	
	
	public Agents saveNew(Agents agent)
	{
		if(agentExistByMobile(agent.getMobile()))
		{
			throw new AgentAlreadyExitsException("This Mobile Number Already Exist..please login or Try Another for signup");
		}
		else
		
		return repo.save(agent);
	}
	
	public List<Agents> getAgents()
	{
		Agents agent=new Agents();
		if(agent!=null)
		{
		return repo.findAll();
		}
		else 
			throw new UserNotFoundException(" agent does not exist...please signup");
		
	}
	

	public Agents getAgentById(Integer id)
	{
		Optional<Agents> optional=repo.findById(id);
		if(optional.isPresent())
		{
		return optional.get();
		}else
			throw new UserNotFoundException("this agent does not exist...please signup");
		
	}

	public void deleteAgent(int id) 
	{
		Optional<Agents> optional=repo.findById(id);
		
		if(optional.isPresent())
		{
			Agents agent=getAgentById(id);
			repo.delete(agent);
		}
		else
			throw new IdNotValidException("You Have Entered Invalid Id..please Enter Valid Id");
		
		
		
	}
	
	public List<Agents> getByName(String agentName)
	{
		List<Agents>agentList= repo.findByAgentName(agentName);
		if(!agentList.isEmpty())
		{ 
			return agentList;
		}
		else
			throw new UserNotFoundException("user not found");
		
	}
	
	public Agents updateAgent(Agents agent,Integer id)
	{
		Optional<Agents> existOptional=repo.findById(id);
		
		if(existOptional.isPresent())
		{
			return saveNew(agent);
		}
		else
			 throw new IdNotValidException("You Have Entered Invalid Id..please Enter Valid Id");
				
	}
	
//	public Agents updateExistAgent(Agents agent ,Integer id)
//	{
//		Optional<Agents> existOptional=repo.findById(id);
//		
//	
//	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	//Ticket Boooking
	
	
	public TicketBooking generateTicket(Integer id,TicketBooking ticket)
	{
		
		Optional<Agents> agentOpt=repo.findById(id);
		//TicketBooking bookTicket=new TicketBooking();
		
		if(!agentOpt.isPresent())
		{
			throw new IdNotValidException("You Have Entered Invalid Id..please Enter Valid Id");
		}
		else
		{
			if(ticketcount<=ticket.getTotalTickets())
			{
				Agents agent=agentOpt.get();
				ticket.setAgent(agent);	
				ticket.setTicketsCount(ticketcount++);
				return ticketRepo.save(ticket);
				
			}
			else
			{
				throw new TicketNotAvailableException("Tickets SoldOut..please try Tomorrow");
			}
				
		}
	}
	
	
	public List<TicketBooking> viewTickets(Integer id)
	{
		Optional<Agents> agentOpt=repo.findById(id);
		if(!agentOpt.isPresent())
		{
			throw new IdNotValidException("You Have Entered Invalid Id..please Enter Valid Id");
		}
		else
		{
			return ticketRepo.findAll();
		}
	}
	
	
	
	
//	public TicketBooking SeatReserve(Integer id,TicketBooking ticketreserv)
//	{
////		List<TicketBooking> ticket=new ArrayList<>();
//		
//		if(seatsExistByTicketsCount(ticketreserv.getTicketsCount()))
//		{
//			throw new AgentAlreadyExitsException("This seat not available");
//		}
//		else
//		
//		return generateTicket(id,ticketreserv);
//	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public boolean agentExistByMobile(Long mobile)
	{
		return repo.existsByMobile(mobile);
	
	}
//	public boolean seatsExistByTicketsCount( Integer ticketsCount)
//	{
//		return repo.existsByTicketsCount(ticketsCount);
//		
//	}


	
	
}
