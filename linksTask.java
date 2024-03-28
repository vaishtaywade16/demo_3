package udemy_project;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class linksTask {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		  WebDriver driver= new ChromeDriver();
		  driver.get("https://www.qaclickacademy.com/");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  
		  //count of all links present in page
		  System.out.println(driver.findElements(By.tagName("a")).size());
		  // to find the all links present in footor, select footor box ,limiting webdriver scope
		 WebElement footordriver= driver.findElement(By.id("footer-part"));
		 System.out.println(footordriver.findElements(By.tagName("a")).size());
		 
		 //select specific block which has no. of links
		 WebElement sitemapdriver=footordriver.findElement(By.cssSelector(".col-lg-3.col-md-6.col-sm-6"));
		System.out.println(sitemapdriver.findElements(By.tagName("a")).size());
		
		//select all links of sitemap 
		for(int i=1;i<sitemapdriver.findElements(By.tagName("a")).size();i++) {
			//create trick to select all link in different window simultaneously
	String clickOnLinks	=Keys.chord(Keys.CONTROL,Keys.ENTER);
	//select that link and click
	sitemapdriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinks);
	}
		//to get tittle of each window
		Set<String>windows=driver.getWindowHandles();
		
		Iterator<String> it =windows.iterator();
		
		while(it.hasNext()) {
			String id=it.next();
			System.out.println(driver.switchTo().window(id).getTitle());
		}
		
		}
}