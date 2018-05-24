package StepDefinition;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class BasePage {
	protected WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	ProductDetailPage productDetailPage;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public BasePage() {
	}

	public final void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	}
}
