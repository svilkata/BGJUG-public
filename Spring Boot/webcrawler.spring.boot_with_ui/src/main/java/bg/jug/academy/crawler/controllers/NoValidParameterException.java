package bg.jug.academy.crawler.controllers;

public class NoValidParameterException extends Exception {

	public NoValidParameterException(String paramName) {
		super(paramName);
	}
	
	
}
