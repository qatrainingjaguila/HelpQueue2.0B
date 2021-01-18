package com.qa.TicketBackend.service;

import java.util.List;
import java.util.stream.Collectors;



import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import com.qa.TicketBackend.dto.TicketDTO;
import com.qa.TicketBackend.dto.TraineeDTO;
import com.qa.TicketBackend.persistence.domain.Ticket;
import com.qa.TicketBackend.persistence.domain.Trainee;
import com.qa.TicketBackend.persistence.repo.TicketRepo;
import com.qa.TicketBackend.persistence.repo.TraineeRepo;
import com.qa.TicketBackend.utils.MyBeanUtils;

@Service
public class TicketService {
	private TicketRepo repo;
	private TraineeRepo traineeRepo;
	private final ModelMapper mapper;
	

	public TicketService(TicketRepo repo, ModelMapper mapper, TraineeRepo traineeRepo) {
		super();
		this.repo = repo;
		this.mapper = mapper;
		this.traineeRepo = traineeRepo;
	}
	
	 private TicketDTO mapToDTO(Ticket ticket) {
	        return this.mapper.map(ticket, TicketDTO.class);
	    }
	 
	 private Ticket mapFromDTO(TicketDTO ticket) {
		 return this.mapper.map(ticket, Ticket.class);
	 }
	 
	 private TraineeDTO mapToDTO(Trainee trainee) {
	        return this.mapper.map(trainee, TraineeDTO.class);
	    }
	 
	 private Trainee mapFromDTO(TraineeDTO trainee) {
		 return this.mapper.map(trainee, Trainee.class);
	 }

	public TicketDTO createTicket(TicketDTO ticket) {
		Ticket toSave = this.mapFromDTO(ticket);
		Long traineeID = ticket.getTrainee();
		List<Trainee> trainees = this.traineeRepo.findTraineeByTraineeId(traineeID);
		Trainee currentTrainee = trainees.get(0);
		toSave.setTrainee(currentTrainee);
		Ticket saved = this.repo.save(toSave);
		
		return this.mapToDTO(saved);
	}

	public List<TicketDTO> getTicket() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public Ticket getSingleTicket(Long id) {
		return this.repo.findById(id).get();
	}

	public boolean deleteTicket(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public Ticket updateTicket(Ticket ticket, long id) {
		Ticket oldTicket = this.repo.findById(id).get();
		MyBeanUtils.mergeNotNull(ticket, oldTicket);
		return this.repo.save(oldTicket);
	}
	
	public TraineeDTO createTrainee(TraineeDTO trainee) {
		Trainee traineeToSave = this.mapFromDTO(trainee);
		Trainee saved = this.traineeRepo.save(traineeToSave);
		return this.mapToDTO(this.traineeRepo.save(saved));
	}

}