package StepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public HomePage(WebDriver driver) {
		super(driver);

	}

	public HomePage() {
		super();
	}

	public HomePage loginSuccessCheck() throws Throwable {

		WebElement element = driver.findElement(By.className("welcome"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		assertEquals("Welcome Preksha", element.getText().trim());
		return new HomePage(driver);

	}

	public HomePage perform_Search(String searchString) throws Throwable {
		driver.findElement(By.id("searchTerm")).click();
		driver.findElement(By.id("searchTerm")).clear();
		driver.findElement(By.id("searchTerm")).sendKeys(searchString);
		driver.findElement(By.id("searchTerm")).click();
		return new HomePage(driver);

	}

	public HomePage userShouldSeeSelectionName(String searchResult) throws Throwable {
		driver.findElement(By.xpath(".//*[contains(@id,'txtInnerContainer')]/div/ul/li[2]/a")).click();
		WebElement element = driver.findElement(By.xpath(".//*[contains(@id,'pagecell')]/section/div[1]/div/h1"));
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		assertEquals(searchResult, element.getText().trim());
		return new HomePage(driver);
	}

	public HomePage performSearchForItem(String searchString) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.id("searchTerm")).click();
		driver.findElement(By.id("searchTerm")).clear();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("searchTerm")).sendKeys(searchString);
		driver.findElement(By.id("searchTerm")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath(".//*[contains(@id,'txtInnerContainer')]/div/ul/li[2]/a"));
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		driver.findElement(By.xpath(".//*[contains(@id,'topProdsList')]/li[2]/div[2]/div/a")).click();
		Thread.sleep(2000);
		return new HomePage(driver);
	}

	public boolean checkForLabel(ArrayList<String> labelList, List<WebElement> listOfLabels) throws Throwable {
		Boolean flag = false;

		List<String> labelsCurrentList = new ArrayList<String>();
		Set<String> store = new HashSet<String>();
		for (int listOfLabelsCounter = 0; listOfLabelsCounter < listOfLabels.size(); listOfLabelsCounter++) {
			labelsCurrentList.add(listOfLabels.get(listOfLabelsCounter).getText());
		}
		for (int listOfLabelsCounter = 0; listOfLabelsCounter < labelsCurrentList.size(); listOfLabelsCounter++) {
			if (labelList.contains(labelsCurrentList.get(listOfLabelsCounter))) {
				flag = true;
				assertEquals(true, flag);
			} else {

				flag = false;
				System.out.println("Failure for" + labelList.get(listOfLabelsCounter));
				assertEquals(false, flag);
			}
		}
		for (String labels : labelsCurrentList) {
			if (store.add(labels) == false) {
				flag = false;
			}
		}
		return flag;
	}

}
