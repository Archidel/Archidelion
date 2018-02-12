package by.archidel.archidelion.service;

import by.archidel.archidelion.bean.Person;
import by.archidel.archidelion.service.exception.ServiceException;
import by.archidel.archidelion.service.exception.ValidationServiceException;

public interface PersonService {
	void addPerson(Person person, int userId) throws ServiceException, ValidationServiceException;
}
