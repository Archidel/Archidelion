package by.archidel.archidelion.dao;

import by.archidel.archidelion.bean.Account;
import by.archidel.archidelion.bean.User;

public interface UserDao {
	User getUserByAccount(Account account);
}
