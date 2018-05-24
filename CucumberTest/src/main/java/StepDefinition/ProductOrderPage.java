package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductOrderPage extends BasePage {
	WebDriverWait wait;

	public ProductOrderPage(WebDriver driver) {
		super(driver);
	}

	public ProductOrderPage addProductToBasket() throws Throwable {

		scrollDown();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='price-break-container']/div/div[2]/div/div[3]/div/button")).isDisplayed();
		driver.findElement(By.xpath(".//*[@id='price-break-container']/div/div[2]/div/div[3]/div/button")).isSelected();
		driver.findElement(By.xpath(".//*[@id='price-break-container']/div/div[2]/div/div[3]/div/button")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='View Basket']")).isEnabled();
		driver.findElement(By.xpath("//button[text()='View Basket']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return new ProductOrderPage(driver);

	}

	public ProductOrderPage checkoutSecurly() throws Throwable {
		Thread.sleep(1000);
		scrollDown();
		driver.findElement(By.id("checkoutSecurelyAndPuchBtn")).isDisplayed();
		driver.findElement(By.id("checkoutSecurelyAndPuchBtn")).isEnabled();
		driver.findElement(By.id("checkoutSecurelyAndPuchBtn")).click();
		return new ProductOrderPage(driver);

	}

}
