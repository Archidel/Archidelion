package by.archidel.archidelion.controller;

import static by.archidel.archidelion.controller.util.MessageUtil.getMessageFromExceptionMessage;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;
import by.archidel.archidelion.bean.Account;
import by.archidel.archidelion.bean.AccountRegister;
import by.archidel.archidelion.bean.Person;
import by.archidel.archidelion.bean.User;
import by.archidel.archidelion.service.PersonService;
import by.archidel.archidelion.service.UserService;
import by.archidel.archidelion.service.exception.ServiceException;
import by.archidel.archidelion.service.exception.ValidationServiceException;;

@RestController
@RequestMapping(value = "/game")
public class GameController {
	private static final Logger logger = LoggerFactory.getLogger(GameController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public @ResponseBody User login(@RequestBody Account account) {
		User user = null;

		try {
			user = userService.getUserByAccount(account);
			logger.info(user.toString() + " has been verificated");
		} catch (ValidationServiceException e) {
			user = new User(true, getMessageFromExceptionMessage(e.getMessage()));
			logger.error(account.toString(), e);
		} catch (ServiceException e) {
			user = new User(true, getMessageFromExceptionMessage(e.getMessage()));
			logger.error(account.toString(), e);
		}

		System.out.println(user.toString());

		ArrayList<Person> list = new ArrayList<Person>();
		list.add(new Person(1, "MyCharacter", "Human", "Male"));
		list.add(new Person(2, "SecondCharacter", "Human", "Male"));
		list.add(new Person(3, "thridCHaracter", "Human", "Female"));
		list.add(new Person(4, "fouthCharacter", "Human", "Female"));
		user.setPerson(list);;
		System.out.println(user.toString());
		
		return user;
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public @ResponseBody User register(@RequestBody AccountRegister register) {
		User user = null;

		try {
			user = userService.register(register);

			logger.info(user.toString() + " has been registrated and verificated");
		} catch (ValidationServiceException e) {
			user = new User(true, getMessageFromExceptionMessage(e.getMessage()));
			logger.error(register.toString(), e);
		} catch (ServiceException e) {
			user = new User(true, getMessageFromExceptionMessage(e.getMessage()));
			logger.error(register.toString(), e);
		}

		System.out.println(user.toString());

		return user;
	}

	@RequestMapping(value = "/person/register", method = RequestMethod.POST)
	public @ResponseBody String createPerson(@RequestBody Person person) {
		User user = null;

		// try {

		// TODO to create implementation for character creation it's mean = person obj
		// and user id; how to get from json object
		/*
		 * user = personService.addPerson(person, person);
		 * 
		 * logger.info(user.toString() + " has been created"); } catch
		 * (ValidationServiceException e) { user = new User(true,
		 * getMessageFromExceptionMessage(e.getMessage()));
		 * logger.error(register.toString(), e); } catch (ServiceException e) { user =
		 * new User(true, getMessageFromExceptionMessage(e.getMessage()));
		 * logger.error(register.toString(), e); }
		 */

		return null;
	}

}
