package by.archidel.archidelion.controller.util;

public final class MessageUtil {
	private MessageUtil() {
	}
	
	public static String getMessageFromExceptionMessage(String line) {
		return line.split(":")[1].trim();
	}
}
