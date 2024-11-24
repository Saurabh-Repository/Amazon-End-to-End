package Amazon.Base;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import Amazon.PageObjects.SigninPage;


public class BaseTest {
	
		
	    public Map<String, String> getData() {
	        Map<String, String> dataMap = new HashMap<>();
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Please enter your mobile number or email ID 📧/☎️: ");
			String id = scanner.next();
			
			System.out.println("Please enter your password 🔑: ");
			String password = scanner.next();
			
			System.out.println("Please enter the product you want to search🔍: ");
			String product = scanner.next();
			scanner.close(); 
			System.out.println("Please check your Amazon window now 👻");
	        dataMap.put("id", id);
	        dataMap.put("password", password);
	        dataMap.put("product", product);
	        
	        scanner.close(); 
	        return dataMap;
	    }
	    
	}

//driver.manage().window().maximize();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//return driver;
//}
//
//public LandingPage launchApplication() throws IOException {
//driver = initializeDriver();
//
//LandingPage landingpage = new LandingPage(driver);
//landingpage.goToWeb();
//return landingpage;



