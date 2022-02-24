package com.model.service;

import java.util.List;

import com.model.exceptions.DataAccessException;
import com.model.persistence.Trainee;



public interface TraineeService {

	public Trainee addTrainee(Trainee trainee);
	
	public List<Trainee> getAll() throws DataAccessException;
	
}
