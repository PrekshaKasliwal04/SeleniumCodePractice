package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods {
	public WebElement element = null;
	public static WebDriver driver;
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void setWebDriver(WebDriver driver) {
		dr.set(driver);
	}

	public String getTextBy(String objectType, String locator) throws Exception {
		WebElement element = driver.findElement(By.className(locator));
		return element.getText().trim();
	}

}
