package dao;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.Execute;

public class PropertiesReader {

	private static final String FOLDER_PATH_PROP = "/properties/";
	private String hostDwh;
	private String userDwh;
	private String passDwh;
	private String filePath;
	private static final String DBPROPERTIES= "db.properties";
	
	public PropertiesReader(){
		getDataHost();
		getDataUser();
		getDataPass();
	}

	public void getDataHost() {
		try {
			Properties propDb = new Properties();
			String pathProp = new File("").getAbsolutePath().concat(FOLDER_PATH_PROP.concat(DBPROPERTIES));
			FileInputStream file = new FileInputStream(pathProp);
			propDb.load(file);
			file.close();
			this.setHostDwh("jdbc:jtds:sqlserver://" + propDb.getProperty("SQL_IP") + ":"
					+ propDb.getProperty("SQL_PORT") + "/" + propDb.getProperty("SQL_DB_DWH"));		
		} catch (Exception e) {
			Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null, e);
		}
	}
	
	public String getDataUser() {
		try {
			Properties propDb = new Properties();
			String pathProp = new File("").getAbsolutePath().concat(FOLDER_PATH_PROP.concat(DBPROPERTIES));
			FileInputStream file = new FileInputStream(pathProp);
			propDb.load(file);
			file.close();
            this.setUserDwh(propDb.getProperty("SQL_USER_DWH"));   
            
        }catch (Exception e){ 
        	Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null, e);
        	}
		
		return userDwh;
	}
	

	public String getDataPass() {
		try {
			Properties propDb = new Properties();
			String pathProp = new File("").getAbsolutePath().concat(FOLDER_PATH_PROP.concat(DBPROPERTIES));
			FileInputStream file = new FileInputStream(pathProp);
			propDb.load(file);
			file.close();
            this.setPassDwh(propDb.getProperty("SQL_PASSWORD_DWH"));        
        }catch (Exception e){ 
        	Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null, e);
        	}
		
		return passDwh;
	}
	
	public String getFilePath() {
		try {
			Properties propDb = new Properties();
			String pathProp = new File("").getAbsolutePath().concat(FOLDER_PATH_PROP.concat(DBPROPERTIES));
			FileInputStream file = new FileInputStream(pathProp);
			propDb.load(file);
			file.close();
            this.setFilePath(propDb.getProperty("FILE_PATH"));        
        }catch (Exception e){
        	Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null, e);
        	}
		
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
