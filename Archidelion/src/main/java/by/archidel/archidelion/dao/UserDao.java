package by.archidel.archidelion.dao;

import by.archidel.archidelion.bean.Account;
import by.archidel.archidelion.bean.AccountRegister;
import by.archidel.archidelion.bean.User;
import by.archidel.archidelion.dao.exception.DaoException;

public interface UserDao {
	User getUserByAccount(Account account) throws DaoException;

	User register(AccountRegister register) throws DaoException;
}
