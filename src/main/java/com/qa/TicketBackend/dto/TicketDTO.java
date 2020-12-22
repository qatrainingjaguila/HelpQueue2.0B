package com.qa.TicketBackend.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class TicketDTO {
	
	private Long id;
	private String forename;
	private String surname;   	    
	private String username; 
	private String password;
	private Long trainee;
	
	public TicketDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getTrainee() {
		return trainee;
	}

	public void setTrainee(Long trainee) {
		this.trainee = trainee;
	}

}
