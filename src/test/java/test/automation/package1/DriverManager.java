package test.automation.package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
	
	private static WebDriver driver;
	
	private DriverManager() {
		
	}
	
	public static WebDriver getDriver() {
		
		if (driver == null) {
			
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	public static void quitDriver() {
		
		if (driver != null) {
			
			driver.quit();
			driver = null;
		}
	}

}
