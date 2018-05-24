package StepDefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketSummaryPage extends BasePage {
	WebDriverWait wait;

	public BasketSummaryPage(WebDriver driver) {
		super(driver);
	}

	public BasketSummaryPage viewBasket() throws Throwable {
		driver.findElement(By.id("checkoutSecurelyBtn")).isDisplayed();
		driver.findElement(By.id("checkoutSecurelyBtn")).isEnabled();
		assertEquals(true, driver.findElement(By.id("checkoutSecurelyBtn")).isDisplayed());
		return new BasketSummaryPage(driver);

	}

	public BasketSummaryPage removeItem() throws InterruptedException {
		// scrollDown();
		driver.findElement(By.xpath(".//*[@id='shoppingBasketForm:WebBasketLineWidgetActionVALIDATION_ERROR_EVENT']/table/tbody/tr[3]/td[3]/div[2]/a")).isDisplayed();
		driver.findElement(By.xpath(".//*[@id='shoppingBasketForm:WebBasketLineWidgetActionVALIDATION_ERROR_EVENT']/table/tbody/tr[3]/td[3]/div[2]/a")).isEnabled();
		driver.findElement(By.xpath(".//*[@id='shoppingBasketForm:WebBasketLineWidgetActionVALIDATION_ERROR_EVENT']/table/tbody/tr[3]/td[3]/div[2]/a")).click();
		if (isAlertPresent() == true) {
			Alert alert = null;
			alert.accept();
			System.out.println("Alert is present");

			driver.findElement(By.id("confirmDeleteContinue")).click();
		} else {
			System.out.println("no alert is present");
			driver.findElement(By.id("confirmDeleteContinue")).click();
		}
		return new BasketSummaryPage(driver);

	}

}
