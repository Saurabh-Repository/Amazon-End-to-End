
package Amazon.Amazon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import Amazon.Base.BaseTest;
import Amazon.PageObjects.CalculationsAndAssertions;
import Amazon.PageObjects.ProductsAdd;
import Amazon.PageObjects.SigninPage;
import Amazon.PageObjects.WindowsAndCart;

public class AmazonTest extends BaseTest {
	WebDriver driver;

	@Test
	public void Amazon() throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// For retrieving the data from Base Class👇🏻
		BaseTest baseTest = new BaseTest();
		Map<String, String> data = baseTest.getData();

		SigninPage signinPage = new SigninPage(driver);
		signinPage.goToWeb();
		signinPage.Actions();
		signinPage.Login(data.get("id"), data.get("password"));

		ProductsAdd productsAdd = new ProductsAdd(driver);
		productsAdd.addingProducts(data.get("product"));

		// Windows Handling and products adding into cart
		WindowsAndCart windowsAndCart = new WindowsAndCart(driver);
		windowsAndCart.windowHandleAndProductAdd();

		// Retrieving all the prices and comparing actual value with displayed value
		CalculationsAndAssertions calculationsAndAssertions = new CalculationsAndAssertions(driver);
		calculationsAndAssertions.Calculations();
		calculationsAndAssertions.Assertions();
		calculationsAndAssertions.TakesScreenshot();

		Thread.sleep(10000);
		driver.quit();

	}

}
