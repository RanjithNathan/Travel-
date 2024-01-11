package com.TravelPort.Travel.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.TravelPort.Travel.model.Agents;


@Repository
public interface AgentRepository  extends JpaRepository<Agents,Integer>
{

	 boolean existsByMobile(Long mobile);
	 
	  List<Agents> findByAgentName(String agentName);

	// boolean existsByTicketsCount(Integer ticketsCount);
	


}
