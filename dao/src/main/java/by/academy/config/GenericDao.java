package by.academy.config;

import java.io.Serializable;

import by.academy.exceptions.DaoException;

public interface GenericDao<T extends Identified<PK>, PK extends Serializable> {
	
	public T create() throws DaoException;
	
	public T add(T object) throws DaoException;
	
	public void delete(T object) throws DaoException;
	
	public void update(T object) throws DaoException;
	
	public T getById(Integer id) throws DaoException;	
	
}
