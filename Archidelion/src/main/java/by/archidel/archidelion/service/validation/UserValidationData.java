package by.archidel.archidelion.service.validation;

import by.archidel.archidelion.bean.Account;

public final class UserValidationData {
	private UserValidationData() {
	}
	
	public static boolean validAccount(Account account) {
		return true;
	}
	
	public static boolean validUser(Account account) {
		return true;
	}
	
	
}
