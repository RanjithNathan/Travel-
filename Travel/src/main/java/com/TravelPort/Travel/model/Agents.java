package com.TravelPort.Travel.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="agents")
public class Agents 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer agentId;
	
	@Column(name="agent_name")
	private String agentName;
	
	@Column(name="agent_password")
	private String agentPassword;
	
	@Column(name="mobile")
	private Long mobile;
	
	@OneToMany(targetEntity=TicketBooking.class)  
	//@OneToMany(mappedBy="agent")
	private List<TicketBooking> Tickets;

	public List<TicketBooking> getTickets()
	{
		return Tickets;
	}

	public void setTickets(List<TicketBooking> tickets) {
		Tickets = tickets;
	}

	@Override
	public String toString() {
//		return "Agents [agentId=" + agentId + ", agentName=" + agentName + ", agentPassword=" + agentPassword
//				+ ", mobile=" + mobile + "]";
		return String.format("Agents [agentId=%s, agentName=%s, agentPassword=%s]", agentId,agentName,agentPassword);
	}

	public Agents() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agents(Integer agentId, String agentName, String agentPassword, Long mobile) {
		super();
		this.agentId = agentId;
		this.agentName = agentName;
		this.agentPassword = agentPassword;
		this.mobile = mobile;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public String getAgentPassword() {
		return agentPassword;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public void setAgentPassword(String agentPassword) {
		this.agentPassword = agentPassword;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	
	}
