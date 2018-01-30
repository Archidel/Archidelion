package by.archidel.archidelion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.archidel.archidelion.bean.Account;
import by.archidel.archidelion.bean.User;
import by.archidel.archidelion.service.UserService;
import by.archidel.archidelion.service.exception.ServiceException;
import by.archidel.archidelion.service.exception.ValidationServiceException;

@RestController
@RequestMapping(value = "/game")
public class GameController {
	private static final Logger logger = LoggerFactory.getLogger(GameController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public @ResponseBody User login(@RequestBody Account account) {
		User user = null;

		System.out.println(account.toString());
		
/*		try {
//			user = userService.getUserByAccount(account);
			logger.info(user.toString() + " has been verificated");
		} catch (ValidationServiceException e) {
//			user = new User(true, e.getMessage());
			logger.error(account.toString(), e);
		} catch (ServiceException e) {
//			user = new User(true, e.getMessage());
			logger.error(account.toString(), e);
		}*/

		return user;
	}

}