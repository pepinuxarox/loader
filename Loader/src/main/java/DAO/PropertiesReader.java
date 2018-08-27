package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

	private static final String FOLDER_PATH_PROP = "/properties/";
	private String hostDwh;
	private String userDwh;
	private String passDwh;
	private String filePath;
	
	public PropertiesReader(){
		getDataHost();
		getDataUser();
		getDataPass();
	}

	public void getDataHost() {
		try {
			Properties prop_db = new Properties();
			String pathProp = new File("").getAbsolutePath().concat(FOLDER_PATH_PROP.concat("db.properties"));
			FileInputStream file = new FileInputStream(pathProp);
			prop_db.load(file);
			file.close();
			this.setHostDwh("jdbc:jtds:sqlserver://" + prop_db.getProperty("SQL_IP") + ":"
					+ prop_db.getProperty("SQL_PORT") + "/" + prop_db.getProperty("SQL_DB_DWH"));		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getDataUser() {
		try {
			Properties prop_db = new Properties();
			String pathProp = new File("").getAbsolutePath().concat(FOLDER_PATH_PROP.concat("db.properties"));
			FileInputStream file = new FileInputStream(pathProp);
			prop_db.load(file);
			file.close();
            this.setUserDwh(prop_db.getProperty("SQL_USER_DWH"));   
            
        }catch (Exception e){ System.out.println(e.getMessage());}
		
		return userDwh;
	}
	

	public String getDataPass() {
		try {
			Properties prop_db = new Properties();
			String pathProp = new File("").getAbsolutePath().concat(FOLDER_PATH_PROP.concat("db.properties"));
			FileInputStream file = new FileInputStream(pathProp);
			prop_db.load(file);
			file.close();
            this.setPassDwh(prop_db.getProperty("SQL_PASSWORD_DWH"));        
        }catch (Exception e){ System.out.println(e.getMessage());}
		
		return passDwh;
	}
	
	public String getFilePath() {
		try {
			Properties prop_db = new Properties();
			String pathProp = new File("").getAbsolutePath().concat(FOLDER_PATH_PROP.concat("db.properties"));
			FileInputStream file = new FileInputStream(pathProp);
			prop_db.load(file);
			file.close();
            this.setFilePath(prop_db.getProperty("FILE_PATH"));        
        }catch (Exception e){ System.out.println(e.getMessage());}
		
		return filePath;
	}

	/**
	 * @return the hostDwh
	 */
	public final String getHostDwh() {
		return hostDwh;
	}

	/**
	 * @param hostDwh the hostDwh to set
	 */
	public final void setHostDwh(String hostDwh) {
		this.hostDwh = hostDwh;
	}

	/**
	 * @return the userDwh
	 */
	public final String getUserDwh() {
		return userDwh;
	}

	/**
	 * @param userDwh the userDwh to set
	 */
	public final void setUserDwh(String userDwh) {
		this.userDwh = userDwh;
	}

	/**
	 * @return the passDwh
	 */
	public final String getPassDwh() {
		return passDwh;
	}

	/**
	 * @param passDwh the passDwh to set
	 */
	public final void setPassDwh(String passDwh) {
		this.passDwh = passDwh;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	
	
}
