package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;
	private By usernamefp = By.id("user_email");
	private By instruc = By.name("commit");

	public ForgotPassword(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement getUsernameForForgotPass() {

		return driver.findElement(usernamefp);

	}

	public WebElement getInstructions() {

		return driver.findElement(instruc);

	}

}
