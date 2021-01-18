package com.qa.TicketBackend.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.TicketBackend.persistence.domain.Trainee;

public interface TraineeRepo extends JpaRepository<Trainee,Long> {

	List<Trainee> findTraineeByTraineeId(Long trainee);

}
