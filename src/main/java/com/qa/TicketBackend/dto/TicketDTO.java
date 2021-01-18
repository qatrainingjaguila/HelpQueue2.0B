package com.qa.TicketBackend.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class TicketDTO {
	
	private Long id;
	private String title;
	private String author;   	    
	private String description; 
	private String urgency;
	private boolean status;
	private String solution;
	private String email;
	private String topic;
	private Long trainee;
	private LocalDateTime timeCreated;
	
	public TicketDTO() {
		
	}

	public TicketDTO(Long id, String title, String author, String description, String urgency, boolean status,
			String solution, String email, String topic, Long trainee, LocalDateTime timeCreated) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.description = description;
		this.urgency = urgency;
		this.status = status;
		this.solution = solution;
		this.email = email;
		this.topic = topic;
		this.trainee = trainee;
		this.timeCreated = timeCreated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Long getTrainee() {
		return trainee;
	}

	public void setTrainee(Long trainee) {
		this.trainee = trainee;
	}

	public LocalDateTime getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(LocalDateTime timeCreated) {
		this.timeCreated = timeCreated;
	}
	
	

}
