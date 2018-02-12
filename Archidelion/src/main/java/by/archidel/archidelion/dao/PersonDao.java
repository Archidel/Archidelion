package by.archidel.archidelion.dao;

import by.archidel.archidelion.bean.Person;
import by.archidel.archidelion.dao.exception.DaoException;

public interface PersonDao {
	void addPerson(Person person, int userId) throws DaoException;

	boolean checkUniquePersonName(String name) throws DaoException;
}
