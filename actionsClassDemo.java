package udemy_project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class actionsClassDemo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		Actions action = new Actions(driver);
		//moving to specific element which is autosuggested
		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		
	WebElement searchbox= driver.findElement(By.id("twotabsearchtextbox"));
	//key.shift means enter capital letters
	action.moveToElement(searchbox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().perform();
	action.contextClick(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
	}
	

}
