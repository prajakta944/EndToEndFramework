package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	By signin = By.xpath("//*[@id=\"homepage\"]/header/div[1]/div/nav/ul/li[4]/a");
	By title = By.xpath("//div[@class='text-center']/h2");
	By header = By.cssSelector("div[class*='navbar-static-top']");

	public LandingPage(WebDriver driver) {
		this.driver = driver;

	}

	public LoginPage getLogin() {

		driver.findElement(signin).click();
		LoginPage logi = new LoginPage(driver);
		return logi;

	}

	public WebElement getTitle() {

		return driver.findElement(title);

	}

	public WebElement getheader() {

		return driver.findElement(header);

	}

}
