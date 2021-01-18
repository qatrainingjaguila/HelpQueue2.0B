package com.qa.TicketBackend.dto;

import java.util.List;

import com.qa.TicketBackend.persistence.domain.Ticket;

public class TraineeDTO {
	private Long traineeId;
	private String forename;
	private String surname;
	private String username;
	private String password;
	private List<Ticket> tickets;
	
	public TraineeDTO() {
		
	}

	public TraineeDTO(Long traineeId, String forename, String surname, String username, String password) {
		super();
		this.traineeId = traineeId;
		this.forename = forename;
		this.surname = surname;
		this.username = username;
		this.password = password;
	}

	public Long getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Long traineeId) {
		this.traineeId = traineeId;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	
}
