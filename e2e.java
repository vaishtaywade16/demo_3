package udemy_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	    //select on city
	    driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	    Thread.sleep(2000);
	    //select from city
	    driver.findElement(By.xpath("//a[@value='DEL']")).click();
	    // select to city
	    driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
	    
	    //select current date
	    driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
	    //check return calenlender is enable or not
	    if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
	    	System.out.println("its enable");
	    	Assert.assertTrue(true);
	    }
	    else {
	    	Assert.assertTrue(false);
	    }
	    //adults selection
	    System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	    driver.findElement(By.id("divpaxinfo")).click();
	    Thread.sleep(2000);
	    for (int i=1;i<5; i++) 
	    {
	    driver.findElement(By.id("hrefIncAdt")).click();
	    }
	    driver.findElement(By.id("btnclosepaxoption")).click();
	    System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	    // select on family and friends checkbox
	    driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
	    
	    // select search button
	    driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
	    
	}

}
