package udemy_project;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class parentchildWindowHandle {

	public static void main(String[] args)  {
  WebDriverManager.chromedriver().setup();
  WebDriver driver= new ChromeDriver();
  driver.get("https://rahulshettyacademy.com/loginpagePractise/");
 
  
  driver.findElement(By.cssSelector(".blinkingText")).click();
  //geting no. of windows handle
  Set<String>window =driver.getWindowHandles();
  //iterate the handle with iterator method
  Iterator<String>it=window.iterator();
  //stores the first window id
	String parentid=it.next();
	//stores the secons window id
	String childid=it.next();
	driver.switchTo().window(childid);
	
	System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
	String emailid=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
	
	driver.switchTo().window(parentid);
	driver.findElement(By.id("username")).sendKeys(emailid);
	}
	

}
