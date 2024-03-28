package udemy_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class updated_Dropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	    //check on family checkbox 
	    driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
	    // get the size of all checkbox
	    System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
	    
	    // check the family and frs checkbox is selected or not
	    System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
	     
	   Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
	   
	   System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	    driver.findElement(By.id("divpaxinfo")).click();
	    Thread.sleep(2000);
	    for (int i=1;i<5; i++) 
	    {
	    driver.findElement(By.id("hrefIncAdt")).click();
	    }
	    driver.findElement(By.id("btnclosepaxoption")).click();
	    System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	    
	   
	    }

}
