package test.automation.package1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
	@BeforeSuite
	public void setUp() {
		DriverManager.getDriver();
	}
	
	@AfterSuite
	public void tearDownSuite() {
		DriverManager.quitDriver();
	}
	
	public WebDriver getDriver() {
		
		return DriverManager.getDriver();
	}

}
