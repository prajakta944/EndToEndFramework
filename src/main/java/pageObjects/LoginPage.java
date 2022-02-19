package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	By username = By.id("user_email");
	By password = By.id("user_password");
	By login = By.name("commit");
	By forgotpass = By.cssSelector("a[class='link-below-button']");
//	By username = By.id("username");
//	By password = By.id("password");
//	By login = By.name("login");

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement getUsername() {

		return driver.findElement(username);

	}

	public WebElement getPassword() {

		return driver.findElement(password);

	}

	public WebElement getLogin() {

		return driver.findElement(login);

	}

	public ForgotPassword getForgotPassword() {

		driver.findElement(forgotpass).click();
		ForgotPassword fp = new ForgotPassword(driver);
		return fp;

	}

}
