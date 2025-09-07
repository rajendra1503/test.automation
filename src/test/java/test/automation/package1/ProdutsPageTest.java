package test.automation.package1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProdutsPageTest extends BaseTest {

	String baseUrl = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";

	@Test
	public void validateAllProductsPageIsDisplayed() {

		getDriver().get(baseUrl);

		getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();

		getDriver().findElement(By.linkText("View all products")).click();

		Assert.assertTrue(getDriver().findElement(By.xpath("//div[@class='content']/h2")).isDisplayed());
		String heading = getDriver().findElement(By.xpath("//div[@class='content']/h2")).getText().trim();
		Assert.assertEquals(heading, "List of Products");
	}
}
