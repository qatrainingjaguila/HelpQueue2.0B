package com.qa.TicketBackend.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Trainee {

	    @Id
	    @GeneratedValue
	    private Long traineeId;

	    @Column(name = "forename")
	    private String forename;

	    @Column(name = "surname")
	    private String surname;
	    
	    @Column(name = "username")
	    @NotNull
	    private String username;
	    

		@Column(name = "password")
	    @NotNull
	    private String password;

	    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trainee")
		@OnDelete(action = OnDeleteAction.CASCADE)
		private List<Ticket> tickets = new ArrayList<Ticket>();
	    
	    public Trainee(Long traineeId, String forename, String surname, @NotNull String username,
				@NotNull String password, List<Ticket> tickets) {
			super();
			this.traineeId = traineeId;
			this.forename = forename;
			this.surname = surname;
			this.username = username;
			this.password = password;
			this.tickets = tickets;
		}
	    
	    public Trainee() {
	    	super();
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
