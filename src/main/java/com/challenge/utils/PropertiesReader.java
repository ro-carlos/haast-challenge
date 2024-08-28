package com.challenge.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Properties class instance to read project properties from file
 *
 * @author Carlos Rodríguez
 */
public class PropertiesReader {

	private static PropertiesReader instance = null;
	private final Properties properties;
	private final Logger logger = LogManager.getLogger();

	private PropertiesReader() {
		properties = new Properties();
		try {
			String propertiesFilePath = "config.properties";
			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propertiesFilePath);
			properties.load(inputStream);
		} catch (IOException e) {
			logger.error("Could not read file properties");
		}
	}

	public static synchronized PropertiesReader getInstance() {
		if (instance == null) {
			instance = new PropertiesReader();
		}
		return instance;
	}

	public String getProperty(String key) {
		return this.properties.getProperty(key, String.format("The key %s does not exists!", key));
	}

}
