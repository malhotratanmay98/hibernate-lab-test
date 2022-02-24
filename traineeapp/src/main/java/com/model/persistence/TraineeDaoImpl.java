package com.model.persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.exceptions.DataAccessException;
import com.model.factory.HibernateSessionFactory;

public class TraineeDaoImpl implements TraineeDao {

	
	private SessionFactory factory;
	
	 public TraineeDaoImpl() {
		factory=HibernateSessionFactory.getSessionFactory();
	}
	
	@Override
	public Trainee addTrainee(Trainee trainee) {
		
		Session session = factory.openSession();

		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(trainee);

			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new DataAccessException(ex);
		}
		session.close();
		return trainee;
		
	}

	@Override
	public List<Trainee> getAll() throws DataAccessException {
		
		Session session = factory.getCurrentSession();
		Transaction tx = session.getTransaction();
		List<Trainee> trainee = null;
		try {
			tx.begin();
			trainee = session.createQuery("select t from Trainee t",Trainee.class).getResultList();
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();
		return trainee;
	}

	
	
}
