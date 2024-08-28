package com.challenge.pages.menu;

/**
 * Enum class containing navbar menu
 *
 * @author Carlos Rodríguez
 */
public enum NavbarMenu {
	MAIN_PAGE("Main page"),
	CONTENTS("Contents"),
	CURRENT_EVENTS("Current events"),
	ABOUT_WIKIPEDIA("About Wikipedia");

	private final String name;

	NavbarMenu(String action) {
		this.name = action;
	}

	public String getName() {
		return this.name;
	}
}
