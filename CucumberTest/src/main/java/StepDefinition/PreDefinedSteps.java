package StepDefinition;

import java.io.File;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PreDefinedSteps extends BasePage {
	LoginPage loginPage;
	HomePage homePage;
	ProductDetailPage productDetailPage;
	ProductOrderPage productOrderPage;
	BasketSummaryPage basketSummaryPage;

	public PreDefinedSteps(WebDriver driver) {
		super(driver);
	}

	public PreDefinedSteps() {
		super();
	}

	@Before
	public WebDriver startUp() {

		String path = System.getProperty("user.dir") + File.separator + "lib" + File.separator + "geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", path);
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");

		driver = new FirefoxDriver();
		return driver;
	}

	@After
	public void tearDown() throws InterruptedException {
		// below code is for taking screenshot when test fails
	/*	Scenario s = null;
		if (s.isFailed())
			try {

				s.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "failure.png");

			} catch (ClassCastException cce) {
				cce.printStackTrace();
			}*/
		driver.quit();
	}

	@Given("^Login with User \"([^\"]*)\" Password \"([^\"]*)\" on website \"([^\"]*)\"$")
	public void login_with_User_Password_on_website(String user, String pwd, String url) throws Throwable {
		loginPage = new LoginPage(driver);
		loginPage.login_with_User_Password(driver, user, pwd, url);
	}

	@Given("^User logs in successfully$")
	public void login_successfull() throws Throwable {
		homePage = new HomePage(driver);
		homePage.loginSuccessCheck();

	}

	@When("^Perform Search for \"([^\"]*)\" and apply filter$")
	public void perform_Search_for(String searchString) throws Throwable {
		homePage = new HomePage(driver);
		homePage.perform_Search(searchString);
	}

	@Then("^Results should include \"([^\"]*)\"$")
	public void results_should_include(String filterHeading) throws Throwable {
		productDetailPage = new ProductDetailPage(driver);
		productDetailPage.returnSearchResult(filterHeading);

	}

	@Then("^User should see selection name as \"([^\"]*)\"$")
	public void user_should_see_selection_name_as(String searchResult) throws Throwable {
		productDetailPage = new ProductDetailPage(driver);
		productDetailPage.userSeeSelectedName(searchResult);
	}

	@Then("^All filter headings should be as expected$")
	public void user_should_be_able_to_see_all_filter_options() throws Throwable {
		productDetailPage = new ProductDetailPage(driver);
		productDetailPage.userSeeAllFilterOption();
	}

	@Then("^Result table headings should be as expected$")
	public void result_table_headings_should_be_as_expected() throws Throwable {
		productDetailPage = new ProductDetailPage(driver);
		productDetailPage.resultTableHeadingsShouldBeAsExpected();

	}

	@When("^Perform Search for \"([^\"]*)\" and select item$")
	public void perform_Search_for_item(String searchString) throws Throwable {
		homePage = new HomePage(driver);
		homePage.performSearchForItem(searchString);
	}

	@When("^Adds item to basket and proceed to checkout securly$")
	public void adds_item_to_basket_and_proceed_to_checkout_securly() throws Throwable {
		productOrderPage = new ProductOrderPage(driver);
		productOrderPage.addProductToBasket();
		productOrderPage.checkoutSecurly();
	}

	@Then("^User should see Proceed for Payment$")
	public void user_should_be_able_to_Proceed_for_Payment() throws Throwable {
		basketSummaryPage = new BasketSummaryPage(driver);
		basketSummaryPage.viewBasket();
	}

	@Then("^User should able to remove Item from Cart$")
	public void user_should_be_able_to_Remove_Item() throws Throwable {
		basketSummaryPage = new BasketSummaryPage(driver);
		basketSummaryPage.removeItem();
	}

	@When("^Add item to basket$")
	public void add_item_to_basket() throws Throwable {
		productOrderPage = new ProductOrderPage(driver);
		productOrderPage.addProductToBasket();
	}
}
