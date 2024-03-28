package udemy_project;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class multiple_items_with_array {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// cons::when we want any items to load in 2sec and if we applied implicite wait to 5 sec then that 
		//is bug and implicite wait hiding that performance issue due to 5 sec
		//Wait is an interface and WebDriverWait and FluentWait are the classes which impliments Wait interface
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
	
	     String[] itemsNeeded= {"Brocolli","Cucumber","Beetroot","Carrot"};
	    
	    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	    Thread.sleep(5);
	    additems(driver,itemsNeeded);
	    
	     

	     driver.findElement(By.cssSelector("img[alt='Cart']")).click();
	    driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promocode")));
	     
	     driver.findElement(By.cssSelector(".promocode")).sendKeys("rahulshettyacademy");
	 
	     driver.findElement(By.cssSelector(".promoBtn")).click();  
	     w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoinfo")));
	     System.out.println(driver.findElement(By.cssSelector(".promoinfo")).getText());
	 driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	}
	




    public static  void additems(WebDriver driver,String[] itemsNeeded) throws InterruptedException {
    	int j=0;
	List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    
    
    
    for(int i=0; i<products.size(); i++) {
   	 String[] name=products.get(i).getText().split("-");
   	  String formatedname=name[0].trim();
   	 
   List<String> itemsNeededList = Arrays.asList(itemsNeeded)  ;
  
   if(itemsNeededList.contains(formatedname)) {
   	j++;
   	driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
   	
   	if( j==4) {
	    	break;
	    }
   	
   }
   
   	  
     }
}
}