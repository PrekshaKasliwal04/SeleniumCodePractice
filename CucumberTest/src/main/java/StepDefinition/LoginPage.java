package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	// public Webdriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public LoginPage login_with_User_Password(WebDriver driver, String user, String pwd, String url) throws Throwable {
		driver.manage().window().maximize();
		driver.navigate().to(url);
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("j_password")).clear();
		driver.findElement(By.name("j_password")).sendKeys(pwd);
		driver.findElement(By.name("loginBtn")).click();
		return new LoginPage(driver);

	}

}
