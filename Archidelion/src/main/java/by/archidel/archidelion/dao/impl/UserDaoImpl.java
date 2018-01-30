package by.archidel.archidelion.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.archidel.archidelion.bean.Account;
import by.archidel.archidelion.bean.User;
import by.archidel.archidelion.dao.UserDao;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getUserByAccount(Account account) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		User user = null;
		
		try {
			transaction = session.beginTransaction();
//			user = (User) session.createQuery("FROM User u WHERE u.login = :login AND u.password = :password")
//					.setParameter("login", account.getLogin()).setParameter("password", account.getPassword())
//					.getSingleResult();

		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}

		return user;
	}

}
