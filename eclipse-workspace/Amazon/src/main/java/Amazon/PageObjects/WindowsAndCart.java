package Amazon.PageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowsAndCart {
	WebDriver driver;

	public WindowsAndCart(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@id='productTitle']")
	WebElement getTitleChild1;
	@FindBy(xpath = "//span[@id='productTitle']")
	WebElement getTitleChild2;
	@FindBy(xpath = "//span[@id='productTitle']")
	WebElement getTitleChild3;
	@FindBy(xpath = "//input[@name='submit.add-to-cart']")
	WebElement AddToCartChild1;
	@FindBy(xpath = "//input[@name='submit.add-to-cart']")
	WebElement AddToCartChild2;
	@FindBy(xpath = "//input[@name='submit.add-to-cart']")
	WebElement AddToCartChild3;
	@FindBy(xpath = "//a[@id='nav-cart']")
	WebElement cartButt;

	public void windowHandleAndProductAdd() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId1 = it.next();
		String childId2 = it.next();
		String childId3 = it.next();

		// 1st window
		driver.switchTo().window(childId1);
		System.out.println(getTitleChild1.getText());
		AddToCartChild1.click();

		// 2nd Window
		driver.switchTo().window(childId2);
		System.out.println(getTitleChild2.getText());
		AddToCartChild2.click();
		// 3rd Window
		driver.switchTo().window(childId3);
		System.out.println(getTitleChild3.getText());
		AddToCartChild3.click();

		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());

		cartButt.click();

	}

}
