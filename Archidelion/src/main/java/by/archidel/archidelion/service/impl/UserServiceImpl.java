package by.archidel.archidelion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.archidel.archidelion.bean.Account;
import by.archidel.archidelion.bean.AccountRegister;
import by.archidel.archidelion.bean.User;
import by.archidel.archidelion.dao.UserDao;
import by.archidel.archidelion.dao.exception.DaoException;
import by.archidel.archidelion.service.UserService;
import by.archidel.archidelion.service.exception.ServiceException;
import by.archidel.archidelion.service.exception.ValidationServiceException;
import by.archidel.archidelion.service.validation.UserValidationData;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User getUserByAccount(Account account) throws ServiceException, ValidationServiceException {
		if (!UserValidationData.validAccount(account)) {
			throw new ServiceException("Invalid input data");
		}
		User user = null;

		try {
			user = userDao.getUserByAccount(account);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

		return user;
	}

	@Override
	public User register(AccountRegister register) throws ServiceException, ValidationServiceException {
		if (!UserValidationData.validAccount(register)) {
			throw new ServiceException("Invalid register data");
		}
		User user = new User();
		user.setLogin(register.getLogin());
		user.setEmail(register.getEmail());
		user.setPassword(register.getPassword());

		try {
			user = userDao.register(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

		return user;

	}

}
