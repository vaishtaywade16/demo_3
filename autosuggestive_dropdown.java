package udemy_project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class autosuggestive_dropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	   driver.findElement(By.id("autosuggest")).sendKeys("ind");
	   List<WebElement> options=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
	    for( WebElement option:options) {
	    	if(option.getText().equalsIgnoreCase("india")) {
	    		option.click();
	    	}
	    }
	}

}
