package com.challenge.utils;

/**
 * Enum that represents different browsers for framework
 *
 * @author Carlos Rodríguez
 */
public enum Browser {
	FIREFOX("Firefox"), CHROME("Chrome");

	private String name;

	private Browser(String browser) {
		this.name = browser;
	}

	public String getName() {
		return this.name;
	}
}
