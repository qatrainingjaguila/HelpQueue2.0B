package com.qa.TicketBackend.service;

import java.util.List;



import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import com.qa.TicketBackend.dto.TicketDTO;
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
	

	public TicketService(TicketRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	 private TicketDTO mapToDTO(Ticket ticket) {
	        return this.mapper.map(ticket, TicketDTO.class);
	    }

	public TicketDTO createTicket(Ticket ticket) {
		Ticket toSave = ticket;
		
		List<Trainee> trainees = this.traineeRepo.findTraineeByTraineeId(toSave.getTrainee());
		Trainee currentTrainee = trainees.get(0);
		toSave.setTrainee(currentTrainee);
		Ticket saved = this.repo.save(toSave);
		
		return this.mapToDTO(this.repo.save(saved));
	}

	public List<Ticket> getTicket() {
		return this.repo.findAll();
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

}