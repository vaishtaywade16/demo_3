package udemy_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dynamic_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	   
	    driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[@value='DEL']")).click();
	    
	    //select 2nd index bcoz goa is also present in departure city which has index 1
	    driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
	    //or in other way parentxpath of full selection city ( )space xpath of that city
	    // ex: //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOI']
	  
	    
	    //select current calender date with cssselector --->.classname
	    //if spaces between class name then remove that space abd add dot
	    driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
	    
	    //checking the returndate calender is enable or not by using value of attribute which is changing 
	    if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
	    	System.out.println("its enable");
	    	Assert.assertTrue(true);
	    }
	    else {
	    	Assert.assertTrue(false);
	    }
	}

}
