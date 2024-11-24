package Amazon.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class SigninPage {
	WebDriver driver;

	public SigninPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='nav-action-inner']")
	WebElement signinButt;
	@FindBy(xpath = "//input[@id='ap_email']")
	WebElement userId;
	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueId;
	@FindBy(xpath = "//input[@autocomplete='current-password']")
	WebElement userPassword;
	@FindBy(xpath = "//input[@id='signInSubmit']")
	WebElement submitButt;

	public void Actions() {
		Actions actions = new Actions(driver);
		WebElement signing = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		actions.moveToElement(signing).perform();
	}

	public void Login(String id, String password) {
		signinButt.click();
		userId.sendKeys(id);
		continueId.click();
		userPassword.sendKeys(password);
		submitButt.click();

	}

	public void goToWeb() {
		driver.get("https://www.amazon.in/");
	}

}
