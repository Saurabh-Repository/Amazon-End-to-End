package Amazon.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsAdd {
	WebDriver driver;

	public ProductsAdd(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Search Amazon.in']")
	WebElement productSearch;
	@FindBy(xpath = "(//input[@type='submit'])[1]")
	WebElement searchButt;
	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	WebElement prod1;
	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[2]")
	WebElement prod2;
	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[3]")
	WebElement prod3;

	public void addingProducts(String product) {
		productSearch.sendKeys(product);
		searchButt.click();
		prod1.click();
		prod2.click();
		prod3.click();
	}

}
