package by.archidel.archidelion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.archidel.archidelion.bean.Person;
import by.archidel.archidelion.dao.PersonDao;
import by.archidel.archidelion.dao.exception.DaoException;
import by.archidel.archidelion.service.PersonService;
import by.archidel.archidelion.service.exception.ServiceException;
import by.archidel.archidelion.service.exception.ValidationServiceException;
import by.archidel.archidelion.service.validation.PersonValidationData;
import by.archidel.archidelion.service.validation.ValidationData;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;

	@Override
	public void addPerson(Person person, int userId) throws ServiceException, ValidationServiceException {
		if (!PersonValidationData.validPerson(person)) {
			throw new ValidationServiceException("Invalidation person data");
		}

		if (!ValidationData.validInteger(userId)) {
			throw new ValidationServiceException("Incorrent user id");
		}

		try {
			boolean isExist = personDao.checkUniquePersonName(person.getName());
			if (isExist) {
				throw new ServiceException("This name yet exist");
			}
			personDao.addPerson(person, userId);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
