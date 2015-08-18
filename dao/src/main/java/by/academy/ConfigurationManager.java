/**
 * 
 */
package by.academy;

import java.util.ResourceBundle;

/**
 * @author Veronika
 *
 */
public enum ConfigurationManager {
	INSTANCE;
	
	public static final String ERROR_PAGE_PATH = "ERROR_PAGE_PATH";
	public static final String LOGIN_PAGE_PATH = "LOGIN_PAGE_PATH";
	public static final String MAIN_PAGE_PATH = "MAIN_PAGE_PATH";
	public static final String POOL_CAPACITY = "POOL_CAPACITY";
	public static final String DB_USER = "DB_USER";
	public static final String DB_PASSWORD = "DB_PASSWORD";
	public static final String DB_URL = "DB_URL";
	public static final String GOODS_PAGE_PATH = "GOODS_PAGE_PATH";
	public static final String CATALOG_PAGE_PATH = "CATALOG_PAGE_PATH";
	public static final String ABOUT_PAGE_PATH = "ABOUT_PAGE_PATH";
	public static final String CURRENT_CARMARKET_ID = "CURRENT_CARMARKET_ID";
	public static final String ABOUT_CHAIN_PAGE_PATH = "ABOUT_CHAIN_PAGE_PATH";
	public static final String SHOW_USERS_PAGE_PATH = "SHOW_USERS_PAGE_PATH";
	
	private static final String BUNDLE_NAME = "resources.config";
	private ResourceBundle resourceBundle;

	private ConfigurationManager() {
		this.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
	}
	
	/**
	 * Retrieves value from properties file according to the input key  
	 * @param key defines value in the properties file  
	 * @return value from the properties file
	 */
	public String getProperty(String key) {
		return this.resourceBundle.getString(key);
	}

}
