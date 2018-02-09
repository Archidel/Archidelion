package by.archidel.archidelion.service;

import by.archidel.archidelion.bean.Account;
import by.archidel.archidelion.bean.AccountRegister;
import by.archidel.archidelion.bean.User;
import by.archidel.archidelion.service.exception.ServiceException;
import by.archidel.archidelion.service.exception.ValidationServiceException;

public interface UserService {
	User getUserByAccount(Account account) throws ServiceException, ValidationServiceException;

	User register(AccountRegister register) throws ServiceException, ValidationServiceException;
}
