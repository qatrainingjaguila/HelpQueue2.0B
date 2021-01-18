package com.qa.TicketBackend.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.TicketBackend.dto.TraineeDTO;
import com.qa.TicketBackend.service.TicketService;

@CrossOrigin
@RestController
public class TraineeController {
	
	private TicketService service;
	
	public TraineeController(TicketService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/trainee/createTrainee")
	public ResponseEntity<TraineeDTO> createTrainee(@RequestBody TraineeDTO trainee) {
		return new ResponseEntity<TraineeDTO>(this.service.createTrainee(trainee), HttpStatus.CREATED);
	}

}
