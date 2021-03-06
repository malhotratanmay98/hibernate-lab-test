package com.model.persistence;

import java.util.List;

import com.model.exceptions.DataAccessException;

// Two operations --> add new employee and show all employees

public interface TraineeDao {

	public Trainee addTrainee(Trainee trainee);
	
	public List<Trainee> getAll() throws DataAccessException;
	
}
