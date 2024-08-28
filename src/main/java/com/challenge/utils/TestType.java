package com.challenge.utils;

/**
 * Enum that represents different testing types
 *
 * @author Carlos Rodríguez
 */
public enum TestType {
	API("Api"), WEB("Web");

	private String name;

	private TestType(String testType) {
		this.name = testType;
	}

	public String getName() {
		return this.name;
	}
}
