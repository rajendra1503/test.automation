package test.automation.package1;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginTests extends BaseTest {

	String baseUrl = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";

	String expectedTitle1 = "Web Orders Login";
	String actualTitle1 = null;

	String expectedTitle2 = "Web Orders";
	String actualTitle2 = null;

	String expectedErrorMessage = "Invalid Login or Password.";
	String actualErrorMessage = null;

	@Test(priority = 1)
	public void validateLoginPageIsDisplayed() {

		getDriver().get(baseUrl);
		actualTitle1 = getDriver().getTitle();
		Assert.assertEquals(actualTitle1, expectedTitle1);
	}

	@Test(priority = 2)
	public void validateErrorMessageForInvalidLogin() {

		getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys("test123");
		getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();

		WebElement lblErrorMsg = getDriver().findElement(By.xpath("//span[@id='ctl00_MainContent_status']"));
		Assert.assertTrue(lblErrorMsg.isDisplayed());
		actualErrorMessage = lblErrorMsg.getText().trim();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

	@Test(priority = 3)
	public void validateWebOrdersPageIsDisplayedOnValidLogin() {

		getDriver().findElement(By.id("ctl00_MainContent_username")).clear();
		getDriver().findElement(By.id("ctl00_MainContent_password")).clear();

		getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();

		actualTitle2 = getDriver().getTitle();
		Assert.assertEquals(actualTitle2, expectedTitle2);
	}

}
