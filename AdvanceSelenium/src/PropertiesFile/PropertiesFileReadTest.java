package PropertiesFile;
//Day 46 15/12/2025
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReadTest {

	public static void main(String[] args) {
		Properties pro=null;
		try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Admin\\Desktop\\AutomationTesting\\AdvanceSelenium\\src\\Resorces\\DemoGuruLoginCre.properties")) {
			
			pro = new Properties();
			pro.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load config.properties file");
		}
		String path = pro.getProperty("chromeBrowserPath");
		System.out.println(path);
		String url = pro.getProperty("url");
		System.out.println(url);
		String UserName=pro.getProperty("UserName");
		System.out.println(UserName);
		String password=pro.getProperty("password");
		System.out.println(password);
		String Username1=pro.getProperty("Username1");
		System.out.println(Username1);
		String Password1=pro.getProperty("Password1");
		System.out.println(Password1);
	}

}
