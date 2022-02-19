package ParentGroup.EndToEndProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.baseClass;

public class ValidateTitle extends baseClass {
	public static Logger log = LogManager.getLogger(baseClass.class.getName());
	WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(p.getProperty("url"));
		log.info("Navigate to home page");
//		driver.get("https://sso-sandbox.insite360.gilbarco.com/auth/realms/people/protocol/openid-connect/auth?response_type=code&client_id=cloudUI&redirect_uri=https%3A%2F%2Fi360-sandbox.gilbarco.com%2Fcloud-ui%2Fportal%2Fapps%2Fremote-management%2F&state=4a2c4967-8ecd-42b9-8fe6-373fd47f98ec&login=true&scope=openid#/sites");
//		ChromeOptions o = new ChromeOptions();
//		o.setAcceptInsecureCerts(true);
	}

	@Test
	public void ValidateHomepageTitle() {

		LandingPage land = new LandingPage(driver);
		land.getTitle().getText();
		Assert.assertEquals(land.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated Title");

	}

	@AfterTest
	private void teardown() {
		driver.close();
	}

}
