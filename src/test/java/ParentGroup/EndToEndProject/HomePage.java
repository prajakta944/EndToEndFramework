package ParentGroup.EndToEndProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.baseClass;

public class HomePage extends baseClass {
	public static Logger log = LogManager.getLogger(baseClass.class.getName());
	WebDriver driver;

	@Test(dataProvider = "getdata")
	public void SandboxHomePage(String username, String password, String text) throws Exception {

		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(p.getProperty("url"));
		log.info("Navigate to home page");
//		driver.get("https://sso-sandbox.insite360.gilbarco.com/auth/realms/people/protocol/openid-connect/auth?response_type=code&client_id=cloudUI&redirect_uri=https%3A%2F%2Fi360-sandbox.gilbarco.com%2Fcloud-ui%2Fportal%2Fapps%2Fremote-management%2F&state=4a2c4967-8ecd-42b9-8fe6-373fd47f98ec&login=true&scope=openid#/sites");
//		ChromeOptions o = new ChromeOptions();
//		o.setAcceptInsecureCerts(true);s
		LandingPage land = new LandingPage(driver);
//		land.getLogin();
		LoginPage logi = land.getLogin();
		logi.getUsername().sendKeys(username);
		logi.getPassword().sendKeys(password);
		System.out.println(text);
		log.debug(text);
		Thread.sleep(3000);
		logi.getLogin().click();
		ForgotPassword fp = logi.getForgotPassword();
		fp.getUsernameForForgotPass().sendKeys("surve.prajakta915@gmail.com");
		Thread.sleep(3000);
		fp.getInstructions().click();

	}

	@DataProvider
	public Object[][] getdata() {
		Object[][] data = new Object[2][3];
		data[0][0] = "surve.prajakta915@gmail.com";
		data[0][1] = "PrajAnkur@210690";
		data[0][2] = "Restricted User";

		data[1][0] = "rahulshettyacademy";
		data[1][1] = "learning";
		data[1][2] = "UnRestricted User";

		return data;

	}

	@AfterTest
	private void teardown() {
		driver.close();
	}

}
