package udemy_project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class multiple_ItemsAdded {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	    
	    List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
	    
	    for(int i=0; i<products.size(); i++) {
	    	
	    	String name=products.get(i).getText();
	    	
	    if(name.contains("Brocolli")) {
	    	
	     driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
	     break;
	    	
	    }
	    
	    }
	    	
	    }
	    

	}


