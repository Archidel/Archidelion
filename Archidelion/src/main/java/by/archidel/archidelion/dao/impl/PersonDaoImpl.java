package by.archidel.archidelion.dao.impl;

import org.springframework.stereotype.Repository;

import by.archidel.archidelion.bean.Person;
import by.archidel.archidelion.dao.PersonDao;
import by.archidel.archidelion.dao.exception.DaoException;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

	@Override
	public void addPerson(Person person, int userId) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkUniquePersonName(String name) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

}
