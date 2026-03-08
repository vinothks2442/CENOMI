package com.automation.web.common_utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;



public class ConfigReader {

	
	

	
	private Properties properties;
	// private final Properties properties;
	private static ConfigReader configReader;

	private String getPropertyValue(String propertyKey) {
		String prop = properties.getProperty(propertyKey);
		if (prop != null) {
			return prop.trim();
		} else {
			throw new RuntimeException("Property " + propertyKey + " is not specified in the config.properties file");
		}
	}

	public static ConfigReader getInstance() {
		if (configReader == null) {
			configReader = new ConfigReader();
		}
		return configReader;
	}

	

	/*
	 * loadPropertyFile method used for loading the properties file
	 * 
	 * @Param filePath
	 */
	public static Properties loadPropertyFile(String filePath) {
		// Read from properties file
		File file = new File(filePath);
		Properties prop = new Properties();

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
			prop.load(fileInput);
		} catch (Exception e) {
			// LogUtil.errorLog(ConfigReader.class, "Caught the exception", e);

		}
		return prop;

	}

	/**
	 * will get sting value from properties file
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {

		Properties prop = loadPropertyFile("src/test/resources/Configs/config.properties");

		return prop.getProperty(key);
	}

	/**
	 * will get int value from properties file
	 * 
	 * @param key
	 * @return
	 */
	public static int getIntValue(String key) {
		Properties prop = loadPropertyFile("src/test/resources/Configs/config.properties");

		String strKey = prop.getProperty(key);

		return Integer.parseInt(strKey);
	}

	/**
	 * will get sting value from properties file
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue2(String path, String key) {

		Properties prop = loadPropertyFile(path);

		return prop.getProperty(key);
	}
	
	/**
	 * will set sting value from properties file
	 * 
	 * @param key
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws IOException
	 */
	public static void setStringValue(String path, String key, String value) throws IOException {

		FileOutputStream output = new FileOutputStream(path);

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty(key, value);

            // save properties to project root folder
            prop.store(output, null);
            output.close();
		
	}
	


}
