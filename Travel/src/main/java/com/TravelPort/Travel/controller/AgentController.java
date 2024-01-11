package com.TravelPort.Travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TravelPort.Travel.exceptions.AgentAlreadyExitsException;
import com.TravelPort.Travel.exceptions.IdNotValidException;
import com.TravelPort.Travel.exceptions.TicketNotAvailableException;
import com.TravelPort.Travel.exceptions.UserNotFoundException;
import com.TravelPort.Travel.model.Agents;
import com.TravelPort.Travel.model.TicketBooking;
import com.TravelPort.Travel.service.AgentService;


@RestController @RequestMapping("/Agents")
public class AgentController 
{
	
	@Autowired
	private AgentService serv;
	
	@PostMapping("/Signup")
	public ResponseEntity<Object> newAgent(@RequestBody Agents agent)
	{	
		try
		{
			Agents newagent=serv.saveNew(agent);
			return new ResponseEntity<>(newagent,HttpStatus.CREATED);
		}
		catch(AgentAlreadyExitsException e)
		{
			return new  ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
		}
		
	}
	@GetMapping("/getAgents")
	public ResponseEntity<Object>getAgents()
	{
		try
		{
		List<Agents> agent=serv.getAgents();
		
		ResponseEntity<Object> status=new ResponseEntity<Object>(agent,HttpStatus.OK);
		return status;
		
			
		}
		catch(UserNotFoundException e)
		{
			ResponseEntity<Object> status=new ResponseEntity<Object>(e.getMessage(),HttpStatus.NOT_FOUND);
		return status;
		}
		
	}
	@GetMapping("/getAgent/{id}")
	public ResponseEntity<Object> getAgents(@PathVariable Integer id)
	{
		try
		{
		Agents agent=serv.getAgentById(id);
		
		return new ResponseEntity<>(agent,HttpStatus.OK);
		}
		catch(UserNotFoundException e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAgent/byAgentName/{Name}")
	public ResponseEntity<List<Agents>> getByName(@PathVariable(name="Name") String agentName)
	{
	
		List<Agents> agentList=serv.getByName(agentName);
		return new ResponseEntity<>(agentList,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteAgents/{id}")
	public ResponseEntity<String> deleteAgents(@PathVariable Integer id)
	{

			try
			{
				serv.deleteAgent(id);
				return  new ResponseEntity<>("your id "+id+"deleted successfully",HttpStatus.OK);
			}
			catch(IdNotValidException e)
			{
				return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
		
	}
	
	@PutMapping("/UpdateAgent/{id}")
	public ResponseEntity<Object> updateAgent(@RequestBody Agents agent,@PathVariable Integer id)
	
	{
		try {
		Agents agents=serv.updateAgent(agent,id);
		return new ResponseEntity<>(agents,HttpStatus.ACCEPTED);
		}
		catch(UserNotFoundException e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		catch(IdNotValidException e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		
		
	}
	
	
	
	
//	@PatchMapping("/UpdateAgent/{id}")
//	public ResponseEntity<Agents> updateExistAgent(@RequestBody Agents agent,@PathVariable Integer id)
//	{
//		Agents agnt=serv.updateExistAgent(agent, id);
//		
//		return new ResponseEntity<>(agnt,HttpStatus.ACCEPTED);
//	}

	
	
	
	//Ticket Booking
	@PostMapping("/ticketBooking/{id}")
	public ResponseEntity<Object> generateTicket(@PathVariable(name="id") Integer id, @RequestBody TicketBooking ticket)
	{
		try
		{
			TicketBooking tickets =serv.generateTicket(id, ticket);
			return new ResponseEntity<>(tickets,HttpStatus.ACCEPTED);
			
		}
		catch(UserNotFoundException e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		catch(IdNotValidException e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		catch(TicketNotAvailableException e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
		}
		
		}
	
	@GetMapping("/ticketBooking/view/{id}")
	public ResponseEntity<Object> viewTickets(@PathVariable Integer id)
	{
		try
		{
			List<TicketBooking> tickets=serv.viewTickets(id);
			return new  ResponseEntity<>("Successfully Ticket created\n"+tickets,HttpStatus.OK);
		}
		catch(UserNotFoundException e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		catch(IdNotValidException e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	
//	@PostMapping("/ticketBooking/reserv")
//	public ResponseEntity<Object> reserveTicket( @PathVariable(name="id") Integer id,@RequestBody TicketBooking ticket)
//	{
//		try
//		{
//			TicketBooking tickets =serv.SeatReserve(id,ticket);
//			return new ResponseEntity<>(tickets,HttpStatus.ACCEPTED);
//			
//		}
//		catch(UserNotFoundException e)
//		{
//			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
//		}
//		catch(IdNotValidException e)
//		{
//			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
//		}
//		catch(TicketNotAvailableException e)
//		{
//			return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
//		}
//		
//		}
	

	

}
