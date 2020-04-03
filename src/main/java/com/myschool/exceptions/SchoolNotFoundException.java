package com.myschool.exceptions;

public class SchoolNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SchoolNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
}
