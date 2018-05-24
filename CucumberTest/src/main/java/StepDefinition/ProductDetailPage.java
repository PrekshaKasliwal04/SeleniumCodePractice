package StepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends BasePage {

	HomePage homePage;
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}

	public ProductDetailPage returnSearchResult(String filterHeading) throws Throwable {
		driver.findElement(By.xpath(".//*[contains(@id,'txtInnerContainer')]/div/ul/li[2]/a")).click();
		driver.findElement(By.xpath(".//*[contains(@id,'filters')]/div/div/rs-facets/a[1]")).click();
		driver.findElement(By.id("4294313975")).click();
		driver.findElement(By.xpath("//button[text()='Apply filters']")).click();
		WebElement element = driver.findElement(By.xpath(".//*[contains(@id,'pagecell')]/section/div[1]/div/h1"));
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		assertEquals(filterHeading, element.getText().trim());
		return new ProductDetailPage(driver);

	}

	public ProductDetailPage resultTableHeadingsShouldBeAsExpected() throws Throwable {
		String tableHeaderNames[] = { "", "Description", "Price", "Charge Current", "Input Voltage", "Model Number", "Output Voltage", "Plug Type", "Number of Charge Stages", "Output Voltage @ Charge Current", "Dimensions", "Weight", "Battery Type Charged", "Cable Length", "IP Rating", "Indoor/Outdoor", "Input Current", "Input Phase", "Maximum Output Power", "Mounting Style", "Number of Charging Units", "Operating Temperature Range", "Series", "Standards Met", "User Interface",
				"Vehicle Connector" };
		ArrayList<String> tableHeaderList = new ArrayList<String>(Arrays.asList(tableHeaderNames));
		List<WebElement> listOfTableLabels = (List<WebElement>) driver.findElements(By.xpath(".//*[contains(@id,'results-table-header')]/thead/tr[1]/th"));
		HomePage homePage = new HomePage();
		assertEquals(true, homePage.checkForLabel(tableHeaderList, listOfTableLabels));
		return new ProductDetailPage(driver);

	}

	public ProductDetailPage userSeeAllFilterOption() throws Throwable {
		driver.findElement(By.xpath(".//*[contains(@id,'txtInnerContainer')]/div/ul/li[2]/a")).click();

		String filterNames[] = { "Brand", "Charge Current", "Input Voltage", "Model Number", "Output Voltage", "Plug Type", "Number of Charge Stages", "Output Voltage @ Charge Current", "Dimensions", "Weight", "Battery Type Charged", "Cable Length", "IP Rating", "Indoor/Outdoor", "Input Current", "Input Phase", "Maximum Output Power", "Mounting Style", "Number of Charging Units", "Operating Temperature Range", "Series", "Standards Met", "User Interface", "Vehicle Connector" };
		ArrayList<String> filterList = new ArrayList<String>(Arrays.asList(filterNames));
		List<WebElement> listOfLabels = (List<WebElement>) driver.findElements(By.xpath(".//*[contains(@id,'filters')]/div/div/rs-facets/a"));
		HomePage homePage = new HomePage();
		assertEquals(true, homePage.checkForLabel(filterList, listOfLabels));
		return new ProductDetailPage(driver);

	}

	public ProductDetailPage userSeeSelectedName(String searchResult) throws Throwable {
		driver.findElement(By.xpath(".//*[contains(@id,'txtInnerContainer')]/div/ul/li[2]/a")).click();
		WebElement element = driver.findElement(By.xpath(".//*[contains(@id,'pagecell')]/section/div[1]/div/h1"));
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		assertEquals(searchResult, element.getText().trim());
		return new ProductDetailPage(driver);
	}
}
